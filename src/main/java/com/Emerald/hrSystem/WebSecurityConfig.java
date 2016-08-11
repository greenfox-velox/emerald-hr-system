package com.Emerald.hrSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
              .authorizeRequests()
              .antMatchers("/","/login","/register").permitAll()
              .anyRequest().authenticated()
              .and()
            .formLogin()
              .loginPage("/login")
              .permitAll()
              .usernameParameter("username")
              .passwordParameter("password")
              .defaultSuccessUrl("/welcome")
              .failureUrl("/login?error")
              .and()
            .logout()
              .logoutUrl("/logout")
              .logoutSuccessUrl("/")
              .permitAll();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth
            .inMemoryAuthentication()
            .withUser("user").password("password");
  }
}