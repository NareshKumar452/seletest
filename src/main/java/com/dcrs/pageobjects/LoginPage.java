package com.dcrs.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dcrs.utilities.BasePage;

public class LoginPage extends BasePage{
	
		public LoginPage(WebDriver driver) {
		super();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@FindBy(name="username")
	WebElement textUserName;
	
	@FindBy(name="pwd")
	WebElement textPassword;
	
	@FindBy(id="loginButton")
	WebElement LoginButton;
	
	@FindBy(xpath = "//span[contains(text(),'Username or Password is invalid. Please try again.')]")
	WebElement ErrorMessageInvalidUserORpassword;
	
	public void setUserName(String username)
	{
		textUserName.sendKeys(username);
	}
	
	public void setInvalidUser(String invalidUser)
	{
		textUserName.sendKeys(invalidUser);
	}
	
	public void setPassword(String password)
	{
		textPassword.sendKeys(password);
	}
	
	public TimeTrackPage clickSubmit()
	{
		try {
		LoginButton.click();
		}
		catch(Exception e) {
			
		}
		return new TimeTrackPage(driver);
	}
	
	public void setInvalidUserORpassword() {
		String errormessage = ErrorMessageInvalidUserORpassword.getText();
		System.out.println(errormessage);
	}
	

}
