package com.capricove.capricove.backend.data;

//returns appropriate menu objects and lists

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.rsocket.context.LocalRSocketServerPort;
import org.springframework.stereotype.Service;


import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuFactory menuFactory;

    @Autowired
    private ConnectionCreator connectionCreator;

    private Statement statement;
    private Connection connection;

    public MenuService() throws URISyntaxException, SQLException, ClassNotFoundException {
        Connection connection = connectionCreator.getConnection();
        statement = connection.createStatement();
    }

    public List<Menu> getMenusByCategory(String category) throws SQLException {
        List<Menu> menus = new ArrayList<>();
        String sql = String.format("SELECT id FROM categories WHERE category = '%s'", category);
        ResultSet result = statement.executeQuery(sql);
        while(result.next()){
            int id = result.getInt("id");
            Menu menu = menuFactory.createMenu(id);
            menus.add(menu);
        }

        return menus;
    }

    public List<Menu> getAllMenus() throws SQLException {
        List<Menu> menus = new ArrayList<>();
        String sql = String.format("SELECT id FROM menus");
        ResultSet result = statement.executeQuery(sql);
        while(result.next()){
            int id = result.getInt("id");
            Menu menu = menuFactory.createMenu(id);
            menus.add(menu);
        }

        return menus;
    }

    public List<String> getCategories() throws SQLException {
        List<String> categories = new ArrayList<>();
        String sql = String.format("SELECT DISTINCT category FROM categories");
        ResultSet result = statement.executeQuery(sql);
        while(result.next()){
            String category = result.getString("category");
            categories.add(category);
        }
        return categories;
    }
}
