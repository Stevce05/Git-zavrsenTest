package zavrsenTest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class SearchFunctionality {
	
	WebDriver driver;
	String url = "https://demo.nopcommerce.com/";
	String expectedExisting = "https://demo.nopcommerce.com/search?q=computer";
	String expectedNonExisting = "https://demo.nopcommerce.com/search?q=tree";
	
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
  public void ExistingProduct() {
	  
	  driver.findElement(By.id("small-searchterms")).sendKeys("computer");
	  driver.findElement(By.xpath("//button[@class='button-1 search-box-button']")).click();
	  
	  Assert.assertEquals(driver.getCurrentUrl(), expectedExisting);
	  
  }
  
  @Test
  public void NonExistingProduct() {
	  
	  driver.findElement(By.id("small-searchterms")).sendKeys("tree");
	  driver.findElement(By.xpath("//button[@class='button-1 search-box-button']")).click();
	  
	  Assert.assertEquals(driver.getCurrentUrl(), expectedNonExisting);
	  
  }
 

}
