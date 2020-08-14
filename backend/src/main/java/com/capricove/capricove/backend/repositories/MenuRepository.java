package com.capricove.capricove.backend.repositories;

import com.capricove.capricove.backend.entities.MenuRow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuRow, Integer> {

    List<MenuRow> findByCategory(String category);

    MenuRow findById(int id);

    List<MenuRow> findAll();



}
