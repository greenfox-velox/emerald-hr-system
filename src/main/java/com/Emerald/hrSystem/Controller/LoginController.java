package com.Emerald.hrSystem.Controller;

import com.Emerald.hrSystem.Validation.Validation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
  @RequestMapping("/login")
  public class LoginController {

    private Validation validation = new Validation();

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView login() {
      ModelAndView modelAndView = new ModelAndView();
      modelAndView.setViewName("login");
      return modelAndView;
    }
    @RequestMapping(value = "/default", method = RequestMethod.GET)
    public String successFulLogin() {
      if (validation.hasRole("ADMIN")) {
        return "redirect:/admin";
      }
      else {
        return "redirect:/user";
      }
    }
}


