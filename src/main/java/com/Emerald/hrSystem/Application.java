package com.Emerald.hrSystem;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class Application {
  public static void main(String[] args) throws Throwable {
    Flyway flyway = new Flyway();
    flyway.setDataSource("jdbc:mysql://localhost:3306/HRSYSTEM","root","Pocok07");
    flyway.migrate();
    SpringApplication.run(Application.class, args);
  }
}