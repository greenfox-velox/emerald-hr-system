package com.Emerald.hrSystem.Model;

import org.apache.tomcat.websocket.server.Constants;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class User {
  private int id;

  @NotNull
  @NotEmpty (message = "Please enter your username")
  private String userName;

  @Email(message="Please provide a valid email address!" )
  @Pattern(regexp="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message="Please provide a valid email address")
  @NotEmpty (message = "Please enter your email")
  private String email;

  @NotEmpty (message = "Please enter your username")
  @Size (min = 8, max = 15, message = "Your password must be between 6 and 15 characters")
  private String password;

  @NotEmpty (message = "Please enter your username")
  @Size (min = 8, max = 15, message = "Your password must be between 6 and 15 characters")
  private String passwordConfirm;

  public User() {}

  public User(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public User(int id, String userName, String email, String password) {
    this.id = id;
    this.userName = userName;
    this.email = email;
    this.password = password;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public String getPasswordConfirm() {
    return passwordConfirm;
  }

  public void setPasswordConfirm(String passwordConfirm) {
    this.passwordConfirm = passwordConfirm;
  }


  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isPasswordValid(User loginUser) {
    return this.password.equals(loginUser.getPassword());
  }
}