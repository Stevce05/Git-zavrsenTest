package zavrsenTest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ShoppingCartFunctionality {
	
	WebDriver driver;
	String url = "https://demo.nopcommerce.com/";
	String expectedUrl = "https://demo.nopcommerce.com/onepagecheckout#opc-billing";
	String expectedLink = "https://demo.nopcommerce.com/htc-one-m8-android-l-50-lollipop";
	String remove = "https://demo.nopcommerce.com/cart";
	
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
  public void OpenCheckout() {
	  driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
	  driver.findElement(By.id("FirstName")).sendKeys("Pece");
	  driver.findElement(By.id("LastName")).sendKeys("Pecevski");
	  driver.findElement(By.id("Email")).sendKeys("pecevski@hotmail.com");
	  driver.findElement(By.id("Password")).sendKeys("pecevski");
	  driver.findElement(By.id("ConfirmPassword")).sendKeys("pecevski");
	  driver.findElement(By.xpath("//button[@id='register-button']")).click();
	  driver.findElement(By.partialLinkText("Electronics")).click();
	  driver.findElement(By.partialLinkText("Cell phones")).click();
	  driver.findElement(By.partialLinkText("HTC One M8 Android L 5.0 Lollipop")).click();
	  driver.findElement(By.xpath("//button[@id='add-to-cart-button-18']")).click();
	  driver.findElement(By.xpath("//span[@class='cart-label']")).click();
	  driver.findElement(By.id("termsofservice")).click();
	  driver.findElement(By.id("checkout")).click();
	  
	  Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
	  
  }
  
  @Test
  public void OpenProductWithLink() {
	  
	  driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
	  driver.findElement(By.id("FirstName")).sendKeys("Pece");
	  driver.findElement(By.id("LastName")).sendKeys("Pecevski");
	  driver.findElement(By.id("Email")).sendKeys("pecevski@hotmail.com");
	  driver.findElement(By.id("Password")).sendKeys("pecevski");
	  driver.findElement(By.id("ConfirmPassword")).sendKeys("pecevski");
	  driver.findElement(By.xpath("//button[@id='register-button']")).click();
	  driver.findElement(By.partialLinkText("Electronics")).click();
	  driver.findElement(By.partialLinkText("Cell phones")).click();
	  driver.findElement(By.partialLinkText("HTC One M8 Android L 5.0 Lollipop")).click();
	  driver.findElement(By.xpath("//button[@id='add-to-cart-button-18']")).click();
	  driver.findElement(By.xpath("(//span[@class='cart-label'])[1]")).click();
	  driver.findElement(By.xpath("(//a[@class='product-name'])[1]")).click();
	  
	  Assert.assertEquals(driver.getCurrentUrl(), expectedLink );
	  
      }
  
  @Test
  public void RemoveProductFromCart() {
	  
	  driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
	  driver.findElement(By.id("FirstName")).sendKeys("Pece");
	  driver.findElement(By.id("LastName")).sendKeys("Pecevski");
	  driver.findElement(By.id("Email")).sendKeys("pecevski@hotmail.com");
	  driver.findElement(By.id("Password")).sendKeys("pecevski");
	  driver.findElement(By.id("ConfirmPassword")).sendKeys("pecevski");
	  driver.findElement(By.xpath("//button[@id='register-button']")).click();
	  driver.findElement(By.partialLinkText("Electronics")).click();
	  driver.findElement(By.partialLinkText("Cell phones")).click();
	  driver.findElement(By.partialLinkText("HTC One M8 Android L 5.0 Lollipop")).click();
	  driver.findElement(By.xpath("//button[@id='add-to-cart-button-18']")).click();
	  driver.findElement(By.xpath("(//span[@class='cart-label'])[1]")).click();
	  driver.findElement(By.xpath("(//button[@class='remove-btn'])[1]")).click();
	  
	  Assert.assertEquals(driver.getCurrentUrl(), remove);
	  
      }
  }
 


