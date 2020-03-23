import {Component, OnInit} from '@angular/core';

import {Utility} from '../../shared/utility.service';
import {Router} from '@angular/router';
import {ngxLoadingAnimationTypes} from 'ngx-loading';
import 'rxjs/add/observable/interval';
import 'rxjs/add/operator/takeWhile';
import {NotificationService} from '../../shared/massages/snackbar/notification.service';

declare let PagSeguroLightbox: any;

const PrimaryGreen = '#82C83C';
const SecondaryGrey = '#ccc';

@Component({
  selector: 'app-consultas-agendadas',
  templateUrl: './incidentes.component.html',
  styleUrls: ['./incidentes.component.scss']
})
export class IncidentesComponent implements OnInit {

  // loading
  public loading = false;
  public ngxLoadingAnimationTypes = ngxLoadingAnimationTypes;
  public primaryColour = PrimaryGreen;
  public secondaryColour = SecondaryGrey;


  constructor(private router: Router,
              private utility: Utility,
              private notificationService: NotificationService) {
  }

  ngOnInit() {
  }


}
