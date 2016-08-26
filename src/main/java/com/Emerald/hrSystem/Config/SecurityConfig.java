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
      .usersByUsernameQuery("SELECT username, password, 1 from User where username=?")
      .authoritiesByUsernameQuery("SELECT username, role from User where username=?");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
        .antMatchers("/login","/registration","/css/**", "/js/**", "/img/**").permitAll()
        .anyRequest().authenticated()
      .and()
      .formLogin()
        .loginPage("/login")
        .failureUrl("/login?error")
        .usernameParameter("username")
        .passwordParameter("password")
        .defaultSuccessUrl("/login/default",true).permitAll()
      .and()
        .logout()
        .logoutSuccessUrl("/login?logout")
        .and().csrf();
  }
}