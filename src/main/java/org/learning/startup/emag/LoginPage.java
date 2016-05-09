package org.learning.startup.emag;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.setDriver(driver);
		
		// Create a new instance of the Firefox driver
	    driver = new FirefoxDriver();
	    
	    //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception	 
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Launch the  Website
	    driver.get("https://www.emag.ro/user/login");
	
	}

	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void submitEmail(String emailAddress) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailAddress);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@class='gui-btn auth-btn-primary auth-submit']")).click();
		Thread.sleep(2000);
	}

	public void submitPassword(String password) throws InterruptedException {
		WebElement passwordlInput = driver.findElement(By.id("password"));

		passwordlInput.sendKeys(password);

		// Wait for 2 Sec
		Thread.sleep(2000);

		WebElement Login = driver.findElement(By.xpath("//button[@class='gui-btn auth-btn-primary auth-submit']"));

		Login.click();

		// Wait for 2 Sec
		Thread.sleep(2000);
	}
	
	public void login(String emailAddress, String password) throws InterruptedException
	{
		submitEmail(emailAddress);
		submitPassword(password);
	}
	
	public WebElement getMyAccountLabel()
	{
		 return driver.findElement(By.xpath("//span[@class='emg-fluid-text-content']"));
	}

	public String getLogginErrorLabel() {	
		return driver.findElement(By.xpath("//div[@class='gui-form-control -wide -error']/span")).getText();
	}
}
