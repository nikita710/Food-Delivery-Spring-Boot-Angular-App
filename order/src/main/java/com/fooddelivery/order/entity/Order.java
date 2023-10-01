package com.fooddelivery.order.entity;

import com.fooddelivery.order.dto.FoodItemDTO;
import com.fooddelivery.order.dto.RestaurantDTO;
import com.fooddelivery.order.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
    private Integer orderId;
    private List<FoodItemDTO> foodItems;
    private RestaurantDTO restaurant;
    private UserDTO user;
}
