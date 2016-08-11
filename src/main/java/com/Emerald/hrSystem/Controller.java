package com.Emerald.hrSystem;

import com.Emerald.hrSystem.Model.User;
import com.Emerald.hrSystem.Model.UserDao;
import com.Emerald.hrSystem.Validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@org.springframework.stereotype.Controller
public class Controller {

//    Validation validation = new Validation();
//    Database userDb = new Database();

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(Model model) {
        model.addAttribute("userLogin", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User userLogin, Model model) {
        try {
            User currentUser = userDao.getUserByName(userLogin.getUserName()).get(0);
            if (currentUser.getPassword().equals(userLogin.getPassword())) {
                return "accept";
            }
            return "rejectpassword";
        } catch (Exception e) {
            return "rejectusername";
        }
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
            try {
              userDao.addUser(newUser.getUserName(), newUser.getEmail(), newUser.getPassword());
              return "welcome";
            } catch (Exception e) {
              return "registration";
            }
        }
    }
}