package com.capricove.capricove.backend.services;

//returns appropriate menu objects and lists

import com.capricove.capricove.backend.data.Menu;
import com.capricove.capricove.backend.data.MenuFactory;
import com.capricove.capricove.backend.data.ProductCardDTO;
import com.capricove.capricove.backend.entities.CategoryDAO;
import com.capricove.capricove.backend.entities.MenuDAO;
import com.capricove.capricove.backend.repositories.CategoryRepository;
import com.capricove.capricove.backend.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        List<CategoryDAO> rows = categoryRepository.findByCategory(category);

        for (CategoryDAO row: rows){
            Menu menu = menuFactory.createMenu(row.getMenuId());
            menus.add(menu);
        }

        return menus;





    }

    public List<Menu> getAllMenus() throws SQLException {
        List<Menu> menus = new ArrayList<>();
        List<MenuDAO> rows = menuRepository.findAll();

        for (MenuDAO row: rows){
            Menu menu = menuFactory.createMenu(row.getId());
            menus.add(menu);
        }
        return menus;
    }

    public List<String> getCategories() throws SQLException {
        Set<String> categories = new HashSet<>();
        List<String> ret = new ArrayList<>();
        List<CategoryDAO> rows = categoryRepository.findAll();

        for (CategoryDAO row: rows){
            String category = row.getCategory();
            categories.add(category);
        }

        ret.addAll(categories);
        return ret;
    }

    public List<ProductCardDTO> getAllMenuCards() {
        List<MenuDAO> rows = menuRepository.findAll();
        List<ProductCardDTO> productCards = new ArrayList<>();

        for (MenuDAO row: rows){
            productCards.add(new ProductCardDTO(row.getName(), row.getDescription(), row.getPrice(), row.getSrc()));
        }

        return productCards;

    }

    public Menu getMenuById(int id) throws SQLException {
        return menuFactory.createMenu(id);
    }
}
