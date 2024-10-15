package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class LoginAndLogout extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setFileName() {
		excelFileName = "Login";

	}
	
	

	@Test(dataProvider = "fetchData")
	public void loginLogout(String username,String password) throws InterruptedException {

	//	LoginPage lp = new LoginPage();

		new LoginPage(driver,prop)
		.enterUserName(username)
		.enterPassword(password)
		.clickLoginButton()
		.clickLogout();

	}

}
