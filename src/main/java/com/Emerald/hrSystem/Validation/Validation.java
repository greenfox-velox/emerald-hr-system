package com.Emerald.hrSystem.Validation;
import com.Emerald.hrSystem.Model.User;

public class Validation {
  Database userDb = new Database();

  public String loginValidation(User loginUser) {
    return userDb.loginUser(loginUser);
  }
}
