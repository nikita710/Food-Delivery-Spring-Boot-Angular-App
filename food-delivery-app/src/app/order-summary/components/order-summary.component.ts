import { Component } from '@angular/core';
import { OrderDTO } from '../models/OrderDTO';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderService } from './../service/order.service';

@Component({
  selector: 'app-order-summary',
  templateUrl: './order-summary.component.html',
  styleUrls: ['./order-summary.component.css'],
})
export class OrderSummaryComponent {
  orderSummary?: OrderDTO;
  obj?: any;
  total?: any;
  showDialog: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private orderService: OrderService,
    private router: Router
  ) {}

  ngOnInit() {
    const data = this.route.snapshot.queryParams['data'];

    this.obj = JSON.parse(data);
    console.log(this.obj);
    this.obj.userId = 2;
    this.orderSummary = this.obj;

    this.total = this.obj.foodItems.reduce(
      (
        accumulator: number,
        currentValue: { quantity: number; price: number }
      ) => {
        return accumulator + currentValue.quantity * currentValue.price;
      },
      0
    );
    console.log(this.total);
  }

  saveOrder() {
    this.orderService.saveOrder(this.orderSummary).subscribe(
      (response) => {
        this.showDialog = true;
      },
      (error) => {
        console.error('Failed to save data:', error);
      }
    );
  }

  closeDialog() {
    this.showDialog = false;
    this.router.navigate(['/']); // Replace '/home' with the actual route for your home page
  }
}
