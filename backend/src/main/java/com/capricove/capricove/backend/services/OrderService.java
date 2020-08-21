package com.capricove.capricove.backend.services;

//handles incoming orders

import com.capricove.capricove.backend.data.Order;
import com.capricove.capricove.backend.data.OrderDTO;
import com.capricove.capricove.backend.data.TokenGenerator;
import com.capricove.capricove.backend.entities.OrderDAO;
import com.capricove.capricove.backend.entities.OrderDetailsDAO;
import com.capricove.capricove.backend.repositories.OrderDetailRepository;
import com.capricove.capricove.backend.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    TokenGenerator tokenGenerator;

    public void createOrder(OrderDTO orderDTO){
        String orderId = tokenGenerator.generateToken();
        orderRepository.save(new OrderDAO(orderId, orderDTO.getUserId(), orderDTO.getOrderType(), orderDTO.getOrderPrice()));

        for (Order order: orderDTO.getOrders()){
            orderDetailRepository.save(new OrderDetailsDAO(orderId, order.getMenuId(), order.getQuantity()));
        }
    }





}
