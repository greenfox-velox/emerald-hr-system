package com.Emerald.hrSystem;

import com.Emerald.hrSystem.Model.User;
import com.Emerald.hrSystem.Validation.Validation;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;

@Controller
public class Controller {

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

    Database userDb = new Database();

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("newUser", new User());
        return "registration";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Database showUsers(Model model) {
        model.addAttribute("userDb", userDb.users);
        return userDb;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addNewUser(@Valid @ModelAttribute("newUser") User newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        } else if (userDb.isUserNameFree(newUser.getUserName())){
            userDb.addUser(newUser);
        }
        return "result";
    }
}

