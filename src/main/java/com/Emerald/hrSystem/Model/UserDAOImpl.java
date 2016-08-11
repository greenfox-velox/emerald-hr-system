package com.Emerald.hrSystem.Model;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO{

  private JdbcTemplate jdbcTemplate;

  public UserDAOImpl(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public void saveOrUpdate(User user) {
    if (user.getId() > 0) {
      // update
      String sql = "UPDATE User SET name=?, email=?, password=? WHERE id=?";
      jdbcTemplate.update(sql, user.getUserName(), user.getEmail(),
          user.getPassword(), user.getId());
    } else {
      // insert
      String sql = "INSERT INTO User (name, email, password)"
          + " VALUES (?, ?, ?)";
      jdbcTemplate.update(sql, user.getUserName(), user.getEmail(),
          user.getPassword());
    }

  }

  public void delete(int id) {
    String sql = "DELETE FROM User WHERE id=?";
    jdbcTemplate.update(sql, id);
  }

  public List<User> list() {
    String sql = "SELECT * FROM User";
    List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {

      @Override
      public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User aUser = new User();

        aUser.setId(rs.getInt("id"));
        aUser.setUserName(rs.getString("name"));
        aUser.setEmail(rs.getString("email"));
        aUser.setPassword(rs.getString("password"));
        return aUser;
      }
    });
    return userList;
  }

  public User get(int id) {
    String sql = "SELECT * FROM User WHERE id=" + id;
    return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {

      @Override
      public User extractData(ResultSet rs) throws SQLException,
          DataAccessException {
        if (rs.next()) {
          User user = new User();
          user.setId(rs.getInt("id"));
          user.setUserName(rs.getString("name"));
          user.setEmail(rs.getString("email"));
          user.setPassword(rs.getString("password"));
          return user;
        }
        return null;
      }
    });
  }

}
