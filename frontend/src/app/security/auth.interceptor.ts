
import {throwError as observableThrowError, Observable, of} from 'rxjs';

import {catchError} from 'rxjs/operators';
import {
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpHeaders,
  HttpInterceptor,
  HttpRequest
} from '@angular/common/http';
import {Injectable, Injector} from '@angular/core';
import {LoginService} from './login/login.service';
import {Router} from '@angular/router';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private injector: Injector, private router: Router) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const loginService = this.injector.get(LoginService);

    if (loginService.isLoogedIn()) {
      const authRequest = request.clone(
        {setHeaders: {'Authorization': `Bearer ${loginService.user.tkAuthorization}`}});
      return next.handle(authRequest).pipe(catchError((err: any) => {
        if (err instanceof HttpErrorResponse && err.status === 401) {
          loginService.logout();
          this.router.navigate(['/login'], {
            queryParams: {
              redirectTo: document.location.pathname
            }
          });

          // this response is handled
          // stop the chain of handlers by returning empty
          return <Observable<HttpEvent<any>>> of({});
        }

        // rethrow so other error handlers may pick this up
        return observableThrowError(err);
      }));

    } else {
      return next.handle(request);
    }
  }
}
