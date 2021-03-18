import { Component, OnInit } from '@angular/core';
import { Delivery } from 'src/app/models/delivery.model';
import { DeliveryService } from 'src/app/services/delivery.service';

@Component({
  selector: 'app-deliveries',
  templateUrl: './deliveries.component.html',
  styleUrls: ['./deliveries.component.scss']
})
export class DeliveriesComponent implements OnInit {

  deliveries: Delivery[] = [];

  constructor(private _deliveryService: DeliveryService) { }

  ngOnInit(): void {
    this.initDeliveries();
  }

  initDeliveries(){
    this._deliveryService.getAll().subscribe(
      next => this.deliveries = next
    )
  }

}
