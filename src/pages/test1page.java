package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test1page {
	
	WebDriver driver;
  @Test
  public void openbrowser() throws IOException {
	  //System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
		//driver = new FirefoxDriver();
		FileInputStream f = new FileInputStream("C:\\Testing\\prop.properties");
		Properties prop = new Properties();
		prop.load(f);
	  
		String browser = prop.getProperty("browser");
		if(browser.equals("Firefox")) {
			 System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			 System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}
  }
  
  @Test
  public void openurl() {
	  driver.get("https://www.facebook.com/");
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  
  }
  
  @Test
  public void login(String email,String password) throws InterruptedException {
	  driver.findElement(By.id("email")).sendKeys(email);
	  driver.findElement(By.name("pass")).sendKeys(password);
	  driver.findElement(By.tagName("button")).click();
  }
  
  @Test
  public void error() {
	  
	  String expectederr = "Wrong Credentials\n"
	  		+ "Invalid username or password";
	  //String expectederr ="The email or mobile number you entered isn’t connected to an account. Find your account and log in.";
	  String actualerr = driver.findElement(By.id("error_box")).getText();
	  
	  //String actualerr = driver.findElement(By.className("_9ay7")).getText();
	  Assert.assertEquals(actualerr, expectederr);
  
  }
  
  @Test
  public void close() {
	  driver.quit();
  }
}