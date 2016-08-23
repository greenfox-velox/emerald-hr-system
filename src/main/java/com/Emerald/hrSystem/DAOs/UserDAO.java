package com.Emerald.hrSystem.DAOs;

import com.Emerald.hrSystem.Model.User;

import java.util.List;

public interface UserDAO {

  void saveOrUpdate(User user);

  String delete(int id);

  User get(int id);

  List<User> list();

  String deleteByName(String name);

}