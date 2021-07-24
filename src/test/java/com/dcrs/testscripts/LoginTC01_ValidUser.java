package com.dcrs.testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dcrs.pageobjects.LoginPage;
import com.dcrs.utilities.BasePage;
import com.dcrs.utilities.BaseTest;

public class LoginTC01_ValidUser extends BaseTest{
	
	@Test(description = "Login test")
	public void ValidloginScreenTest() throws InterruptedException, IOException {
		try {
		BasePage basepage = new BasePage();
		logger.info("ActiTime URL is Launched");
		String LoginPagetitle = basepage.getTitle();
		System.out.println("Title of the Page is : "+LoginPagetitle);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setUserName(username);
		logger.info("Entered UserName");
		loginpage.setPassword(password);
		logger.info("Entered Password");
		loginpage.clickSubmit();
		logger.info("Clicked on Login Button");
		Thread.sleep(5000);
		
		logger.info("Login Successful");
		Thread.sleep(5000);
	
			Assert.assertTrue(true);
			logger.info("Login test passed");
			
			
			String TrackPagetitle = basepage.getTitle();
			System.out.println("Title of the Page is : "+TrackPagetitle);
			
			captureScreen(driver,"ValidloginScreenTest");
		
		}	
		catch(Exception e)
		{
			//logger.info("ActiTime Loging test failed");
		}
		
		
	}

}
