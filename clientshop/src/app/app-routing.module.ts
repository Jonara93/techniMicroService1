import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AllOrderComponent } from './components/all-order/all-order.component';
import { DeliveriesComponent } from './components/deliveries/deliveries.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { OrderComponent } from './components/order/order.component';
import { PaymentComponent } from './components/payment/payment.component';
import { ProductDetailComponent } from './components/products/product-detail/product-detail.component';
import { ProductsComponent } from './components/products/products.component';
import { UserProfilComponent } from './components/user-profil/user-profil.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  {
    path: 'products', component: ProductsComponent, children: [
      { path: ':id', component: ProductDetailComponent }
    ]
  },
  { path: 'orders', component: OrderComponent },
  { path: 'allorders', component: AllOrderComponent },
  { path: 'deliveries', component: DeliveriesComponent },
  { path: 'payments', component: PaymentComponent },
  { path: 'profil-user', component: UserProfilComponent },
  { path: '**', redirectTo: 'home' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
