package zavrsenTest;

import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class RegisterFunctionality {
	
	WebDriver driver;
	String url = "https://demo.nopcommerce.com/";
	String expectedPage = "https://demo.nopcommerce.com/registerresult/1?returnUrl=/";
	String EmptyPasswordField = "https://demo.nopcommerce.com/register?returnUrl=%2F";
	String InvalidEmail = "https://demo.nopcommerce.com/register?returnUrl=%2F";

	 @BeforeMethod
	  public void beforeMethod() {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get(url);
		 driver.manage().window().maximize();
		 
	  }

	  @AfterMethod
	  public void afterMethod() throws InterruptedException {
		  Thread.sleep(1000);
		  driver.close();
	  }
	
  @Test
  public void RegisterWithWalidCredentials() {
	  
	  driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
	  driver.findElement(By.id("FirstName")).sendKeys("Pece");
	  driver.findElement(By.id("LastName")).sendKeys("Pecevski");
	  driver.findElement(By.id("Email")).sendKeys("pecevski@hotmail.com");
	  driver.findElement(By.id("Password")).sendKeys("pecevski");
	  driver.findElement(By.id("ConfirmPassword")).sendKeys("pecevski");
	  driver.findElement(By.xpath("//button[@id='register-button']")).click();
	  
  Assert.assertEquals(driver.getCurrentUrl(), expectedPage);
   
  }
  
  @Test
  public void RegisterWithInvalidEmail() {
	  
	  driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
	  driver.findElement(By.id("FirstName")).sendKeys("Pece");
	  driver.findElement(By.id("LastName")).sendKeys("Pecevski");
	  driver.findElement(By.id("Email")).sendKeys("pecevski#hotmail.com");
	 
	  Assert.assertEquals(driver.getCurrentUrl(), InvalidEmail);
	  
	
 
  }
  
  @Test
  public void RegisterWithEmpptyPassweordField() {
	  
	  driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
	  driver.findElement(By.id("FirstName")).sendKeys("Pece");
	  driver.findElement(By.id("LastName")).sendKeys("Pecevski");
	  driver.findElement(By.id("Email")).sendKeys("pecevski@hotmail.com");
	  driver.findElement(By.id("ConfirmPassword")).sendKeys("pecevski");
	  driver.findElement(By.xpath("//button[@id='register-button']")).click();
	  
	  String ActualTitle = driver.getTitle();
	  String ExpectedTitle = "The password and confirmation password do not match.";
	  Assert.assertEquals(ActualTitle, ExpectedTitle);
	  
	
 
  }
}
