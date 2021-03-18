import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Order } from 'src/app/models/order.model';
import { User } from 'src/app/models/user.model';
import { AuthService } from 'src/app/services/auth.service';
import { OrderService } from 'src/app/services/order.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user-profil',
  templateUrl: './user-profil.component.html',
  styleUrls: ['./user-profil.component.scss']
})
export class UserProfilComponent implements OnInit {

  user: User;
  userStatus: Subscription;
  orders: Order[];


  constructor(private _userService: UserService,
    private _orderService: OrderService,
    private _router: Router,
    private _authService: AuthService) { }

  ngOnInit(): void {
    this.initUser();
  }

  initUser() {
    //TODO --> A changer plus tard
    this.userStatus = this._authService.userConnected.subscribe(
      next => {
        this.user = next;
        this.initOrder();
      }
    )
  }

  initOrder() {
    this._orderService.getAllByUserId(this.user.id).subscribe(
      next => {
        this.orders = next;
        console.table(this.orders);
      }
    )
  }

  orderDetail(order: Order) {
    this._router.navigate(['orders'], {
      queryParams: {
        idOrder: order.id
      }
    }).then()
  }

}
