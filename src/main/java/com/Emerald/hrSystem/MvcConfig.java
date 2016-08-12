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

@Configuration
@ComponentScan(basePackages="com.Emerald.hrSystem")
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("login");
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/registration").setViewName("registration");
    registry.addViewController("/welcome").setViewName("welcome");
  }

  @Bean
  public DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/firstdb");
    dataSource.setUsername("root");
    dataSource.setPassword("Pocok07");

    return dataSource;
  }

  @Bean
  public UserDAO getUserDAO() {
    return new UserDAOImpl(getDataSource());
  }

}
