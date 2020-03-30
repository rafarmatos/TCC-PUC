import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SICA_API} from '../../app.api';
import {User} from './user.model';
import {NavigationEnd, Router} from '@angular/router';
import {tap, filter} from 'rxjs/operators';
import {Utility} from "../../shared/utility.service";
import {Conta} from "../../shared/models/conta.model";
import { of } from 'rxjs';

@Injectable()
export class LoginService {
  user: User;
  conta: Conta;
  isPiscologo: boolean
  lastUrl: string

  isLoogedIn(): boolean {
    this.user = this.getUser();
    return this.user != null
  }


  constructor (private http: HttpClient, private router: Router, private utility: Utility) {
    this.router.events.pipe(
      filter(e => e instanceof NavigationEnd))
      .subscribe((e: NavigationEnd) => {
        this.lastUrl = e.url
        // Ao construir service, se já tiver logado, preencher com os dados do usuario
        if (this.isLoogedIn()){
          this.preencheDadosUsuario();
        }
      });
  }

  getUser(): User {
    this.user = JSON.parse(localStorage.getItem('user' ));
    return this.user;
  }

  atualizaImagem(imagem: string){
    this.user.urFotoPerfil = imagem;
    this.updateLocalStorge();
  }

  getMiniaturaPerfil(){
    return this.utility.getMiniaturaPerfil(this.user.urFotoPerfil)
  }

  login(email: string, password: string): Observable<User> {
    return this.http.post<User>(`${SICA_API}/Auth/LogIn`,
      {userName: email, password: password}).pipe(
        tap(user => this.user = user,
            error => console.log(error),
          () => this.updateLocalStorge() ));
  }

  getContaUsuario(): Observable<Conta>{
    console.log('getContaUsuario');
    if (this.getUser() != null ){
      return this.http.get<Conta>(`${SICA_API}/Conta/ObterContaPorId`, {params: {idConta: this.getUser().idConta.toString()}});
    }else{
      return of(null);
    }

  }

  preencheDadosUsuario() {
    this.getContaUsuario().subscribe(conta => {
      this.conta = conta;
      this.isPiscologo = conta.tpConta === 2 || conta.tpConta === 1;
      console.log('tipo conta' + this.conta.tpConta);
    })
  }

  updateLocalStorge(){
    localStorage.setItem('user',  JSON.stringify(this.user));
  }

  handleLogin(path: string = this.lastUrl) {
    this.router.navigate(['/login', btoa(path)])
  }


  logout() {
    localStorage.clear();
    this.user = undefined;
    this.router.navigate(['/home'])
  }

  getRoute (){
    this.router.getCurrentNavigation();
  }

}
