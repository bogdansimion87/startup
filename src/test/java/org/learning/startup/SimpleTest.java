package org.learning.startup;


import java.util.concurrent.TimeUnit;

import org.learning.startup.emag.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;


public class SimpleTest {
	
  public WebDriver driver;
  
  
  @Test 
  public void testLoggedInWithPO() throws InterruptedException
  {
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.login("bogdansimion87@gmail.com", "Ciohorani1987");
	  Assert.assertTrue(loginPage.getMyAccountLabel().isDisplayed(), "My Account Lable is displayed");
  }
  
  @Test 
  public void testWrongPassPO() throws InterruptedException
  {
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.login("bogdansimion87@gmail.com", "Ciohorani19871");
	  Assert.assertEquals(loginPage.getLogginErrorLabel(), "Ai introdus gresit parola sau adresa de email. Te rog completeaza din nou.");
  }
  
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	// Create a new instance of the Firefox driver
    driver = new FirefoxDriver();
	
	//Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception	 
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	//Launch the  Website
    driver.get("https://www.emag.ro/user/login");
  }

  
  
  
  @AfterMethod
  public void afterMethod() {
	  
	// Close the driver	  
	driver.quit();
  }

}
