package com.fooddelivery.order.service;

import com.fooddelivery.order.dto.OrderDTO;
import com.fooddelivery.order.dto.OrderDTOFE;
import com.fooddelivery.order.dto.UserDTO;
import com.fooddelivery.order.entity.Order;
import com.fooddelivery.order.mapper.OrderMapper;
import com.fooddelivery.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    SequenceGenerator sequenceGenerator;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public OrderDTO saveOrderInDB(OrderDTOFE orderDetails) {
        Integer nextOrderId = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO = fetchUserDetails(orderDetails.getUserId());
        Order orderSaved = new Order(nextOrderId, orderDetails.getFoodItemList(), orderDetails.getRestaurant(), userDTO);
        orderRepository.save(orderSaved);
        return OrderMapper.INSTANCE.mapOrdeToOrderDTO(orderSaved);
    }

    private UserDTO fetchUserDetails(Integer userId) {
        return restTemplate.getForObject("http://USER-SERVICE/user/" + userId, UserDTO.class);
    }
}
