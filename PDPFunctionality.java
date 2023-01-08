package zavrsenTest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class PDPFunctionality {
	
	WebDriver driver;
	String url = "https://demo.nopcommerce.com/";
	String expectedPage = "https://demo.nopcommerce.com/adidas-consortium-campus-80s-running-shoes";
	
	
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
  public void AddToCartShoes() { 
	  
	  WebElement clickApp = driver.findElement(By.partialLinkText("Apparel"));
	  clickApp.click();
	  WebElement clickSh = driver.findElement(By.partialLinkText("Shoes"));
	  clickSh.click();
	  WebElement clickPr = driver.findElement(By.partialLinkText("adidas Consortium Campus 80s Running Shoes"));
	  clickPr.click();
	  
	  driver.get("https://demo.nopcommerce.com/adidas-consortium-campus-80s-running-shoes");
	  Select drpSize = new Select(driver.findElement(By.name("Size")));
	  drpSize.selectByVisibleText("9");
	  
	  WebElement radio1 = driver.findElement(By.xpath("//span[@title='Red']//span[@class='attribute-square']"));
	  radio1.click();
	  
	   WebElement clickAdd = driver.findElement(By.id("add-to-cart-button-25"));
	   clickAdd.click();
	  
	  Assert.assertEquals(driver.getCurrentUrl(), expectedPage);
	  
  }
  
}
