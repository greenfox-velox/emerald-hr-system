package com.Emerald.hrSystem.Controller;

import com.Emerald.hrSystem.Model.UserDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping("admin")
public class AdminController {

  @Autowired

  private UserDAO userDAO;
  @RequestMapping(value="/users", method = RequestMethod.GET)
  public String listUsers(Model model) throws IOException {
    model.addAttribute("userDb", userDAO.list());
    return "users";
  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
  public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
    userDAO.delete(id);
    return new ResponseEntity<>("Deleted!", HttpStatus.CREATED);
  }
}
