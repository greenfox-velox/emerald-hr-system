package com.Emerald.hrSystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
@Configuration
@ComponentScan("com.Emerald.hrSystem")
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter  {

  //start Thymeleaf specific configuration
  @Bean(name ="templateResolver")
  public ServletContextTemplateResolver getTemplateResolver() {
    ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
    templateResolver.setPrefix("/resources/templates/");
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode("XHTML");
    return templateResolver;
  }
  @Bean(name ="templateEngine")
  public SpringTemplateEngine getTemplateEngine() {
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.setTemplateResolver(getTemplateResolver());
    return templateEngine;
  }
  @Bean(name="viewResolver")
  public ThymeleafViewResolver getViewResolver(){
    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
    viewResolver.setTemplateEngine(getTemplateEngine());
    return viewResolver;
  }

}
