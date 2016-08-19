package com.Emerald.hrSystem.Validation;
import com.Emerald.hrSystem.Model.User;
import com.Emerald.hrSystem.DAOs.UserDAO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class Validation {

  public void validate (User newUser, BindingResult result, UserDAO userDAO ) {
    List<User> list = userDAO.list();
    if (!this.isUserNameFree(newUser,list)){
      FieldError error = new FieldError("user","username","This username is occupied!");
      result.addError(error);
    }
    if (!this.registrationPasswordCheck(newUser)){
      FieldError error = new FieldError("user", "password", "Password does not match the confirm password!");
      result.addError(error);
    }
    if (this.isUserNameFree(newUser,list) && this.registrationPasswordCheck(newUser)) {
      userDAO.saveOrUpdate(newUser);
    }
  }

  public boolean isUserNameFree(User user, List<User> list) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getUsername().equals(user.getUsername())){
        return false;
      }
    }
    return true;
  }

  public boolean registrationPasswordCheck(User newUser) {
    return newUser.isPasswordValid();
  }
}

