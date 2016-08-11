package com.Emerald.hrSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
      "classpath:/static/" };

    public static void main(String[] args) throws Throwable {
      SpringApplication.run(Application.class, args);
    }
}