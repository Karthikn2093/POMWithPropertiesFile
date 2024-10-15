package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class LoginWithInvalidData extends ProjectSpecificMethods{

	@Test
	public void loginwithInvalidData() throws InterruptedException {

	//	LoginPage lp = new LoginPage();

		new LoginPage(driver,prop)
		.enterUserName("demo123")
		.enterPassword("crmsfa")
		.clickLoginForInvalidData()
		.verifyErrorMessage();

	}

}
