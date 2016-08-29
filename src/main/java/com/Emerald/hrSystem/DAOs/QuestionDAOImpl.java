package com.Emerald.hrSystem.DAOs;

import com.Emerald.hrSystem.Model.Question;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by pocok on 8/26/16.
 */
public class QuestionDAOImpl implements QuestionDAO{

  private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

  private JdbcTemplate jdbcTemplate;

  public QuestionDAOImpl() {
  }

  public QuestionDAOImpl(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public void add(Question question) {
    logger.debug("Question add() executed!");

    String sql = "INSERT INTO Questions (title)"
        + " VALUES (?)";
    jdbcTemplate.update(sql, question.getTitle());

    logger.debug(question.toString());
  }

  @Override
  public void deleteById(int id) {
    logger.debug("Question deleteById() executed!");

    String sql = "DELETE FROM Questions WHERE id=?";
    logger.debug("deleted: " + getById(id).toString());

    jdbcTemplate.update(sql, id);

  }

  @Override
  public Question getById(int id) {
    logger.debug("Question getById() executed!");

    String sql = "SELECT * FROM Questions WHERE id= ?";

    return jdbcTemplate.query(sql, new Object[] {id}, new ResultSetExtractor<Question>() {

      @Override
      public Question extractData(ResultSet rs) throws SQLException,
          DataAccessException {
        if (rs.next()) {
          Question question = new Question();
          question.setId(rs.getInt("id"));
          question.setTitle(rs.getString("title"));

          logger.debug("Found question: " + question.toString());

          return question;
        }
        return null;
      }
    });
  }

  @Override
  public Question getByTitle(String title) {
    logger.debug("Question getByName() executed!");

    String sql = "SELECT * FROM Questions WHERE title= ?";

    return jdbcTemplate.query(sql, new Object[] {title}, new ResultSetExtractor<Question>() {

      @Override
      public Question extractData(ResultSet rs) throws SQLException,
          DataAccessException {
        if (rs.next()) {
          Question question = new Question();
          question.setId(rs.getInt("id"));
          question.setTitle(rs.getString("title"));

          logger.debug("Found question: " + question.toString());

          return question;
        }
        return null;
      }
    });
  }

  @Override
  public void update(Question question) {
    logger.debug("Question update() executed!");

    String sql = "UPDATE Question SET title=? WHERE id=?";
    jdbcTemplate.update(sql, question.getTitle(), question.getId());
    logger.debug("Updated question: " + question.toString());

  }
}
