package com.dcrs.utilities;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends BaseTest {
	
	public static WebDriver driver;
	//BaseTest basetest = new BaseTest();
	public static Logger logger;
	
	
	public BasePage() {
		driver = BaseTest.driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	
	
	
}
