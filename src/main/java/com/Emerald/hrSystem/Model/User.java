package com.Emerald.hrSystem.Model;

/**
 * Created by pocok on 8/4/16.
 */
public class User {
  private int id;
  private String userName;
  private String email;
  private String password;

  public User(int id, String userName, String email, String password) {
    this.id = id;
    this.userName = userName;
    this.email = email;
    this.password = password;
  }

  @Override
  public String toString() {
    return String.format(
        "User[id=%d, userName='%s', email='%s']",
        id, userName, email);
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
}