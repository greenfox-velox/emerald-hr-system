package com.Emerald.hrSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.Emerald.hrSystem.Model.UserDAO;

@Controller
public class Dashboard {

  @Autowired
  private UserDAO userDAO;

  @RequestMapping(value = "/user")
  public ModelAndView userDashboard() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("userDashboard");
    return modelAndView;
  }

  @RequestMapping(value = "/admin")
  public ModelAndView adminDashboard() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("adminDashboard");
    return modelAndView;
  }

  @RequestMapping(value="/admin/users", method = RequestMethod.GET)
  public String listUsers(Model model) throws IOException {
    model.addAttribute("userDb", userDAO.list());
    return "users";
  }

  @RequestMapping(value = "/admin/delete/{id}", method = RequestMethod.POST)
  public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
    userDAO.delete(id);
    return new ResponseEntity<>("Deleted!", HttpStatus.CREATED);
  }
}
