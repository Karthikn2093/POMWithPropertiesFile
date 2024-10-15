package pages;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {
	
	
	public LoginPage(RemoteWebDriver driver,Properties prop) {
		
		this.driver = driver;
		this.prop = prop;
		
	}
	

	// actionElementName
	public LoginPage enterUserName(String username) throws InterruptedException {

		driver.findElementById(prop.getProperty("LoginPage.Username.Id")).sendKeys(username);
		return this;
	}

	public LoginPage enterPassword(String password) {
		driver.findElementById(prop.getProperty("LoginPage.Password.Id")).sendKeys(password);

		return this;
	}

	public HomePage clickLoginButton() {

		driver.findElementByClassName(prop.getProperty("LoginPage.Login.Classname")).click();

		return new HomePage(driver,prop);
	}

	public LoginPage clickLoginForInvalidData() {

		driver.findElementByClassName(prop.getProperty("LoginPage.Login.Classname")).click();

		return this;
	}

	public void verifyErrorMessage() {
		boolean displayed = driver.findElementByXPath(prop.getProperty("LoginPage.Error.Xpath")).isDisplayed();

		if (displayed) {
			System.out.println("Error message is displayed");
		} else {
			System.out.println("Error message is not displayed");
		}

	}

}
