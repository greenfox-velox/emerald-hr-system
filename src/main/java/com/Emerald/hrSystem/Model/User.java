package com.Emerald.hrSystem.Model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class User {
  private int id;
  private String role;

  @NotNull
  @NotEmpty (message = "Please enter your username")
  private String username;

  @Email
  @Pattern(regexp="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message="Please provide a valid email address")
  @NotEmpty (message = "Please enter your email")
  private String email;

  @NotEmpty (message = "Please enter your username")
  @Size (min = 6, max = 15, message = "Your password must be between 6 and 15 characters")
  private String password;

  @NotEmpty (message = "Please enter your username")
  @Size (min = 6, max = 15, message = "Your password must be between 6 and 15 characters")
  private String passwordConfirm;

  public User() {}

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public User(int id, String username, String email, String password,String role) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.role = role;

  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
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

  public boolean isPasswordValid() {
    return this.getPassword().equals(this.getPasswordConfirm());
  }

  public String getRole() {
    return this.role;
  }

  public void setRole(String role) {
    this.role= role;
  }

}