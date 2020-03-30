import {Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {LoggedInGuard} from './security/loggedin.guard';
import {LoginComponent} from './security/login/login.component';


export const ROUTES: Routes = [
  /*pseu*/
  {path: 'home', component: HomeComponent},
  {path: 'login/:to', component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'administrativo',
    loadChildren: './administrativo/administrativo.module#AdministrativoModule',
    canLoad: [LoggedInGuard],
    canActivate: [LoggedInGuard]},
  {path: '', redirectTo: 'home', pathMatch: 'full'}
];

