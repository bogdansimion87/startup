package org.learning.startup.emag;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageWithPageFactory {
	private WebDriver driver = null;

	public LoginPageWithPageFactory(WebDriver driver) {
		this.setDriver(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='email']")                                         WebElement txtbx_Password;
	@FindBy(how = How.XPATH, using = "//button[@class='gui-btn auth-btn-primary auth-submit']")      WebElement Password_submit_button;	
	
	public void submitEmail(String emailAddress) throws InterruptedException {
		txtbx_Password.sendKeys(emailAddress);
		Thread.sleep(2000);

		Password_submit_button.click();
		Thread.sleep(2000);
	}
	
	
	
	
	@FindBy(how = How.ID, using = "password")                                                        WebElement password_lInput;
	@FindBy(how = How.XPATH, using = "//button[@class='gui-btn auth-btn-primary auth-submit']")      WebElement Login_button;
	
	public void submitPassword(String password) throws InterruptedException {
				password_lInput.sendKeys(password);

		        // Wait for 2 Sec
		        Thread.sleep(2000);
		     

		        Login_button.click();

		        // Wait for 2 Sec
		        Thread.sleep(2000);
	}
	
		
	
	
	@FindBy(how = How.XPATH, using = "//span[@class='emg-fluid-text-content']")                        WebElement Account_Label;
	
	public WebElement getMyAccountLabel()
	{
		 return Account_Label;
	}

	
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='gui-form-control -wide -error']/span")             WebElement Loggin_Error_Label;
	
	public String getLogginErrorLabel() {	
		return Loggin_Error_Label.getText();
	}
	
	
	public void login(String emailAddress, String password) throws InterruptedException
	{
		submitEmail(emailAddress);
		submitPassword(password);
	}
	
}
