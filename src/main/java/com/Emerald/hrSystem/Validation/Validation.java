package com.Emerald.hrSystem.Validation;

import com.Emerald.hrSystem.Model.User;
import com.Emerald.hrSystem.Model.UserDAO;

public class Validation {

  public String loginValidation(User loginUser,UserDAO userDAO) {
    for (int i = 0; i < userDAO.list().size(); i++) {
      if (this.userNameCheck(userDAO.list().get(i), loginUser) && this.passwordCheck(userDAO.list().get(i), loginUser)) {
        return "welcome";
      } else if (this.userNameCheck(userDAO.list().get(i), loginUser) && !(this.passwordCheck(userDAO.list().get(i), loginUser))) {
        return "login";
      }
    }
    return "login";
  }

  public String registrationValidation (User newUser, UserDAO userDAO) {
    if (this.isUserNameFree(newUser,userDAO) && this.registrationPasswordCheck(newUser)){
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

  public boolean isUserNameFree(User userName,UserDAO userDAO ) {
    for (int i = 0; i < userDAO.list().size(); i++) {
      System.out.println(userDAO.list().get(i));
      if (userDAO.list().get(i).getUserName().equals(userName.getUserName())) {
        return false;
      }
    }
    return true;
  }

  public boolean registrationPasswordCheck(User newUser) {
    return newUser.isPasswordValid(newUser);
  }

}

