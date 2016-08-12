package com.Emerald.hrSystem.Model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;


public class User {
  private int id;

  @NotNull
  @NotEmpty (message = "Please enter your username")
  private String userName;

  @Email(regexp="\\w+@\\w+\\.{1}\\w+", message="Please provide a valid email address!" )
  @NotEmpty (message = "Please enter your email")
  private String email;

  @NotEmpty (message = "Please enter your username")
  @Size (min = 8, max = 15, message = "Your password must be between 6 and 15 characters")
  private String password;

  public String getPasswordConfirm() {
    return passwordConfirm;
  }

  public void setPasswordConfirm(String passwordConfirm) {
    this.passwordConfirm = passwordConfirm;
  }

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
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isPasswordValid(User loginUser) {
    return this.password.equals(loginUser.getPassword());
  }
}