import {Component, ElementRef, OnInit} from '@angular/core';
import {Location} from '@angular/common';
import {LoginService} from '../security/login/login.service';
import {Conta} from '../shared/models/conta.model';

@Component({
  selector: 'app-sica-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  private toggleButton: any;
  private sidebarVisible: boolean;
  private conta: Conta;


  constructor(public location: Location, private element: ElementRef, private loginService: LoginService) {
    this.sidebarVisible = false;
  }

  ngOnInit() {
    const navbar: HTMLElement = this.element.nativeElement;
    this.toggleButton = navbar.getElementsByClassName('navbar-toggler')[0];
    if (this.loginService.isLoogedIn()) {
      this.loginService.getContaUsuario().subscribe(conta => {
        this.conta = conta;
      });
    }
  }



  sidebarOpen() {
    const toggleButton = this.toggleButton;
    const html = document.getElementsByTagName('html')[0];
    setTimeout(function() {
      toggleButton.classList.add('toggled');
    }, 500);
    html.classList.add('nav-open');

    this.sidebarVisible = true;
  }
  sidebarClose() {
    const html = document.getElementsByTagName('html')[0];
    // console.log(html);
    this.toggleButton.classList.remove('toggled');
    this.sidebarVisible = false;
    html.classList.remove('nav-open');
  }
  sidebarToggle() {
    window.scrollTo(0, 0);
    // const toggleButton = this.toggleButton;
    // const body = document.getElementsByTagName('body')[0];
    if (this.sidebarVisible === false) {
      this.sidebarOpen();
    } else {
      this.sidebarClose();
    }
  }

  isPsicologo() {

    return this.loginService.isPiscologo;
  }

  isHome() {
    const titlee = this.location.prepareExternalUrl(this.location.path());

    if ( titlee === '/home' ) {
      return true;
    } else {
      return false;
    }
  }
  isDocumentation() {
    const titlee = this.location.prepareExternalUrl(this.location.path());
    if ( titlee === '/documentation' ) {
      return true;
    } else {
      return false;
    }
  }

  isLoggedIn(): boolean {
    return this.loginService.isLoogedIn();
  }

}
