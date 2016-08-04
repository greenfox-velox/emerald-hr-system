package com.Emerald.hrSystem.Model;

import java.util.List;
import javax.sql.DataSource;

public interface UserDAO {

  public void setDataSource(DataSource ds);

  public void create(String userName, String email, String password);

  public User getStudent(Integer id);

  public List<User> listStudents();

  public void delete(Integer id);

  public void update(Integer id, Integer age);
}