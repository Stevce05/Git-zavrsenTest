package zavrsenTest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class CheckoutFunctionality {
	
	WebDriver driver;
	String url = "https://demo.nopcommerce.com/";
	String expectedPage = "https://demo.nopcommerce.com/checkout/completed";
	
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
  public void Checkout() {
	  
	  driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
	  driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("pecevski@hotmail.com");
	  driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("petrevski");
	  driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	  driver.findElement(By.partialLinkText("Electronics")).click();
	  driver.findElement(By.partialLinkText("Cell phones")).click();
	  driver.findElement(By.partialLinkText("HTC One M8 Android L 5.0 Lollipop")).click();
	  driver.findElement(By.xpath("//button[@id='add-to-cart-button-18']")).click();
	  driver.findElement(By.xpath("//span[@class='cart-label']")).click();
	  driver.findElement(By.id("termsofservice")).click();
	  driver.findElement(By.id("checkout")).click();
	  driver.findElement(By.xpath("//input[@id='BillingNewAddress_FirstName']")).sendKeys("Pece");
	  driver.findElement(By.xpath("//input[@id='BillingNewAddress_LastName']")).sendKeys("Pecevski");
	  Select drpCountry = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
	  drpCountry.selectByVisibleText("Avghanistan");
	  driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("Prilep");
	  driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("pecevska");
	  driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("7000");
	  driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("123456789");
	  driver.findElement(By.xpath("//button[@onclick='Billing.save()']")).click();
	  driver.findElement(By.id("shippingoption_0")).click();
	  driver.findElement(By.xpath("(//button[@class='button-1 shipping-method-next-step-button'])[1]")).click();
	  driver.findElement(By.id("paymentmethod_0")).click();
	  driver.findElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']")).click();
	  driver.findElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']")).click();
	  driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();
	  
	Assert.assertEquals(driver.getCurrentUrl(), expectedPage);  
  }
 

}
