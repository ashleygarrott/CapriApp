package com.capricove.capricove.backend.data;

//handles updating order history database

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//handles updating order history database

@Service
public class OrderDatabaseService {

    @Autowired
    ConnectionCreator connectionCreator;

    Statement statement;
    Connection connection;
    public OrderDatabaseService() throws URISyntaxException, SQLException, ClassNotFoundException {
        Connection connection = connectionCreator.getConnection();
        statement = connection.createStatement();
    }

    public void addOrder(){

    }

    public void updateOrder(){

    }
}
