package pages;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods{
	
	public HomePage(RemoteWebDriver driver,Properties prop) {
		
		this.driver = driver;
		this.prop = prop;
	}
	
	
	public LoginPage clickLogout() {
		driver.findElementByXPath(prop.getProperty("HomePage.Logout.Xpath")).click();
		
		return new LoginPage(driver,prop);
	}

}
