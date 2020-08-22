package com.capricove.capricove.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("com.capricove.capricove.backend.repositories")
@EnableTransactionManagement
public class DataSourceConfig {

//    @Value("${dbuser}")
//    private String dbUser;
//
//    @Value("${dbpassword")
//    private String dbPassword;
//
//    @Value("${dbUrl}")
//    private String dbUrl;
//
//    public DataSourceConfig() throws URISyntaxException {
//        URI dbUri = new URI(System.getenv("DATABASE_URL"));
//        dbUser = dbUri.getUserInfo().split(":")[0];
//        dbPassword = dbUri.getUserInfo().split(":")[1];
//        dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
//    }

    @Bean
    public DataSource dataSource() throws URISyntaxException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        URI dbUri = new URI(System.getenv("DATABASE_URL"));
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername(dbUri.getUserInfo().split(":")[0]);
        dataSource.setPassword(dbUri.getUserInfo().split(":")[1]);
        dataSource.setUrl("jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath());

//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("howareyou1");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres?currentSchema=capriapp");
        return dataSource;
    }
}
