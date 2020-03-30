import {Component, OnInit} from '@angular/core';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

    model = {
        left: true,
        middle: false,
        right: false
    };
    date: Date = new Date();
    public loading = false;

    constructor() { }

    ngOnInit() {

      window.scrollTo(0, 0);

      const header = document.getElementsByTagName('nav')[0];
      header.classList.remove('ocultar');

        const body = document.getElementsByTagName('body')[0];
        body.classList.add('presentation-page');
        body.classList.add('loading');

    }
    ngOnDestroy() {
        const body = document.getElementsByTagName('body')[0];
        body.classList.remove('presentation-page');
        body.classList.remove('loading');
       window.scrollTo(0, 0);
    }




}
