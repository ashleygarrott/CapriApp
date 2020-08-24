package com.capricove.capricove.backend.repositories;

import com.capricove.capricove.backend.entities.OrderDAO;
import com.capricove.capricove.backend.entities.TagDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderDAO, Integer> {

    List<OrderDAO> findAll();

    OrderDAO findByOrderId(String id);


}
