package com.dcrs.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.dcrs.pageobjects.LoginPage;
import com.dcrs.utilities.BaseTest;

public class LoginTC02_invalidUser extends BaseTest{
	
	
	@Test
	public void loginWithInvalidUser() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setInvalidUser(invalidUser);
		logger.info("Entered InvalidUser Name");
		loginpage.setPassword(password);
		logger.info("Entered the password");
		loginpage.clickSubmit();
		logger.info("Clicked on Login Button");
		loginpage.setInvalidUserORpassword();
		logger.info("Entered invalid credentials");
		
		captureScreen(driver, "loginWithInvalidUser");
		
		
	}
	
	
	

}
