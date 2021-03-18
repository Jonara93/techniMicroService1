import { query } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Order } from 'src/app/models/order.model';
import { Product } from 'src/app/models/product.model';
import { User } from 'src/app/models/user.model';
import { OrderService } from 'src/app/services/order.service';
import { ProductsService } from 'src/app/services/products.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {

  order: Order;
  product: Product;
  user: User;

  constructor(private _orderService: OrderService,
    private _activatedRoute: ActivatedRoute,
    private _productService: ProductsService,
    private _router: Router,
    private _userService: UserService) { }

  ngOnInit(): void {
    this._activatedRoute.queryParams.subscribe(
      data => this._orderService.getById(data.idOrder).subscribe(
        data => {
          this.order = data
          this._userService.getById(this.order.userId).subscribe(
            next => this.user = next
          )
          this._productService.getById(this.order.productId).subscribe(
            data => this.product = data
          )
        }
      )
    )
  }

  payOrder() {
    this._router.navigate(['payments'], {
      queryParams: {
        orderId: this.order.id,
        totalPrice: this.product.price * this.order.productQuantity
      }
    }).then();
  }
  
}
