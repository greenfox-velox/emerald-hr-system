package config;

/**
 * Created by pocok on 8/9/16.
 */

import javax.sql.DataSource;

import dao.IUserDao;
import dao.UserDao;
import entity.User;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

  @Bean
  public IUserDao userDao() {
    return new UserDao();
  }

  @Bean
  public HibernateTemplate hibernateTemplate() {
    return new HibernateTemplate(sessionFactory());
  }

  @Bean
  public SessionFactory sessionFactory() {
    return new LocalSessionFactoryBuilder(getDataSource())
        .addAnnotatedClasses(User.class)
        .buildSessionFactory();
  }

  @Bean
  public DataSource getDataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/firstdb");
    dataSource.setUsername("root");
    dataSource.setPassword("Pocok07");
    return dataSource;
  }

  @Bean
  public HibernateTransactionManager hibTransMan(){
    return new HibernateTransactionManager(sessionFactory());
  }
}