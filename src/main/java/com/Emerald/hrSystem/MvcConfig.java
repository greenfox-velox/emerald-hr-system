package com.Emerald.hrSystem;


import com.Emerald.hrSystem.Model.UserDAO;
import com.Emerald.hrSystem.Model.UserDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Configuration
@ComponentScan(basePackages="com.Emerald.hrSystem")
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("login");
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/register").setViewName("registration");
    registry.addViewController("/welcome").setViewName("welcome");
    registry.addViewController("/test").setViewName("test");
  }

  @Bean
  public DataSource getDataSource() {
    String url = "jdbc:mysql://localhost";
    String username = "root";
    String password = "Pocok07";
    String database = "HRSYSTEM";

    String sql = "CREATE DATABASE IF NOT EXISTS " + database;

    try (Connection conn = DriverManager.getConnection(url, username, password);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.execute();
    } catch (Exception e) {
      e.printStackTrace();
    }
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl(url + database);
    dataSource.setUsername(username);
    dataSource.setPassword(password);

    return dataSource;
  }

  @Bean
  public UserDAO getUserDAO() {
    return new UserDAOImpl(getDataSource());
  }

}
