package com.capricove.capricove.backend.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


//handles creating a Connection object

@Service
public class ConnectionCreator {

    public Connection getConnection() throws URISyntaxException, SQLException, ClassNotFoundException {

//        URI dbUri = new URI(System.getenv("DATABASE_URL"));
//        String username = dbUri.getUserInfo().split(":")[0];
//        String password = dbUri.getUserInfo().split(":")[1];
//        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();

//        String username = "root";
//        String password = "howareyou1";
//        String dbUrl = "jdbc:mysql://localhost/capriapp";

        return DriverManager.getConnection("jdbc:mysql://localhost/capriapp", "root", "howareyou1");

    }




}
