package com.Emerald.hrSystem.Controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
  @RequestMapping("/login")

  public class LoginController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView login() {
      ModelAndView modelAndView = new ModelAndView();
      modelAndView.setViewName("login");
      return modelAndView;
    }
    @RequestMapping(value = "/default", method = RequestMethod.GET)
    public ModelAndView successFulLogin(HttpServletRequest request) {
      System.out.println(request.getUserPrincipal());
      ModelAndView modelAndView = new ModelAndView();
      if (request.isUserInRole("ADMIN")) {
        modelAndView.setViewName("admin");
      }
      else {
        modelAndView.setViewName("welcome");
      }
      return modelAndView;
    }
}


