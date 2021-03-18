import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Payment } from '../models/payment.model';
import { ConstantService } from './constantService';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  static BASE_URL = ConstantService.API_GATEWAY_BASE_URL + "payments";

  constructor(private _httpClient: HttpClient) { }

  insertPayment(payment: Payment): Observable<Payment> {
    return this._httpClient.post<Payment>(PaymentService.BASE_URL, payment);
  }
}
