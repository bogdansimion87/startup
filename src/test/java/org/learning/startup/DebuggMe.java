package org.learning.startup;
import org.learning.startup.emag.LoginPage;
import org.openqa.selenium.WebDriver;
import org.learning.startup.emag.EnvProperties;

public class DebuggMe {
	
	public WebDriver driver;
	
	LoginPage Page = new LoginPage(driver);
	
	public static void main(String[] args) {
		//kkjh
		
		    EnvProperties envPropertiesObject;
		    envPropertiesObject = new EnvProperties("C://Users//P3700645//Documents//GitHub//startup//src//main//resources//automation.properties");
		    
		    envPropertiesObject.getValueOfPropertyValue("browser");
		}
		

}
