import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { User } from './models/user.model';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, OnDestroy {
  title = 'clientshop';
  user: User;
  userSubscription: Subscription;

  constructor(private _authService: AuthService,
    private _router: Router) {
  }

  ngOnInit(): void {
    this.userSubscription = this._authService.userConnected.subscribe(
      next => {
        this.user = next;
      }
    )
  }

  ngOnDestroy(): void {
    if (this.userSubscription != null) {
      this.userSubscription.unsubscribe();
    }
  }

  login(){
    this._router.navigate(['login']);
  }

  logout(){
    
  }
}
