package zavrsenTest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class MyAccountFunctionality {
	
	WebDriver driver;
	String url = "https://demo.nopcommerce.com/";
	String order = "https://demo.nopcommerce.com/order/history";
	String newPassword = "https://demo.nopcommerce.com/customer/changepassword";
	String reviews = "https://demo.nopcommerce.com/customer/productreviews";
	
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
  public void SeeOrders() {
	  
	  driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
	  driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("pecevski@hotmail.com");
	  driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("petrevski");
	  driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	  driver.findElement(By.xpath("//a[@class='ico-account']")).click();
	  driver.findElement(By.xpath("(//a[@href='/order/history']) [1]")).click();
	  
	  Assert.assertEquals(driver.getCurrentUrl(), order);
	  
  }
 
  @Test
  public void ChangePassword() {
	  
	  driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
	  driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("pecevski@hotmail.com");
	  driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("pecevski");
	  driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	  driver.findElement(By.xpath("//a[@class='ico-account']")).click();
	  driver.findElement(By.xpath("//a[normalize-space()='Change password']")).click();
	  driver.findElement(By.xpath("//input[@id='OldPassword']")).sendKeys("pecevski");
	  driver.findElement(By.xpath("//input[@id='NewPassword']")).sendKeys("petrevski");
	  driver.findElement(By.xpath("//input[@id='ConfirmNewPassword']")).sendKeys("petrevski");
	  driver.findElement(By.xpath("//button[normalize-space()='Change password']")).click();
	  
	  Assert.assertEquals(driver.getCurrentUrl(), newPassword);
}
  @Test
  public void ProductReviews() {
	  
	  driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
	  driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("pecevski@hotmail.com");
	  driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("petrevski");
	  driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	  driver.findElement(By.xpath("//a[@class='ico-account']")).click();
	  driver.findElement(By.xpath("//a[normalize-space()='My product reviews']")).click();
	  
	  
	  Assert.assertEquals(driver.getCurrentUrl(), reviews);
	  
  }
}