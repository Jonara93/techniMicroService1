import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { User } from '../models/user.model';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  userConnected: BehaviorSubject<User> = new BehaviorSubject<User>(null);

  constructor(private _userService: UserService) {
    this._userService.getById(1).subscribe(
      next => {
        this.userConnected.next(next);
      }
    )
  }

  getCurrentUser(): User {
    return this.userConnected.value;
  }

}
