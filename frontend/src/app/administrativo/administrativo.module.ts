
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {SharedModule} from '../shared/shared.module';
import {RouterModule, Routes} from '@angular/router';
import {EnvolvidosComponent} from './envolvidos/envolvidos.component';
import {AdministrativoComponent} from './administrativo.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {EnvolvidosService} from './envolvidos/envolvidos.service';
import {NgxLoadingModule} from 'ngx-loading';


const ROUTES: Routes = [
  { path: 'envolvidos', component: EnvolvidosComponent },
/*  {path:  'admin', loadChildren: './admin/admin.module#AdminModule',
    canLoad: [LoggedInGuard], canActivate: [LoggedInGuard], data: {tipoContaExpected: '2'} },*/
  {path: '', component: AdministrativoComponent}
];

@NgModule({
  declarations: [
    AdministrativoComponent,
    EnvolvidosComponent,
  ],
  imports: [SharedModule,
    RouterModule.forChild(ROUTES), NgxLoadingModule, NgbModule
  ],
  providers: [
    EnvolvidosService,
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})

export class AdministrativoModule {}
