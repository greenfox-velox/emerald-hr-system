package com.Emerald.hrSystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/welcome")
public class DashboardController {

  @RequestMapping(value = "")
  public ModelAndView dashboard() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("welcome");
    return modelAndView;
  }
}
