package com.Emerald.hrSystem.Login;

import com.Emerald.hrSystem.Model.User;
import com.Emerald.hrSystem.Validation.Validation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String showLogin(Model model) {
      model.addAttribute("userLogin", new User());
      return "login";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(@ModelAttribute User userLogin, Model model) {
    Validation validation = new Validation();
    return validation.loginValidation(userLogin);
  }
}








