package zavrsenTest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class PLPFunctionality {
	
	WebDriver driver;
	String url = "https://demo.nopcommerce.com/";
	String ExpectedPageC = "https://demo.nopcommerce.com/apple-macbook-pro-13-inch";
	String ExpectedPageA = "https://demo.nopcommerce.com/notebooks?viewmode=grid&orderby=0&pagesize=6&specs=6%2C9";
	String ExpectedPageCh = "https://demo.nopcommerce.com/htc-one-m8-android-l-50-lollipop";
	
	
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
	  
	  driver.findElement(By.partialLinkText("Computers")).click();
	  driver.findElement(By.partialLinkText("Notebooks")).click();
	  driver.findElement(By.partialLinkText("Apple MacBook Pro 13-inch")).click();
	  
	  Assert.assertEquals(driver.getCurrentUrl(), ExpectedPageC);
	  	  
  }
  @Test
  public void ExistingProductAtributes() {
	  
	  driver.findElement(By.partialLinkText("Computers")).click();
	  driver.findElement(By.partialLinkText("Notebooks")).click();
	  driver.findElement(By.id("attribute-option-6")).click();
	  driver.findElement(By.id("attribute-option-9")).click();
	  	  
	  Assert.assertEquals(driver.getCurrentUrl(), ExpectedPageA);
	  	  
  }

  @Test
  public void ExistingProductADDToCart() {
	  
	  driver.findElement(By.partialLinkText("Electronics")).click();
	  driver.findElement(By.partialLinkText("Cell phones")).click();
	  driver.findElement(By.partialLinkText("HTC One M8 Android L 5.0 Lollipop")).click();
	  driver.findElement(By.xpath("//button[@id='add-to-cart-button-18']")).click();
	  
	  String ActualTitle = driver.getTitle();
	  String ExpectedTitle = "https://demo.nopcommerce.com/htc-one-m8-android-l-50-lollipop: The product has been added to your shopping cart";
	  Assert.assertEquals(ActualTitle, ExpectedTitle);
	
	  
	  
	  	  
  }
}
