import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  menu = true;
  charity = false;
  mobile = false;
  financial = false;

  loadMobile() {
    this.menu = false;
    this.mobile = true;
  }

  loadCharity() {
    this.menu = false;
    this.charity = true;
  }

  loadUtility() {
    this.menu = false;
    this.charity = true;
  }

  loadFinancial() {
    this.menu = false;
    this.financial = true;
  }

  goBack() {
    location.reload();
  }
}
