package com.fooddelivery.foodcatalogue.controller;

import com.fooddelivery.foodcatalogue.dto.FoodCataloguePage;
import com.fooddelivery.foodcatalogue.dto.FoodItemDTO;
import com.fooddelivery.foodcatalogue.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fooditem")
@CrossOrigin
public class FoodItemController {
    @Autowired
    FoodItemService foodItemService;

    @PostMapping()
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO) {
        FoodItemDTO savedItem = foodItemService.addFoodItem(foodItemDTO);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<FoodCataloguePage> fetchRestaurantDetailsWithFoodMenu(@PathVariable Integer restaurantId) {
        FoodCataloguePage foodCataloguePage = foodItemService.fetchRestaurantDetailsWithFoodMenu(restaurantId);
        return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);
    }
}
