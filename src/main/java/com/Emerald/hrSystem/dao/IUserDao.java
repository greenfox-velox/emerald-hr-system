package dao;

import entity.User;

import java.util.List;

public interface IUserDao {

  List<User> getAllUsers();

  boolean addUser(String name, String email, String password);

  User getUserById(long id);

  List<User> getUserByName(String name);

  List<User> getUserByEmail(String email);

  void updateUser(User user);

  void deleteUser(long id);

  boolean userExists(String name);

}