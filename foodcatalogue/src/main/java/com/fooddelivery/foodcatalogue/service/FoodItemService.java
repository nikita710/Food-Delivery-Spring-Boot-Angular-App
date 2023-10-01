package com.fooddelivery.foodcatalogue.service;

import com.fooddelivery.foodcatalogue.dto.FoodCataloguePage;
import com.fooddelivery.foodcatalogue.dto.FoodItemDTO;
import com.fooddelivery.foodcatalogue.dto.Restaurant;
import com.fooddelivery.foodcatalogue.entity.FoodItem;
import com.fooddelivery.foodcatalogue.mapper.FoodItemMapper;
import com.fooddelivery.foodcatalogue.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodItemService {
    @Autowired
    FoodRepository foodRepository;

    @Autowired
    RestTemplate restTemplate;

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItem = foodRepository.save(FoodItemMapper.INSTANCE.mapFoodItemDtoToFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(foodItem);
    }

    public FoodCataloguePage fetchRestaurantDetailsWithFoodMenu(Integer restaurantId) {
        List<FoodItem> foodItems = foodItemList(restaurantId);
        Restaurant restaurant = fetchRestaurantFromRestaurantMS(restaurantId);

        return createFoodCataloguePage(foodItems, restaurant);

    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItems, Restaurant restaurant) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItems(foodItems);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;
    }

    private Restaurant fetchRestaurantFromRestaurantMS(Integer restaurantId) {
        Restaurant restaurant = restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/" + restaurantId, Restaurant.class);
        return restaurant;
    }

    private List<FoodItem> foodItemList(Integer restaurantId) {
        return foodRepository.findByRestaurantId(restaurantId);
    }
}
