import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { Product } from 'src/app/models/product.model';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {

  products: Product[] = [];

  constructor(private _productsService: ProductsService,
    private _router: Router) { }

  ngOnInit(): void {
    this._productsService.getAll().subscribe(
      data => {
        this.products = data;
      }
    )
  }

  productDetail(id: number) {
    this._router.navigate(['products', id]).then()
  }

}
