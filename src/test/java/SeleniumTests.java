
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;



import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class SeleniumTests {

  private WebDriver driver;

  @Before
  public void setUp(){
    driver = new ChromeDriver();
  }


  @Test
  public void startTest() {
    driver.get("http://www.google.com");
    WebElement searchBox = driver.findElement(By.name("q"));
    searchBox.sendKeys("webdriver");
    searchBox.click();
    assertEquals("webdriver", driver.getTitle());
//    driver.get("http://localhost:8080/login");
//
//    driver.findElement(By.id("username")).sendKeys("Pocok");
//    driver.findElement(By.id("password")).sendKeys("12341234");
//
//    driver.findElement(By.id("loginButton")).click();
//
//    assertTrue(driver.getPageSource().contains("Hello Pocok"));
  }

  @After
  public void cleanUp(){
    if (driver != null) {
      driver.close();
      driver.quit();
    }
  }


}