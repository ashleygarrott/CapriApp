package com.capricove.capricove.backend.services;

//handles incoming orders

import com.capricove.capricove.backend.data.Order;
import com.capricove.capricove.backend.data.OrderDTO;
import com.capricove.capricove.backend.data.OrderDTOFactory;
import com.capricove.capricove.backend.data.TokenGenerator;
import com.capricove.capricove.backend.entities.OpenOrderDAO;
import com.capricove.capricove.backend.entities.OrderDAO;
import com.capricove.capricove.backend.entities.OrderDetailsDAO;
import com.capricove.capricove.backend.repositories.OpenOrderRepository;
import com.capricove.capricove.backend.repositories.OrderDetailRepository;
import com.capricove.capricove.backend.repositories.OrderRepository;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    OpenOrderRepository openOrderRepository;

    @Autowired
    TokenGenerator tokenGenerator;

    @Autowired
    OrderDTOFactory orderDTOFactory;


    public void createOrder(OrderDTO orderDTO){
        String orderId = tokenGenerator.generateToken();

        DateTime dt = new DateTime();
        DateTime dtBkk = dt.withZone(DateTimeZone.forID("Asia/Bangkok"));
        DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
        String dateTimeString = fmt.print(dtBkk);
        orderRepository.save(new OrderDAO(orderId, orderDTO.getUserId(), orderDTO.getOrderType(), orderDTO.getOrderPrice(), dateTimeString, orderDTO.getAddress(), orderDTO.getLatitude(), orderDTO.getLongitude(),orderDTO.getLocationNotes(), "unconfirmed"));

        for (Order order: orderDTO.getOrders()){
            orderDetailRepository.save(new OrderDetailsDAO(orderId, order.getMenuId(), order.getQuantity(), order.getMenuName(), getOptionString(order.getOptions()), order.getMenuPrice()));
        }

        openOrderRepository.save(new OpenOrderDAO(orderId));
    }

    @Transactional
    public void confirmOrder(String orderId){
        OrderDAO orderDAO = orderRepository.findByOrderId(orderId);
        orderDAO.setStatus("confirmed");
        orderRepository.save(orderDAO);

        openOrderRepository.deleteByOrderId(orderId);
    }

    @Transactional
    public void declineOrder(String orderId){
        OrderDAO orderDAO = orderRepository.findByOrderId(orderId);
        orderDAO.setStatus("canceled");
        orderRepository.save(orderDAO);
        orderRepository.save(orderDAO);

        openOrderRepository.deleteByOrderId(orderId);
    }

    public List<OrderDTO> getAllOpenOrders(){
        List<OpenOrderDAO> openOrders = openOrderRepository.findAll();
        List<OrderDTO> orderDTOS = new ArrayList<>();

        for (OpenOrderDAO openOrder: openOrders){
            OrderDTO orderDTO = orderDTOFactory.createOrderDTO(openOrder.getOrderId());
            orderDTOS.add(orderDTO);
        }

        return orderDTOS;


    }

    private String getOptionString(List<String> options){
        String ret = "";

        for(int i=0;i<options.size()-1;i++){
            ret += options.get(i) + ", ";
        }

        ret += options.get(options.size()-1);

        return ret;
    }





}
