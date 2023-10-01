package com.fooddelivery.foodcatalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDTO {
    private int id;
    private String name;
    private String foodDescription;
    private boolean isVeg;
    private Integer price;
    private int restaurantId;
    private int quantity;
}
