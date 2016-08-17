package com.Emerald.hrSystem.Validation;

import com.Emerald.hrSystem.Model.User;
import com.Emerald.hrSystem.Model.UserDAO;

public class Validation {

  public Boolean newUserIsValid (User newUser, UserDAO userDAO) {
    if (this.isUserNameFree(newUser,userDAO) && this.registrationPasswordCheck(newUser)){
      return true;
    } else {
      return false;
    }
  }

  public boolean isUserNameFree(User username,UserDAO userDAO ) {
    for (int i = 0; i < userDAO.list().size(); i++) {
      if (userDAO.list().get(i).getUserName().equals(username.getUserName())) {
        return false;
      }
    }
    return true;
  }

  public boolean registrationPasswordCheck(User newUser) {
    return newUser.isPasswordValid();
  }
}

