package com.Emerald.hrSystem;

import com.Emerald.hrSystem.Model.User;
import com.Emerald.hrSystem.Model.UserDAO;
import com.Emerald.hrSystem.Validation.Validation;
import org.springframework.ui.Model;
import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {


    private static final Logger logger = Logger.getLogger(Controller.class);
    Validation validation = new Validation();

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value="/users", method = RequestMethod.GET)
      public String listUsers(Model model) throws IOException {

        logger.debug("listUsers() #### [ /users ] is executed!");

        model.addAttribute("userDb", userDAO.list());
        return "users";
      }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(Model model) {

      logger.debug("showLogin() #### [ /login ] is executed!");

      model.addAttribute("userLogin", new User());
      return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User userLogin, Model model) {

      logger.debug("login() #### [ /login ] is executed!");

      model.addAttribute("User", userLogin);
      return validation.loginValidation(userLogin,userDAO);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {

      logger.debug("showRegistrationForm() #### [ /register ] is executed!");

      model.addAttribute("newUser", new User());
      return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addNewUser(@Valid @ModelAttribute("newUser") User newUser, BindingResult bindingResult) {

      logger.debug("addNewUser() #### [ /register ] is executed!");

      if (bindingResult.hasErrors()) {

        logger.info("registration form had errors -----> redirect to [ /register ]");

        return "registration";
      } else {

        logger.info("user saved ------> redirect to [ /welcome ]");

        return validation.registrationValidation(newUser,userDAO);

      }
    }
}