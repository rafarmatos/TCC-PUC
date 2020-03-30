import {CUSTOM_ELEMENTS_SCHEMA, LOCALE_ID, ModuleWithProviders, NgModule} from '@angular/core';
import {InputComponent} from './input/input.component';
import {RadioComponent} from './radio/radio.component';
import {RatingComponent} from './rating/rating.component';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {SnackbarComponent} from './massages/snackbar/snackbar.component';
import {NotificationService} from './massages/snackbar/notification.service';
import {LoginService} from '../security/login/login.service';
import {LoggedInGuard} from '../security/loggedin.guard';
import {AuthInterceptor} from '../security/auth.interceptor';
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {ImageUploadComponent} from './image-upload/image-upload.component';
import {ImageUploadService} from './image-upload/image-upload.service';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FlexLayoutModule} from '@angular/flex-layout';
import {JwBootstrapSwitchNg2Module} from 'jw-bootstrap-switch-ng2';
import {AngularMultiSelectModule} from 'angular2-multiselect-dropdown';
import {MatButtonModule, MatCheckboxModule} from '@angular/material';
import { registerLocaleData } from '@angular/common';
import ptBr from '@angular/common/locales/pt';

import {NgxLoadingModule} from 'ngx-loading';
registerLocaleData(ptBr);


@NgModule({
  declarations: [
    InputComponent,
    RadioComponent,
    RatingComponent,
    SnackbarComponent,
    ImageUploadComponent],
  imports: [
    NgbModule.forRoot(),
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    FlexLayoutModule,
    JwBootstrapSwitchNg2Module,
    AngularMultiSelectModule,
    MatButtonModule,
    MatCheckboxModule,
    NgxLoadingModule,
  ],
  exports: [
    InputComponent,
    RadioComponent,
    RatingComponent,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    SnackbarComponent,
    ImageUploadComponent,
    AngularMultiSelectModule,
    MatButtonModule,
    MatCheckboxModule]

})

export class SharedModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: SharedModule,
      providers: [
        NotificationService,
        LoginService,
        ImageUploadService,
        LoggedInGuard,
        [{provide: LOCALE_ID, useValue: 'pt-PT'}],
        {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}]
    };
  }
}

