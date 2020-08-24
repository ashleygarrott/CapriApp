package com.capricove.capricove.backend.controllers;

import com.capricove.capricove.backend.data.OrderDTO;
import com.capricove.capricove.backend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/make_order")
    public void makeOrder(@RequestBody OrderDTO orderDTO){
        orderService.createOrder(orderDTO);
    }

    @PostMapping("/confirm_order")
    public String confirmOrder(@RequestBody OrderDTO orderDTO){
        try {
            orderService.confirmOrder(orderDTO.getOrderId());
            return "success";
        }
        catch (Exception e){
            return "fail";
        }
    }

    @PostMapping("/decline_order")
    public String cancelOrder(@RequestBody OrderDTO orderDTO){
        try {
            orderService.declineOrder(orderDTO.getOrderId());
            return "success";
        }
        catch (Exception e){
            return "fail";
        }
    }

    @GetMapping("/view_open_orders")
    public List<OrderDTO> getAllOpenOrders(){
        return orderService.getAllOpenOrders();
    }



}
