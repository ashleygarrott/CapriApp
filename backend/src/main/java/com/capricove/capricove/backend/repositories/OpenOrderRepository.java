package com.capricove.capricove.backend.repositories;

import com.capricove.capricove.backend.entities.OpenOrderDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpenOrderRepository extends JpaRepository<OpenOrderDAO, String> {


    List<OpenOrderDAO> findAll();

    long deleteByOrderId(String orderId);



}