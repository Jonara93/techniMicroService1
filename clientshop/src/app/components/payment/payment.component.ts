import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Delivery } from 'src/app/models/delivery.model';
import { Payment } from 'src/app/models/payment.model';
import { DeliveryService } from 'src/app/services/delivery.service';
import { PaymentService } from 'src/app/services/payment.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.scss']
})
export class PaymentComponent implements OnInit {

  data: {
    orderId: number,
    totalPrice: number
  }
  form: FormGroup;
  constructor(private _activatedRoute: ActivatedRoute,
    private _formBuilder: FormBuilder,
    private _paymentService: PaymentService,
    private _router: Router,
    private _deliveryService: DeliveryService) { }

  ngOnInit(): void {
    this._activatedRoute.queryParams.subscribe(
      d => {
        this.data = {
          orderId: d.orderId,
          totalPrice: d.totalPrice
        }
      }
    )
    this.form = this._formBuilder.group({
      cardNumber: ['', Validators.required],
      deliverySupplier: ['BPOST', Validators.required]
    })
  }

  validatePayment() {
    this._paymentService.insertPayment({
      orderId: Number(this.data.orderId),
      amount: Number(this.data.totalPrice),
      cardNumber: this.form.get('cardNumber').value
    } as Payment).subscribe(
      payment => {
        this._deliveryService.insertDelivery({
          orderId: this.data.orderId,
          deliverySupplier: this.form.get('deliverySupplier').value
        } as Delivery).subscribe(
          next => this._router.navigate(['products']).then(p => {
            alert("Payement effectué")
          })
        )
      }
    );
  }

}

