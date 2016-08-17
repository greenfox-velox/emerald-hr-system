package com.Emerald.hrSystem.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

  @Autowired
  DataSource dataSource;

  @Autowired
  public void configAuth(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().dataSource((dataSource))
            .usersByUsernameQuery("SELECT username, password, 1 from users where username=?")
            .authoritiesByUsernameQuery("SELECT username, role from users where username=?");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.formLogin()
            .loginPage("/login")
            .failureUrl("/login?error")
            .usernameParameter("username")
            .passwordParameter("password")
            .and().logout()
            .logoutSuccessUrl("/login?logout")
            .and().csrf();
  }
}