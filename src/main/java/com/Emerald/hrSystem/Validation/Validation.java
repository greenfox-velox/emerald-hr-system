package com.Emerald.hrSystem.Validation;

import com.Emerald.hrSystem.Database;
import com.Emerald.hrSystem.Model.User;

public class Validation {

  public String loginValidation(User loginUser, Database userDb) {
    return userDb.loginUser(loginUser);
  }

  public String registrationValidation (User listUser, Database userDb) {
    return userDb.registerUser(listUser);
  }
}
