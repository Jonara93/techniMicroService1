import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { User } from '../models/user.model';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private _userConnected: BehaviorSubject<User> = new BehaviorSubject<User>(null);

  constructor(private _userService: UserService,
    private _httpClient: HttpClient) {
  }

  get userConnected(): BehaviorSubject<User> {
    return this._userConnected;
  }

  login(pseudo: string, password: string): void {

  }

}
