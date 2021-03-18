import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../models/order.model';
import { Product } from '../models/product.model';
import { ConstantService } from './constantService';
import { ProductsService } from './products.service';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private _httpClient: HttpClient) { }

  static BASE_URL = ConstantService.API_GATEWAY_BASE_URL + 'orders';

  getAll(): Observable<Order[]> {
    return this._httpClient.get<Order[]>(OrderService.BASE_URL);
  }

  getAllByUserId(userId: number): Observable<Order[]> {
    return this._httpClient.get<Order[]>(OrderService.BASE_URL + '/user/' + userId);
  }

  getById(id: number): Observable<Order> {
    return this._httpClient.get<Order>(OrderService.BASE_URL + '/' + id);
  }

  insertOrder(order: Order): Observable<Order> {
    return this._httpClient.post<Order>(OrderService.BASE_URL, order);
  }

  updateQuantityDueToOrder(product: Product) {
    this._httpClient.put(ProductsService.BASE_URL, product).subscribe();
  }
}
