package com.Emerald.hrSystem;

/**
 * Created by annatorok on 04/08/16.
 */
import com.Emerald.hrSystem.Model.User;
import java.util.ArrayList;

public class Database {

    public Database(){
        fillUsers();
    }

    public ArrayList<User> users = new ArrayList<>();
    int id = 3;

    public ArrayList<User> getUsers(){
        return users;
    }

    public void fillUsers() {
        users.add(new User(1, "Anna", "anna@anna.com", "password"));
        users.add(new User(2, "Zsolt", "zsolt@zsolt.com", "password"));
        users.add(new User(3, "Pocok", "pocok@pocok.com", "password"));
    }

    public User addUser(User newUser) {
        newUser.setId(++id);
        users.add(newUser);
        return newUser;
    }

    public boolean isUserNameFree(String userName) {
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return false;
            }
        }
        return true;
    }

}
