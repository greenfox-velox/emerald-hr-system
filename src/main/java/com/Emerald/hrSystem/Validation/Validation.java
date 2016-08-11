package com.Emerald.hrSystem.Validation;

import com.Emerald.hrSystem.Model.User;
import com.Emerald.hrSystem.Model.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Validation {

  @Autowired
  private UserDAO userDAO;

  public String loginValidation(User loginUser) {
    for (User user : userDAO.list()) {
      if (userNameCheck(user, loginUser) && passwordCheck(user, loginUser)) {
        return "welcome";
      } else if (userNameCheck(user, loginUser) && !(passwordCheck(user, loginUser))) {
        return "login";
      }
    }
    return "login";
  }

  public String registrationValidation (User newUser) {
    if (isUserNameFree(newUser) && registrationPasswordCheck(newUser)){
      userDAO.saveOrUpdate(newUser);
      return "welcome";
    } else {
      return "registration";
    }
  }

  public Boolean userNameCheck( User listUser, User user) {
    return listUser.getUserName().equals(user.getUserName());
  }

  public Boolean passwordCheck( User listUser, User user) {
    return listUser.getPassword().equals(user.getPassword());
  }

  public boolean isUserNameFree(User userName) {
    for (User user : userDAO.list()) {
      if (user.getUserName().equals(userName.getUserName())) {
        return false;
      }
    }
    return true;
  }

  public String registerUser (User newUser) {
    if (isUserNameFree(newUser) && registrationPasswordCheck(newUser)){
      userDAO.saveOrUpdate(newUser);
      return "welcome";
    } else {
      return "registration";
    }
  }

  public boolean registrationPasswordCheck(User newUser) {
    return newUser.isPasswordValid(newUser);
  }

}

