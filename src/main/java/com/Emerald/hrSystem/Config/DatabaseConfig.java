package com.Emerald.hrSystem.Config;

import com.Emerald.hrSystem.Model.UserDAO;
import com.Emerald.hrSystem.Model.UserDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig{

  @Bean
  public DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/HRSYSTEM");
    dataSource.setUsername("root");
    dataSource.setPassword("sql");
    return dataSource;
  }
  @Bean
  public UserDAO getUserDAO() {
    return new UserDAOImpl(getDataSource());
  }
}