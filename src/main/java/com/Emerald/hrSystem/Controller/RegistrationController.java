package com.Emerald.hrSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import com.Emerald.hrSystem.Model.User;
import com.Emerald.hrSystem.Model.UserDAO;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.Emerald.hrSystem.Validation.Validation;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

  @Autowired
  private UserDAO userDAO;
  private Validation validation = new Validation();

  @RequestMapping(value = "", method = RequestMethod.GET)
  public ModelAndView registration() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("newUser" , new User());
    modelAndView.setViewName("registration");
    return modelAndView;
  }

  @RequestMapping(value="", method=RequestMethod.POST)
  public ModelAndView registrationPost(@Valid @ModelAttribute("newUser") User newUser, BindingResult result) {
    ModelAndView modelAndView = new ModelAndView();
    validation.validate(newUser,result, userDAO);
    if (result.hasErrors()) {
      modelAndView.setViewName("registration");
    } else {
      modelAndView.setViewName("successfulRegistration");
    }
    return modelAndView;
  }
}

