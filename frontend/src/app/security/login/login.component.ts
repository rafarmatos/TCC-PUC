import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {LoginService} from './login.service';
import {NotificationService} from '../../shared/massages/snackbar/notification.service';
import {ActivatedRoute, Router} from '@angular/router';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'mt-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  navigateTo: string;
  navigateToAgenda: string;
  constructor(private fb: FormBuilder,
              private loginService: LoginService,
              private notificationService: NotificationService,
              private activatedRoute: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.loginForm = this.fb.group({
      email: this.fb.control('', [Validators.required, Validators.email]),
      password: this.fb.control('', [Validators.required])
    });

    //Redirecionamento
    //voltar para pagina q exige autenticação
    this.navigateTo = this.activatedRoute.snapshot.params['to' ] || btoa('/');

    //voltar para outro tipo de pagina
    this.activatedRoute.queryParams.subscribe(params => {
      this.navigateToAgenda = params['toAgenda'];
      console.log(`parametro agenda ${this.navigateToAgenda}`);
    });



   const body = document.getElementsByTagName('body')[0];
    body.classList.add('full-screen');
    body.classList.add('register');
    const navbar = document.getElementsByTagName('nav')[0];
    /*navbar.classList.add('navbar-transparent');*/
    if (navbar.classList.contains('nav-up')) {
      navbar.classList.remove('nav-up');
    }
  }

  ngOnDestroy(){
    var body = document.getElementsByTagName('body')[0];
    body.classList.remove('full-screen');
    body.classList.remove('register');
    /*var navbar = document.getElementsByTagName('nav')[0];
    navbar.classList.remove('navbar-transparent');*/
  }

  login() {
    this.loginService.login(this.loginForm.value.email,
      this.loginForm.value.password).subscribe(user => {
          this.notificationService.notify(`Bem vindo, ${user.dsNome}`);
          this.loginService.updateLocalStorge();
          this.loginService.preencheDadosUsuario();
      },
      response => {
        localStorage.clear();
        this.notificationService.notify(response.error)
      },
      () => {
        if (this.isEmpty(this.navigateToAgenda)){
          console.log(`Será redirecionado pagina anterior`)
          this.router.navigate([atob(this.navigateTo)])
        }else{
          console.log(`Será redirecionado para agenda ${this.navigateToAgenda}.`)
          this.router.navigate([`/agenda/${this.navigateToAgenda}`]);
        }

      }
      )
  }

  getMiniaturaPerfil(): string{
    return this.loginService.getMiniaturaPerfil();
  }

  isEmpty(str) {
    return (!str || 0 === str.length);
  }

}
