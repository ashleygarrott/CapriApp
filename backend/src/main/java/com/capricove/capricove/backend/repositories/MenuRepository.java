package com.capricove.capricove.backend.repositories;

import com.capricove.capricove.backend.entities.MenuDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuDAO, Integer> {

    MenuDAO findById(int id);

    List<MenuDAO> findAll();



}
