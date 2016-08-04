package com.Emerald.hrSystem;

/**
 * Created by annatorok on 04/08/16.
 */
import com.Emerald.hrSystem.Model.User;
import java.util.ArrayList;

public class Database {

    ArrayList<User> users = new ArrayList<>();

    public User addNewUser(User newUser) {
        users.add(newUser);
        return newUser;
    }
}
