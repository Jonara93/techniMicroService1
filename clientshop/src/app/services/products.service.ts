import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product.model';
import { ConstantService } from './constantService';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private _httpClient: HttpClient) { }

  static BASE_URL = ConstantService.API_GATEWAY_BASE_URL + 'products'

  getAll(): Observable<Product[]> {
    return this._httpClient.get<Product[]>(ProductsService.BASE_URL);
  }

  getById(id: number): Observable<Product> {
    return this._httpClient.get<Product>(ProductsService.BASE_URL + '/' + id);
  }

  updateProduct(productModified: Product) {
    this._httpClient.put(ProductsService.BASE_URL, productModified).subscribe();
  }
}
