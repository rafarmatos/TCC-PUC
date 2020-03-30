import { Component, OnInit } from '@angular/core';
import {LoginService} from '../../security/login/login.service';
import {User} from '../../security/login/user.model';

@Component({
  selector: 'app-sica-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {


  private sidebarVisible: boolean;

  constructor(private loginService: LoginService) {
    this.sidebarVisible = false;
  }

  ngOnInit() {

  }

  user(): User {
      return this.loginService.getUser();
  }

  isLoggedIn(): boolean {
    return this.loginService.isLoogedIn();
  }

  login() {
    this.loginService.handleLogin()
  }

  logout() {
    this.loginService.logout()
  }

  getMiniaturaPerfil(): string{
    return this.loginService.getMiniaturaPerfil();
  }


  sidebarClose() {
    const html = document.getElementsByTagName('html')[0];
    const toggleButton = document.getElementsByClassName('navbar-toggler')[0];
    // console.log(html);
    toggleButton.classList.remove('toggled');
    this.sidebarVisible = false;
    html.classList.remove('nav-open');
  }

}
