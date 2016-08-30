package com.Emerald.hrSystem.DAOs;

import com.Emerald.hrSystem.Model.Category;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by pocok on 8/30/16.
 */
public class CategoryDAOImpl implements CategoryDAO {

  private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

  private JdbcTemplate jdbcTemplate;

  public CategoryDAOImpl() {
  }

  public CategoryDAOImpl(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }


  @Override
  public void add(Category category) {
    logger.debug("Category add() executed!");

    String sql = "INSERT INTO Categories (name)"
        + " VALUES (?)";
    jdbcTemplate.update(sql, category.getName());

    logger.debug(category.toString());

  }

  @Override
  public void deleteById(int id) {
    logger.debug("Category deleteById() executed!");

    String sql = "DELETE FROM Categories WHERE id=?";
    logger.debug("deleted: " + getById(id).toString());

    jdbcTemplate.update(sql, id);
  }

  @Override
  public void deleteByName(String name) {
    logger.debug("Category deleteByName() executed!");

    String sql = "DELETE FROM Categories WHERE name=?";
    logger.debug("deleted: " + getByName(name).toString());
    jdbcTemplate.update(sql, name);

  }

  @Override
  public Category getById(int id) {
    logger.debug("Category getById() executed!");

    String sql = "SELECT * FROM Categories WHERE id= ?";

    return jdbcTemplate.query(sql, new Object[] {id}, new ResultSetExtractor<Category>() {

      @Override
      public Category extractData(ResultSet rs) throws SQLException,
          DataAccessException {
        if (rs.next()) {
          Category category = new Category();
          category.setId(rs.getInt("id"));
          category.setName(rs.getString("name"));

          logger.debug("Found category: " + category.toString());

          return category;
        }
        return null;
      }
    });
  }

  @Override
  public Category getByName(String name) {
    logger.debug("Category getByName() executed!");

    String sql = "SELECT * FROM Categories WHERE name= ?";

    return jdbcTemplate.query(sql, new Object[] {name}, new ResultSetExtractor<Category>() {

      @Override
      public Category extractData(ResultSet rs) throws SQLException,
          DataAccessException {
        if (rs.next()) {
          Category category = new Category();
          category.setId(rs.getInt("id"));
          category.setName(rs.getString("name"));

          logger.debug("Found category: " + category.toString());

          return category;
        }
        return null;
      }
    });
  }

  @Override
  public void updateNameById(int id, String name) {
    logger.debug("Category updateNameById() executed!");

    String sql = "UPDATE Categories SET name=? WHERE id=?";
    jdbcTemplate.update(sql, name, id);
    logger.debug("Updated question: " + getById(id).toString());

  }
}
