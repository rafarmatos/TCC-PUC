import {
  ActivatedRouteSnapshot,
  CanActivate,
  CanLoad,
  Route,
  Router,
  RouterStateSnapshot,
  UrlSegment
} from '@angular/router';
import {Injectable} from '@angular/core';
import {LoginService} from './login/login.service';

@Injectable()
export class LoggedInGuard implements CanLoad, CanActivate {
  constructor (private loginService: LoginService, private router: Router) {}


  checkAuthentication(path: string, tipoContaExpected?: string): boolean {
    const loggedIn = this.loginService.isLoogedIn();
    console.log('is loggedin: '+loggedIn)

    this.loginService.getContaUsuario().subscribe( conta => {
      if (tipoContaExpected != null) {
        if (!loggedIn || !(conta.tpConta === 2 || conta.tpConta === 1)) {
          console.log('acesso negado: não possui permissão');
          this.router.navigate(['/administrativo']);
        }
      } else {
        if (!loggedIn) {
          console.log('acesso negado: não esta logado');
          console.log(path);
          this.loginService.handleLogin(`/${path}`);
        }
      }
    });



    return loggedIn;
  }

  canLoad(route: Route, segments: UrlSegment[]): boolean {

    const fullPath = segments.reduce((path, currentSegment) => {
      return `${path}/${currentSegment.path}`;
    }, '');

    return this.checkAuthentication(fullPath);
  }

  /*canLoad(route: Route): boolean {
    console.log('canLoad');
    console.log(route.path);
    console.log(route.pathMatch);
    return this.checkAuthentication(route.path);

  }
*/
  canActivate(activatedRoute: ActivatedRouteSnapshot, routerState: RouterStateSnapshot): boolean {
    console.log('canActivated');

    if (activatedRoute.data.tipoContaExpected != null) {
      return this.checkAuthentication(activatedRoute.routeConfig.path, activatedRoute.data.tipoContaExpected);
    } else {
      return this.checkAuthentication(activatedRoute.routeConfig.path);
    }
  }
}
