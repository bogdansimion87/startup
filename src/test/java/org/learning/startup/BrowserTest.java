package org.learning.startup;
import org.learning.startup.emag.EnvProperties;
import org.learning.startup.emag.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public abstract class BrowserTest {
	public WebDriver driver;
	private EnvProperties env;
	public LoginPage loginPage;
	
	
  @BeforeMethod	
  public void logIn() throws Exception
  {

	  env = new EnvProperties("automation.properties");
	  driver = env.getBrowserType();
	  loginPage = new LoginPage(driver);
	  //Launch the  Website
	  driver.get("https://www.emag.ro/user/login");
	  loginPage.login("bogdansimion87@gmail.com", "Ciohorani187");
	  loginPage.getScreenShot();
  }
  
  
  
  @AfterTest
  public void afterMethod() {

		// Close the driver
		driver.quit();
	}

  
  
 
      
  @AfterSuite
  public void afterSuite() {
	  
	  if(!(driver==null))  afterMethod();
  }
  
  @Test
  public void f() {
  }
}
