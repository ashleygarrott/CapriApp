package com.capricove.capricove.backend.controllers;

import com.capricove.capricove.backend.data.MenuService;
import com.capricove.capricove.backend.data.OrderService;
import com.capricove.capricove.backend.entities.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/make_order")
    public void makeOrder(OrderDAO orderDAO){
        orderService.createOrder(orderDAO);
    }



}
