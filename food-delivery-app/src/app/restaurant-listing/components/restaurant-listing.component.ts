import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Restaurant } from 'src/app/Shared/models/Restaurant';
import { RestaurantService } from './../service/restaurant.service';

@Component({
  selector: 'app-restaurant-listing',
  templateUrl: './restaurant-listing.component.html',
  styleUrls: ['./restaurant-listing.component.css'],
})
export class RestaurantListingComponent {
  public restaurantList: Restaurant[];

  ngOnInit() {
    this.getAllRestaurants();
    this.getRandomImage();
  }

  constructor(
    private router: Router,
    private restaurantService: RestaurantService
  ) {}

  getAllRestaurants() {
    this.restaurantService.getAllRestaurants().subscribe((data) => {
      this.restaurantList = data;
    });
  }

  getRandomNumber(min: number, max: number): number {
    return Math.floor(Math.random() * (max - min + 1) + min);
  }

  getRandomImage(): string {
    const imageCount = 8;
    const randomImage = this.getRandomNumber(1, imageCount);
    return `${randomImage}.jpg`;
  }

  onButtonClick(id: number) {
    this.router.navigate(['/food-catalogue', id]);
  }
}
