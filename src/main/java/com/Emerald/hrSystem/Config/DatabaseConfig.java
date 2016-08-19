package com.Emerald.hrSystem.Config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
import com.Emerald.hrSystem.Model.UserDAO;
import com.Emerald.hrSystem.Model.UserDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig{

  @Bean
  public DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/HRSYSTEM");
    dataSource.setUsername("root");
    dataSource.setPassword("Pocok07");
    return dataSource;
  }
  @Bean
  public UserDAO getUserDAO() {
    return new UserDAOImpl(getDataSource());
  }
}
