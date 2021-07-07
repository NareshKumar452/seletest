package com.dcrs.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.dcrs.pageobjects.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Logger logger;
	
	ReadConfig readconfig = new ReadConfig();
	public String baseURL 	=	readconfig.getApplicatioURL();
	public String username 	= 	readconfig.getUsername();
	public String invalidUser 	= 	readconfig.getInvalidUser();
	public String password 	= 	readconfig.getPassword();
	public String customername = readconfig.getCustomerName();
	public String projectname = readconfig.getProjectName();
	public String timetracktaskname = readconfig.getTimeTrackTaskName();
	
	
	public BaseTest() {
		
		logger = Logger.getLogger("seletest");
		PropertyConfigurator.configure("Log4j.properties");
		
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void OpenBrowser(String br) {
		
		if(br.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("no browser is defined in XML file");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(baseURL);
		
	
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	public void LoginToApplication(String username,String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(username);
		loginPage.setPassword(password);
		loginPage.clickSubmit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File Target = new File(".//Screenshots//"+ tname + ".png");
	FileUtils.copyFile(src, Target);
	System.out.println("Screenshot of " +tname +" is taken");
	
	}
	
	
	

}
