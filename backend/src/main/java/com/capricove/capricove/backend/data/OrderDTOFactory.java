package com.capricove.capricove.backend.data;

import com.capricove.capricove.backend.entities.OrderDAO;
import com.capricove.capricove.backend.entities.OrderDetailsDAO;
import com.capricove.capricove.backend.repositories.OpenOrderRepository;
import com.capricove.capricove.backend.repositories.OrderDetailRepository;
import com.capricove.capricove.backend.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDTOFactory {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    OpenOrderRepository openOrderRepository;

    public OrderDTO createOrderDTO(String orderId){
        OrderDAO orderDAO = orderRepository.findByOrderId(orderId);
        List<OrderDetailsDAO> orderDetailsDAO = orderDetailRepository.findByOrderId(orderId);
        List<Order> orders = new ArrayList<>();

        for (OrderDetailsDAO orderDetailsRow: orderDetailsDAO){
            Order order = new Order(orderDetailsRow.getMenuId(), orderDetailsRow.getQuantity(), orderDetailsRow.getMenuName(), orderDetailsRow.getOptions(), orderDetailsRow.getMenuPrice());
            orders.add(order);
        }

        OrderDTO orderDTO = new OrderDTO(orderDAO.getOrderId(),orderDAO.getUsername(), orderDAO.getOrderPrice(), orderDAO.getOrderType(), orders, orderDAO.getOrderTime(), orderDAO.getAddress(), orderDAO.getLatitude(), orderDAO.getLongitude(), orderDAO.getLocationNotes());

        return orderDTO;

    }


}
