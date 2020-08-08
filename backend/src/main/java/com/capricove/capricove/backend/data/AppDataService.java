package com.capricove.capricove.backend.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class AppDataService {

    @Autowired
    private ConnectionCreator connectionCreator;

    private Statement statement;
    private Connection connection;
    public AppDataService() throws URISyntaxException, SQLException, ClassNotFoundException {
        Connection connection = connectionCreator.getConnection();
        statement = connection.createStatement();
    }
    public void addMenu(Menu menu) throws SQLException {
        //insert single attributes linearly
        //insert into menu table
        String sql = String.format("INSERT INTO menus VALUES (\'%s\', \'%s\', \'%s\', \'%s\', \'%s\', \'%s\')", menu.getId(), menu.getName(), menu.getSection(), menu.getPrice(), menu.getSrc(), menu.getDescription());
        statement.executeUpdate(sql);

        //insert into tags table
        for (String tag: menu.getTags()){
            sql = String.format("INSERT INTO tags VALUES (\'%s\', \'%s\')", menu.getId(), tag);
            statement.executeUpdate(sql);
        }

        //insert into categories table
        for (String category: menu.getCategories()){
            sql = String.format("INSERT INTO categories VALUES (\'%s\', \'%s\')", menu.getId(), category);
            statement.executeUpdate(sql);
        }

        //insert into options table
        for(String optionCategory: menu.getOptions().keySet()){
            for(String option: menu.getOptions().get(optionCategory).keySet()){
                int price = menu.getOptions().get(optionCategory).get(option);
                sql = String.format("INSERT INTO options VALUES (\'%s\', \'%s\',\'%s\', \'%s\')", menu.getId(), optionCategory, option, price);
                statement.executeUpdate(sql);
            }
        }
    }

    public void addMenuOption(){

    }
}


