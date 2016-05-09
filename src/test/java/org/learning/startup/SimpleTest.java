package org.learning.startup;

import org.learning.startup.emag.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
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
  

  
  
  
  @AfterMethod
  public void afterMethod() {
	  
	// Close the driver	  
	driver.quit();
  }

}
