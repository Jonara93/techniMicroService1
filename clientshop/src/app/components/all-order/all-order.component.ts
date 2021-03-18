import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from 'src/app/models/order.model';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-all-order',
  templateUrl: './all-order.component.html',
  styleUrls: ['./all-order.component.scss']
})
export class AllOrderComponent implements OnInit {

  orders: Order[] = []

  constructor(private _orderSerivce: OrderService,
    private _router: Router) { }

  ngOnInit(): void {
    this.initOrder();
  }
  initOrder() {
    this._orderSerivce.getAll().subscribe(
      data => this.orders = data
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
