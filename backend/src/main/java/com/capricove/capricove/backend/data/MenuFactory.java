package com.capricove.capricove.backend.data;

//creates menu objects using id from database

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuFactory {

    @Autowired
    private ConnectionCreator connectionCreator;

    private Statement statement;
    private Connection connection;

    public MenuFactory() throws URISyntaxException, SQLException, ClassNotFoundException {
        Connection connection = connectionCreator.getConnection();
        statement = connection.createStatement();
    }

    public Menu createMenu(int id) throws SQLException {

        //fetching from menus table
        String sql = String.format("SELECT * FROM menus WHERE id = '%s'", id);
        ResultSet result = statement.executeQuery(sql);
        int ID = result.getInt("id");
        String name = result.getString("name");
        String section = result.getString("section");
        int price = result.getInt("price");
        String src = result.getString("src");
        String description = result.getString("description");
        result.close();

        //create Menu object
        Menu menu = new Menu(ID, name, section, price, src, description);

        //fetching from tags table
        sql = String.format("SELECT tag FROM menus WHERE menu_id = '%s'", id);
        result = statement.executeQuery(sql);
        while(result.next()){
            String tag = result.getString("tag");
            menu.addTag(tag);
        }
        result.close();

        //fetching from categories table
        sql = String.format("SELECT category FROM categories WHERE menu_id = '%s'", id);
        result = statement.executeQuery(sql);
        while(result.next()){
            String category = result.getString("category");
            menu.addCategory(category);
        }
        result.close();

        //fetching from options table
        sql = String.format("SELECT option_category,option_name,option_price FROM menus WHERE menu_id = '%s'", id);
        result = statement.executeQuery(sql);
        while(result.next()){
            String option_category = result.getString("option_category");
            String option_name = result.getString("option_name");
            int option_price = result.getInt("option_price");
            menu.addOption(option_category, option_name, option_price);
        }

        return menu;
    }
}

