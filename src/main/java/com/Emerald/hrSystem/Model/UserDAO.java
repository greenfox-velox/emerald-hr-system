package com.Emerald.hrSystem.Model;

import java.util.List;

public interface UserDAO {

  public void saveOrUpdate(User user);

  public void delete(int id);

  public User get(int id);

  public List<User> list();
}