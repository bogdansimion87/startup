package org.learning.startup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SimpleTest {
	
  public WebDriver driver;
  
  
  @Test
  public void testLoggedIn() throws InterruptedException {
	  
	  WebElement emailInput =  driver.findElement(By.xpath("//input[@id='email']"));  
	  
	  emailInput.sendKeys("bogdansimion87@gmail.com");
	  
	  //Wait for 2 Sec
	  Thread.sleep(2000);
	  
	  WebElement continuaLink = driver.findElement(By.xpath("//button[@class='gui-btn auth-btn-primary auth-submit']"));
	  
	  continuaLink.click();
	  
	  //Wait for 2 Sec
	  Thread.sleep(2000);
	  
	  WebElement passwordlInput =  driver.findElement(By.xpath("//input[@id='password']"));
	  
	  passwordlInput.sendKeys("Ciohorani1987");
	  
	  //Wait for 2 Sec
      Thread.sleep(2000);
      
      WebElement Login = driver.findElement(By.xpath("//button[@class='gui-btn auth-btn-primary auth-submit']"));     
		
      Login.click();
      
      
       //Wait for 2 Sec
      Thread.sleep(2000);
      
      //WebElement loggedIn = driver.findElement(By.xpath("//span[@class='emg-fluid-text-content']"));
      
      
  	
	  
  }
  
  @Test
  public void testWrongPasss() throws InterruptedException {  
WebElement emailInput =  driver.findElement(By.xpath("//input[@id='email']"));  
	  
	  emailInput.sendKeys("bogdansimion87@gmail.com");
	  
	  //Wait for 2 Sec
	  Thread.sleep(2000);
	  
	  WebElement continuaLink = driver.findElement(By.xpath("//button[@class='gui-btn auth-btn-primary auth-submit']"));
	  
	  continuaLink.click();
	  
	  //Wait for 2 Sec
	  Thread.sleep(2000);
	  
	  WebElement passwordlInput =  driver.findElement(By.xpath("//input[@id='password']"));
	  

	  
	  passwordlInput.sendKeys("Ciorani1987");
	  
	  //Wait for 2 Sec
      Thread.sleep(2000);
      
      WebElement Login = driver.findElement(By.xpath("//button[@class='gui-btn auth-btn-primary auth-submit']"));     
		
      Login.click();
      
      
      
      boolean present=false;
      WebElement contulMeu;
      
      try {
            contulMeu = driver.findElement(By.xpath("//label[@id='Filedata']"));    
            Assert.assertTrue(contulMeu.isDisplayed());
            present = true;
          } catch (NoSuchElementException e) {
            present = false;
            
          }
      
       System.out.println(present);	
       //Wait for 2 Sec
       Thread.sleep(2000);
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
