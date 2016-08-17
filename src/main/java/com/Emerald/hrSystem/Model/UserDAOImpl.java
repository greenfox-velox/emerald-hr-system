package com.Emerald.hrSystem.Model;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO{

  private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

  private JdbcTemplate jdbcTemplate;

  public UserDAOImpl(){}

  public UserDAOImpl(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public void saveOrUpdate(User user) {

    logger.debug("saveOrUpdate() executed!");

    if (get(user.getId()) != null) {
      logger.debug("updating existing User with Id: " + user.getId());

      String sql = "UPDATE User SET username=?, email=?, password=? WHERE id=?";
      jdbcTemplate.update(sql, user.getUserName(), user.getEmail(),
          user.getPassword(), user.getId());
    } else {

      logger.debug("saving User with username: " + user.getUserName());

      String sql = "INSERT INTO User (username, email, password)"
          + " VALUES (?, ?, ?)";
      jdbcTemplate.update(sql, user.getUserName(), user.getEmail(),
          user.getPassword());
    }
  }

  public String delete(int id) {

    logger.debug("deleting User from db with id: " + id + "------------  delete() executed!");

    String sql = "DELETE FROM User WHERE id=?";
    jdbcTemplate.update(sql, id);
    return "Deleted user with id: " + id;
  }

  public List<User> list() {

    logger.debug("getting Users from db ------------  list() executed!");

    String sql = "SELECT * FROM User";
    List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {

      @Override
      public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User aUser = new User();

        aUser.setId(rs.getInt("id"));
        aUser.setUserName(rs.getString("username"));
        aUser.setEmail(rs.getString("email"));
        aUser.setPassword(rs.getString("password"));

        logger.info(aUser.getUserName() + " found!");

        return aUser;
      }
    });
    return userList;
  }

  public User get(int id) {

    logger.debug("query existing User with Id: " + id);

    String sql = "SELECT * FROM User WHERE id=" + id;
    return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {

      @Override
      public User extractData(ResultSet rs) throws SQLException,
          DataAccessException {
        if (rs.next()) {
          User user = new User();
          user.setId(rs.getInt("id"));
          user.setUserName(rs.getString("username"));
          user.setEmail(rs.getString("email"));
          user.setPassword(rs.getString("password"));
          return user;
        }
        return null;
      }
    });
  }

}
