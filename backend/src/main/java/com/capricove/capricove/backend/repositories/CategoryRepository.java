package com.capricove.capricove.backend.repositories;

import com.capricove.capricove.backend.entities.CategoryDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryDAO, String> {

    List<CategoryDAO> findByCategory(String category);

    List<CategoryDAO> findAll();

    List<CategoryDAO> findByMenuId(int menuId);


}
