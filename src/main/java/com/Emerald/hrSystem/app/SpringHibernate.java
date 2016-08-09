package app;

/**
 * Created by pocok on 8/9/16.
 */

import config.DatabaseConfig;
import dao.IUserDao;
import entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringHibernate {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.register(DatabaseConfig.class);
    ctx.refresh();
    IUserDao udao = ctx.getBean(IUserDao.class);

    if(udao.userExists("Anna")) {
      System.out.println("Anna exists!!!");
    }

    User updatePocok = new User();
    updatePocok.setId(1L);
    updatePocok.setName("Pocok");
    updatePocok.setEmail("uj-email@yolo.com");
    updatePocok.setPassword("123456789");
    udao.updateUser(updatePocok);
    System.out.println("Get user by email");
    System.out.println(udao.getUserByEmail("ize@test.com"));

  }
}
