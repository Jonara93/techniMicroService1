import { BrowserModule } from '@angular/platform-browser';
import { LOCALE_ID, NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { ProductsComponent } from './components/products/products.component';
import { ProductDetailComponent } from './components/products/product-detail/product-detail.component';
import { HomeComponent } from './components/home/home.component';
import { OrderComponent } from './components/order/order.component';
import localeFr from '@angular/common/locales/fr';
import { registerLocaleData } from '@angular/common';
import { PaymentComponent } from './components/payment/payment.component';
import { AllOrderComponent } from './components/all-order/all-order.component';
import { DeliveriesComponent } from './components/deliveries/deliveries.component';
import { UserProfilComponent } from './components/user-profil/user-profil.component';
import { AddressPipe } from './utils/address.pipe';
import { LoginComponent } from './components/login/login.component';
registerLocaleData(localeFr, 'fr');

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    ProductDetailComponent,
    HomeComponent,
    OrderComponent,
    PaymentComponent,
    AllOrderComponent,
    DeliveriesComponent,
    UserProfilComponent,
    AddressPipe,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [{
    provide: LOCALE_ID,
    useValue: 'fr'
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
