package org.learning.startup.emag;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EnvProperties {

	public WebDriver driver;
	public String propertiesFileName;
	public String keyValue;

	Properties prop = new Properties();

	public EnvProperties(String propertiesFileName) {

		InputStream fileInput = null;

		fileInput = ClassLoader.getSystemClassLoader().getResourceAsStream(propertiesFileName);

		// load properties file
		try {

			prop.load(fileInput);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void setValueOfpropertiesPath(String propertiesFileName) {
		this.propertiesFileName = propertiesFileName;
	}

	public void setValueOfPropertieKey(String keyValue) {
		this.keyValue = keyValue;
	}

	public String getValueOfPropertyValue(String keyValue) {
		return prop.getProperty(keyValue);
	}

	// public RemoteWebDriver getBrowser()
	// {
	// switch (getValueOf("browser"))
	// case
	//
	// }

	public WebDriver getBrowserType() {
		// Select browser driver
		switch (getValueOfPropertyValue("browser")) {

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "chrome":
			driver = new ChromeDriver();
			//

			break;

		default:
			;
			break;

		}

		return driver;
	}

}
