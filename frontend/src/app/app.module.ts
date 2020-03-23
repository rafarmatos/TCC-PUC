import {BrowserModule} from '@angular/platform-browser';
import {Component, NgModule} from '@angular/core';

import {ROUTES} from './app.routing';


import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ExtraOptions, PreloadAllModules, RouterModule} from '@angular/router';
import {FooterComponent} from './shared/footer/footer.component';
import {HttpClientModule} from '@angular/common/http';
import {SharedModule} from './shared/shared.module';
import {UserDetailComponent} from './header/user-detail/user-detail.component';
import {LoginComponent} from './security/login/login.component';
import {HeaderComponent} from './header/header.component';
import {Utility} from './shared/utility.service';
import {AngularMultiSelectModule} from 'angular2-multiselect-dropdown';
import {NgxLoadingModule} from 'ngx-loading';


const routerOptions: ExtraOptions = {
  useHash: false,
  anchorScrolling: 'enabled',
  preloadingStrategy: PreloadAllModules
  // ...any other options you'd like to use
};

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    FooterComponent,
    UserDetailComponent,
    HeaderComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AngularMultiSelectModule,
    HttpClientModule,
    SharedModule.forRoot(),
    RouterModule.forRoot(ROUTES, routerOptions),
    NgxLoadingModule.forRoot({})
  ],
  providers: [
    Utility
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
