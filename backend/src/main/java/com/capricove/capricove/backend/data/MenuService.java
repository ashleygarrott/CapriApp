package com.capricove.capricove.backend.data;

//returns appropriate menu objects and lists

import com.capricove.capricove.backend.entities.CategoryRow;
import com.capricove.capricove.backend.entities.MenuRow;
import com.capricove.capricove.backend.repositories.CategoryRepository;
import com.capricove.capricove.backend.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuFactory menuFactory;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    public List<Menu> getMenusByCategory(String category) throws SQLException {
        List<Menu> menus = new ArrayList<>();
        List<MenuRow> rows = menuRepository.findByCategory(category);

        for (MenuRow row: rows){
            Menu menu = menuFactory.createMenu(row.getId());
            menus.add(menu);
        }

        return menus;





    }

    public List<Menu> getAllMenus() throws SQLException {
        List<Menu> menus = new ArrayList<>();
        List<MenuRow> rows = menuRepository.findAll();

        for (MenuRow row: rows){
            Menu menu = menuFactory.createMenu(row.getId());
            menus.add(menu);
        }
        return menus;
    }

    public List<String> getCategories() throws SQLException {
        List<String> categories = new ArrayList<>();
        List<CategoryRow> rows = categoryRepository.findDistinctCategory();

        for (CategoryRow row: rows){
            String category = row.getCategory();
            categories.add(category);
        }
        return categories;
    }
}
