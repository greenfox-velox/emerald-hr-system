package com.Emerald.hrSystem.Validation;

import com.Emerald.hrSystem.Database;
import com.Emerald.hrSystem.Model.User;
import com.Emerald.hrSystem.Model.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class Validation {

  @Autowired
  private UserDAO userDAO;

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

  public String registrationValidation (User listUser) {
    userDAO.saveOrUpdate(listUser);
    return "welcome";
  }
}

