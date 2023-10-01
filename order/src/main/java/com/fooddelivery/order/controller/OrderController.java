package com.fooddelivery.order.controller;

import com.fooddelivery.order.dto.OrderDTO;
import com.fooddelivery.order.dto.OrderDTOFE;
import com.fooddelivery.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping()
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFE orderDetails) {
        OrderDTO orderSaved = orderService.saveOrderInDB(orderDetails);
        return new ResponseEntity<>(orderSaved, HttpStatus.CREATED);
    }
}
