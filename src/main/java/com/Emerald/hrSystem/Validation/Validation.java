package com.Emerald.hrSystem.Validation;

import com.Emerald.hrSystem.Model.User;;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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

  public boolean hasRole(String role) {
    SecurityContext context = SecurityContextHolder.getContext();
    if (context == null)
      return false;

    Authentication authentication = context.getAuthentication();
    if (authentication == null)
      return false;

    for (GrantedAuthority auth : authentication.getAuthorities()) {
      if (role.equals(auth.getAuthority()))
        return true;
    }
    return false;
  }

}

