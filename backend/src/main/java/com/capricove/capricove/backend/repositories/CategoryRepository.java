package com.capricove.capricove.backend.repositories;

import com.capricove.capricove.backend.entities.CategoryRow;
import com.capricove.capricove.backend.entities.MenuRow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryRow, String> {

    List<CategoryRow> findByCategory(String category);

    List<CategoryRow> findDistinctCategory();

    List<CategoryRow> findById(int id);



}
