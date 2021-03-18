import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';
import { ConstantService } from './constantService';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  static BASE_URL = ConstantService.API_GATEWAY_BASE_URL + 'users';

  constructor(private _httpClient: HttpClient) { }

  getAll(): Observable<User[]> {
    return this._httpClient.get<User[]>(UserService.BASE_URL);
  }

  getById(id: number): Observable<User> {
    return this._httpClient.get<User>(UserService.BASE_URL + '/' + id);
  }

  insertNewUser(userToInsert: User): Observable<any> {
    return this._httpClient.post<any>(UserService.BASE_URL, userToInsert);
  }
}
