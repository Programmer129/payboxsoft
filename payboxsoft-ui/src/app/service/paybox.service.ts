import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';

@Injectable()
export class PayBoxService {

  constructor(private httpClient: HttpClient) {
  }

  getPrePrice(amount: number, service: string): Observable<{}> {
    const params = new HttpParams().set('amount', amount.toString()).set('service', service);
    return this.httpClient.get(`${environment.baseUrl}/paybox/products/pre-price`, {params: params});
  }

  transferToMobile(mobileNumber: string, amount: number, service: string): Observable<{}> {
    const body = {
      mobileNumber,
      amount,
      service
    };
    console.log(body);
    return this.httpClient.post(`${environment.baseUrl}/paybox/products/mobile`, body);
  }

  transferToCharity(personalNumber: string, mobileNumber: string, amount: number, service: string): Observable<{}> {
    const body = {
      personalNumber,
      amountAndNumber: {
        mobileNumber,
        amount,
        service
      }
    };
    console.log(body);
    return this.httpClient.post(`${environment.baseUrl}/paybox/products/charity`, body);
  }

  transferToFinancials(accountNumber: string,
                       personalNumber: string,
                       mobileNumber: string, amount: number, service: string): Observable<{}> {
    const body = {
      accountNumber,
      amountAndPersonalInfo: {
        personalNumber,
        amountAndNumber: {
          mobileNumber,
          amount,
          service
        }
      }
    };
    console.log(body);
    return this.httpClient.post(`${environment.baseUrl}/paybox/products/financials`, body);
  }
}
