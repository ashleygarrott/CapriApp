package com.capricove.capricove.backend.controllers;

import com.capricove.capricove.backend.data.OrderDTO;
import com.capricove.capricove.backend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/make_order")
    public void makeOrder(@RequestBody OrderDTO orderDTO){
        orderService.createOrder(orderDTO);
    }



}
