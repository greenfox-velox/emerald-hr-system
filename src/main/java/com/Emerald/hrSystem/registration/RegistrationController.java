package com.Emerald.hrSystem.registration;

import com.Emerald.hrSystem.Database;
import com.Emerald.hrSystem.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

/**
 * Created by annatorok on 03/08/16.
 */

@Controller
public class RegistrationController {

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
