package com.Emerald.hrSystem.Validation;
import com.Emerald.hrSystem.Model.User;
import com.Emerald.hrSystem.Model.UserDAO;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.List;

public class Validation {

  public Boolean newUserIsValid (User newUser,UserDAO userDAO ) {
    List<User> list =userDAO.list();
    if (this.isUserNameFree(newUser,list) && this.registrationPasswordCheck(newUser)){
      userDAO.saveOrUpdate(newUser);
      return true;
    } else {
      return false;
    }
  }

  public boolean isUserNameFree(User user, List<User> list) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getUserName().equals(user.getUserName())){
        return false;
      }
    }
    return true;
  }

  public boolean registrationPasswordCheck(User newUser) {
    return newUser.isPasswordValid();
  }
}

