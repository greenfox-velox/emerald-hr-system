package com.Emerald.hrSystem.registration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by annatorok on 03/08/16.
 */

@Controller
public class RegistrationController {

//    Database userDb = new Database();

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("newUser", new User());
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute User newUser, Model model) {
        model.addAttribute("email", newUser.getEmail());
        model.addAttribute("username", newUser.getUsername());
        model.addAttribute("password", newUser.getPassword());
        model.addAttribute("passwordConfirm", newUser.getPasswordConfirm());
        return "result";
    }
}