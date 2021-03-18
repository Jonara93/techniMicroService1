import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { User } from '../models/user.model';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private _userConnected: BehaviorSubject<User> = new BehaviorSubject<User>(null);

  constructor(private _userService: UserService,
    private _httpClient: HttpClient,
    private _router: Router) {
  }

  get userConnected(): BehaviorSubject<User> {
    return this._userConnected;
  }

  login(pseudo: string, password: string): void {
    this._httpClient.post<User>(UserService.BASE_URL + '/check', {
      pseudo: pseudo,
      password: password
    }).subscribe(
      next => {
        this._userConnected.next(next);
        this._router.navigate(['products']).then();
      },
      err=> {
        alert(err.error.error);
      }
    )
  }

  logout() {
    this._userConnected.next(null);
    this._router.navigate(['']).then();
  }

}
