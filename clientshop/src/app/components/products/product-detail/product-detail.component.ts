import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from 'src/app/models/order.model';
import { Product } from 'src/app/models/product.model';
import { AuthService } from 'src/app/services/auth.service';
import { OrderService } from 'src/app/services/order.service';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {

  product: Product;
  form: FormGroup;

  constructor(private _activatedRoute: ActivatedRoute,
    private _productsService: ProductsService,
    private _orderService: OrderService,
    private _formBuilder: FormBuilder,
    private _router: Router,
    private _authService: AuthService) { }

  ngOnInit(): void {
    this.initProduct();
    this.form = this._formBuilder.group({
      quantity: [1]
    })

  }

  initProduct() {
    //permet de rechanger a chaque fois le componant
    this._activatedRoute.params.subscribe(
      data => this._productsService.getById(data.id).subscribe(
        data => {
          this.product = data;
          this.form.get('quantity').setValidators(
            [Validators.required, Validators.min(1), Validators.max(data?.stockQuantity)]
          );
        }
      )
    );
  }

  createOrder() {
    this._orderService.insertOrder(
      {
        isPaid: false,
        productId: this.product.id,
        productQuantity: this.form.get('quantity').value,
        userId: this._authService.userConnected.value.id
      } as Order
    ).subscribe(
      order => {
        let productModified = this.product;
        productModified.stockQuantity -= this.form.get('quantity').value;
        this._productsService.updateProduct(productModified);
        this._router.navigate(['orders'], {
          queryParams: {
            idOrder: order.id
          }
        }).then()
      }
    )
  }

}
