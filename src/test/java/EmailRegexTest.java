import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class EmailRegexTest {

  private final Pattern emailPattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");

  @Test
  public void testWithAllValid() {
    List<String> emailsGood = new ArrayList<>();
    emailsGood.add("user@domain.com");
    emailsGood.add("user@domain.co.in");
    emailsGood.add("user.name@domain.com");
    emailsGood.add("user_name@domain.com");
    emailsGood.add("username@yahoo.corporate.in");
    emailsGood.add("user?name@domain.co.in");
    emailsGood.add("user'name@domain.co.in");
    emailsGood.add("email@example.com");
    emailsGood.add("firstname.lastname@example.com");
    emailsGood.add("email@subdomain.example.com");
    emailsGood.add("firstname+lastname@example.com");
    emailsGood.add("1234567890@example.com");
    emailsGood.add("email@example-one.com");
    emailsGood.add("email@example.co.jp");
    emailsGood.add("firstname-lastname@example.com");

    for (String email : emailsGood) {
      Matcher matcher = emailPattern.matcher(email);
      assertTrue(matcher.matches());
    }
  }

  @Test
  public void testWithAllInvalid() {
    List<String> emailsBad = new ArrayList<>();
    emailsBad.add(".username@yahoo.com");
    emailsBad.add("username@yahoo.com.");
    emailsBad.add("username@yahoo..com");
    emailsBad.add("#@%^%#$@#$@#.com");
    emailsBad.add("ize@.com");
    emailsBad.add("ize@com");
    emailsBad.add("123@.123");
    emailsBad.add("this\\ is\"really\"not\\allowed@example.com");


    for(String email : emailsBad){
      Matcher matcher = emailPattern.matcher(email);
      assertFalse(matcher.matches());
    }


  }
}
