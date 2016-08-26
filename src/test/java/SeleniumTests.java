
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SeleniumTests {

  private WebDriver driver;
  private String testEmail = "test@test.com";
  private String testUserName = "SeleniumTest";
  private String testPassword = "12341234";

  @Before
  public void setUp(){
    driver = new ChromeDriver();
  }

  @Test
  public void test_userCanRegister() {
    String defaultRegistrationUrl = "http://localhost:8080/registration";
    driver.get(defaultRegistrationUrl);
    WebElement email = driver.findElement(By.id("email"));
    WebElement username = driver.findElement(By.id("username"));
    WebElement password = driver.findElement(By.id("password"));
    WebElement passwordConfirm = driver.findElement(By.id("confirm"));
    email.sendKeys(testEmail);
    username.sendKeys(testUserName);
    password.sendKeys(testPassword);
    passwordConfirm.sendKeys(testPassword);
    driver.findElement(By.className("login-button")).click();
    driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

    assertEquals("INTERVIEWER", driver.findElement(By.tagName("h3")).getText());
    assertEquals(defaultRegistrationUrl, driver.getCurrentUrl());
  }

  @Test
  public void test_SignInRedirectsCorrectlyToWelcomePage() {
    String defaultLoginUrl = "http://localhost:8080/user";
    driver.get("http://localhost:8080/login");
    WebElement nameField = driver.findElement(By.id("username"));
    WebElement passwordField = driver.findElement(By.id("password"));
    nameField.sendKeys(testUserName);
    passwordField.sendKeys(testPassword);
    driver.findElement(By.className("login-button")).click();
    driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

    assertEquals("Dashboard", driver.getTitle());
    assertEquals(defaultLoginUrl, driver.getCurrentUrl());
    assertEquals("Hello " + testUserName + ", you are in!", driver.findElement(By.tagName("h1")).getText());
  }

  @After
  public void cleanUp(){
    if (driver != null) {
      driver.close();
      driver.quit();
    }
  }
}