import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MobileComponent } from './mobile/mobile.component';
import { CharityComponent } from './charity/charity.component';
import { FinancialComponent } from './financial/financial.component';
import {FormsModule} from '@angular/forms';
import {PayBoxService} from './service/paybox.service';
import {HttpClient, HttpClientModule, HttpHandler} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    MobileComponent,
    CharityComponent,
    FinancialComponent
  ],
  imports: [
    FormsModule,
    HttpClientModule,
    BrowserModule
  ],
  providers: [PayBoxService, HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
