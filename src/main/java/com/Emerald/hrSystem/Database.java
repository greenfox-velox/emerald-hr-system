package com.Emerald.hrSystem;

import com.Emerald.hrSystem.Model.User;
import java.util.ArrayList;

  public class Database {

      public Database() {
      fillUsers();
    }

    public ArrayList<User> users = new ArrayList<>();
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

    public Boolean userNameCheck( User listUser, User user) {
      return listUser.getUserName().equals(user.getUserName());
    }

    public Boolean passwordCheck( User listUser, User user) {
      return listUser.getPassword().equals(user.getPassword());
    }

    public boolean isUserNameFree(User userName) {
        for (User user : users) {
            if (user.getUserName().equals(userName.getUserName())) {
                return false;
            }
        }
        return true;
    }

      public String registerUser (User newUser) {
          if (isUserNameFree(newUser) && registrationPasswordCheck(newUser)){
              addUser(newUser);
              return "welcome";
          } else {
              return "registration";
          }
      }

      public boolean registrationPasswordCheck(User newUser) {
          return newUser.getPassword().equals(newUser.getPasswordConfirm());
      }
}

