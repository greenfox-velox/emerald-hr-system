package com.Emerald.hrSystem;

import com.Emerald.hrSystem.Model.User;
import java.util.ArrayList;

  public class Database {
    public Database() {
      fillUsers();
    }

    ArrayList<User> users = new ArrayList<>();
    int id = 3;

    public void fillUsers() {
      users.add(new User(1, "Anna", "anna@anna.com", "pwa"));
      users.add(new User(2, "Zsolt", "zsolt@zsolt.com", "pwzs"));
      users.add(new User(3, "Pocok", "pocok@pocok.com", "pwp"));
    }

    public User addUser(User newUser) {
      newUser.setId(++id);
      users.add(newUser);
      return newUser;
    }

    public String loginUser(User loginUser) {
      for (int item = 0; item < users.size(); item++) {
        if (userNameCheck(item, loginUser) && passwordCheck(item, loginUser)) {
          return "accept";
        } else if (userNameCheck(item, loginUser) && !(passwordCheck(item, loginUser))) {
          return "rejectpassword";
        }
      }
      return "rejectusername";
    }

    public Boolean userNameCheck(int item, User user) {
      return users.get(item).getUserName().equals(user.getUserName());
    }

    public Boolean passwordCheck(int item, User user) {
      return users.get(item).getPassword().equals(user.getPassword());
    }
  }

