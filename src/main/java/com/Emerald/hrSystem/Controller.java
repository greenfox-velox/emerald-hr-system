package com.Emerald.hrSystem;

import com.Emerald.hrSystem.Model.User;
import com.Emerald.hrSystem.Model.UserDAO;
import com.Emerald.hrSystem.Validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    Validation validation = new Validation();

    @Autowired
    private UserDAO userDAO;


    @RequestMapping(value="/users", method = RequestMethod.GET)
      public String listUsers(Model model) throws IOException {
      List<User> users = userDAO.list();
      model.addAttribute("userDb", users);
      return "users";
      }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(Model model) {
      model.addAttribute("userLogin", new User());
      return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User userLogin, Model model) {
      return validation.loginValidation(userLogin);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
      model.addAttribute("newUser", new User());
      return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addNewUser(@Valid @ModelAttribute("newUser") User newUser, BindingResult bindingResult) {
      if (bindingResult.hasErrors()) {
        return "registration";
      } else {
        userDAO.saveOrUpdate(newUser);
        return "welcome";
      }
    }
}