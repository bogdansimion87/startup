package org.learning.startup.emag;

import org.openqa.selenium.By;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.learning.startup.emag.EnvProperties;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.setDriver(driver);
        
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void submitEmail(String emailAddress) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
		element.sendKeys(emailAddress);
		 
		//driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailAddress);
		 //Thread.sleep(2000);
		 

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

	public void login(String emailAddress, String password) throws InterruptedException {
		submitEmail(emailAddress);
		submitPassword(password);
	}

	public WebElement getMyAccountLabel() {
		return driver.findElement(By.xpath("//span[@class='emg-fluid-text-content']"));
	}

	public String getLogginErrorLabel() {
		return driver.findElement(By.xpath("//div[@class='gui-form-control -wide -error']/span")).getText();
	}
	
	//public String takeScreenshot(String Path) {
	//	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//}
	public void getScreenShot() throws Exception 
	  {
	          File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	          //The below method will save the screen shot in d drive with name "screenshot.png"
	          FileUtils.copyFile(scrFile, new File("C:\\Users\\P3700645\\"+this.getClass().getSimpleName()));
	  }
	
}