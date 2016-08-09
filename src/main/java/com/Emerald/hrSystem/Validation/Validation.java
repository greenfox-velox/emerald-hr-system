package com.Emerald.hrSystem.Validation;
import com.Emerald.hrSystem.Database;
import com.Emerald.hrSystem.Model.User;

public class Validation {

  public String loginValidation(User loginUser, Database userDb) {
    for (User listUser : userDb.users) {
      if (userDb.userNameCheck(listUser, loginUser) && userDb.passwordCheck(listUser, loginUser)) {
        return "accept";
      } else if (userDb.userNameCheck(listUser, loginUser) && !(userDb.passwordCheck(listUser, loginUser))) {
        return "rejectpassword";
      }
    }
    return "rejectusername";
  }
}

