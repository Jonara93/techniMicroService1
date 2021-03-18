import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Delivery } from '../models/delivery.model';
import { ConstantService } from './constantService';

@Injectable({
  providedIn: 'root'
})
export class DeliveryService {

  static BASE_URL = ConstantService.API_GATEWAY_BASE_URL + "deliveries";

  constructor(private _httpClient: HttpClient) { }

  getAll(): Observable<Delivery[]> {
    return this._httpClient.get<Delivery[]>(DeliveryService.BASE_URL);
  }

  getById(id: number): Observable<Delivery> {
    return this._httpClient.get<Delivery>(DeliveryService.BASE_URL + '/' + id);
  }

  insertDelivery(deliveryToInsert: Delivery): Observable<any> {
    return this._httpClient.post<any>(DeliveryService.BASE_URL, deliveryToInsert);
  }
}
