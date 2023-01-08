package zavrsenTest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginFunctionality {
	WebDriver driver;
	String url = "https://demo.nopcommerce.com/";
	String expectedLoginPage = "https://demo.nopcommerce.com/";
	String wrongExpectedPage = "https://demo.nopcommerce.com/login?returnurl=%2F";
	String wrongExpectedPassword = "https://demo.nopcommerce.com/login?returnurl=%2F";

	
 @BeforeMethod
	  public void beforeMethod() {
	 
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 driver.get(url);
	 driver.manage().window().maximize();
   }
 
 @AfterMethod
 public void afterMethod() throws InterruptedException {
	 Thread.sleep(8000);
	 driver.close();
	 driver.quit();	 
   }
 
 
  @Test
  public void LoginValidCredentials() {
	  
	 driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
	 driver.findElement(By.id("Email")).sendKeys("pecevski@hotmail.com");
	 driver.findElement(By.id("Password")).sendKeys("pecevski");
	 driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	
	 
	 Assert.assertEquals(driver.getCurrentUrl(), expectedLoginPage);
  }
 
  @Test
  public void LoginWrongEmail() {
	  
	 driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
	 driver.findElement(By.id("Email")).sendKeys("petrevski@hotmail.com");
	 driver.findElement(By.id("Password")).sendKeys("pecevski");
	 driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	
	 
	 Assert.assertEquals(driver.getCurrentUrl(), wrongExpectedPage);
  }

 
  @Test
  public void LoginWrongPassword() {
	  
	 driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
	 driver.findElement(By.id("Email")).sendKeys("pecevski@hotmail.com");
	 driver.findElement(By.id("Password")).sendKeys("pecovski");
	 driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	
	 
	 Assert.assertEquals(driver.getCurrentUrl(), wrongExpectedPassword);
  }
}
