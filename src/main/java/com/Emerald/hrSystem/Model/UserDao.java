package com.Emerald.hrSystem.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserDao implements IUserDao {

  @Autowired
  private HibernateTemplate hibernateTemplate;

  @Override
  public boolean addUser(String name, String email, String password) {
    User newUser = new User();
    newUser.setUserName(name);
    newUser.setEmail(email);
    newUser.setPassword(password);
    hibernateTemplate.save(newUser);
    return false;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<User> getUserByEmail(String email) {
    String getByEmail = "FROM User as u WHERE u.email = ?";
    return (List<User>) hibernateTemplate.find(getByEmail, email);
  }

  @Override
  public User getUserById(long id) {
    return hibernateTemplate.get(User.class, id);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<User> getAllUsers() {
    String getAllUsers = "FROM User as u ORDER BY u.id";
    return (List<User>) hibernateTemplate.find(getAllUsers);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<User> getUserByName(String name) {
    String getByName = "FROM User as u WHERE u.name = ?";
    return (List<User>) hibernateTemplate.find(getByName, name);
  }

  @Override
  public void updateUser(User user) {
    User u = getUserById(user.getId());
    u.setUserName(user.getUserName());
    u.setPassword(user.getPassword());
    u.setEmail(user.getEmail());
    hibernateTemplate.update(u);
  }

  @Override
  public void deleteUser(long id) {
    hibernateTemplate.delete(getUserById(id));
  }

  @SuppressWarnings("unchecked")
  @Override
  public boolean userExists(String username) {
    String hql = "FROM User as u WHERE u.name = ?";
    List<User> users = (List<User>) hibernateTemplate.find(hql, username);
    return users.size() > 0;
  }


}
