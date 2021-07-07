package com.dcrs.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dcrs.pageobjects.LoginPage;
import com.dcrs.pageobjects.TimeTrackPage;
import com.dcrs.utilities.BaseTest;

public class TimeTrackTest_TC01_createNewTask extends BaseTest {
	
	
	@Test
	public void createNewTimeTrackTask() throws InterruptedException, IOException {
		LoginToApplication(username,password);
		logger.info("Login Successful");
		
		
		TimeTrackPage timetrackpage = new TimeTrackPage(driver);
		timetrackpage.getTitle();
		timetrackpage.createNewTimeTrack();
		Thread.sleep(5000);
		logger.info("In create timetrack task screen");
		timetrackpage.newTimeTrackTaskTitle();
		logger.info("captured the timetrack Title");
		timetrackpage.selectcustomerdropdownClick();
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
//		
//		List<WebElement> custoersList = driver.findElements(By.xpath("(//div[@class='scrollableContainer '])"));
//		int count = custoersList.size();
//		
//		for(WebElement listofcus:custoersList) {
//			String text = listofcus.getText();
//			if(text.equals("Aruna")) {
//			listofcus.click();
//		}
//		}
//		
		timetrackpage.selectNewCustomer();
		logger.info("Selected new customer");
		timetrackpage.setEnterCustomerName(customername);
		logger.info("Entered customer name");
		timetrackpage.setEnterProjectName(projectname);
		logger.info("Entered project name");
		timetrackpage.setEnterTaskName(timetracktaskname);
		logger.info("Enter Task Name");
		timetrackpage.BtnSetDeadline1().click();
		logger.info("clicked on deadline1 calender");
		timetrackpage.BtnSetDeadlineMonthYearHead();
		logger.info("Got the Month year Head");
		
		timetrackpage.getMonthYear(timetrackpage.BtnSetDeadlineMonthYearHead());
		logger.info("Split of month and year is done");
		
		timetrackpage.selectDate("30","March","2022");;
		//String taskNameis = driver.findElement(By.xpath("(//input[@class='inputFieldWithPlaceholder'])[1]")).getText();
		//System.out.println(taskNameis);
		captureScreen(driver, "createNewTimeTrackTask");
		timetrackpage.createTaskTImeTrackButtonClick();
		Thread.sleep(2000);
		try {
			if(timetrackpage.createNewTimeTrackWebElement().isDisplayed()) {
		//Assert.assertTrue(createnew).isDisplayed());
		logger.info("Task Creation is unsuccesful");
		}}
		//if(timetrackpage.getTitle().equalsIgnoreCase("actiTIME -  Enter Time-Track")){
			//WebElement createdTask = driver.findElement(By.xpath("//div[text()='"+taskNameis+"']"));
			//String createdTaskText = createdTask.getText();
				//if(createdTaskText.equalsIgnoreCase(taskNameis)) {
					//System.out.println("Newly Created Task is : "+createdTaskText);
			catch(Exception e)	
		{
				Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Add Tasks from the List')]")).isDisplayed());
				logger.info("New TimeTrack Task Created succesfully");	
		}
				}	
			//}
		
//		else if(timetrackpage.newTimeTrackTaskTitle().equalsIgnoreCase("Create New Tasks")) {
//			System.out.println("Task creation is UnSuccessful");
//			captureScreen(driver, "createNewTimeTrackTask");
//			}
//			
//		else {
//			System.out.println("Creation Error, please check once");
//		}
//		
		
		
		
		}
			
		
	
	


