package com.Emerald.hrSystem;

import com.Emerald.hrSystem.Model.User;
import com.Emerald.hrSystem.Validation.Validation;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@org.springframework.stereotype.Controller
public class Controller {

    Validation validation = new Validation();
    Database userDb = new Database();

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(Model model) {
        model.addAttribute("userLogin", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User userLogin, Model model) {
        return validation.loginValidation(userLogin, userDb);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("newUser", new User());
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addNewUser(@Valid @ModelAttribute("newUser") User newUser) {
        return validation.registrationValidation(newUser, userDb);
        }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Database showUsers(Model model) {
        model.addAttribute("userDb", userDb.users);
        return userDb;
    }
}

