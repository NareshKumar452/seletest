package com.dcrs.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dcrs.utilities.BasePage;

public class TimeTrackPage extends BasePage {
	
	
	public TimeTrackPage(WebDriver driver) {
		super();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@FindBy (xpath = "//div[contains(text(),'Create New Tasks')]")
	 WebElement creatNetTimeTrackTask ;
	
	@FindBy (xpath = "//span[contains(text(),'New')]")
	WebElement createNewTimeTrackTask;
	
	@FindBy(xpath = "//div[@class='lightBoxTitle'][text()='                Create New Tasks            ']")
	WebElement NewTimeTrackTaskTitle;
	
	@FindBy(xpath ="//div[contains(text(),'Create New Tasks')]")
	WebElement NewTimeTrackTaskTitleText;
	
	@FindBy(xpath = "//div[contains(text(),'Select Customer and Project to Add Tasks for')]")
	WebElement  HeaderOfcreateNewTimeTrackTask;
	
	@FindBy(xpath = "//div[@class='customerSelector customerOrProjectSelector selectorWithPlaceholderContainer']")
	WebElement selectCustomerdropdown;
	
	@FindBy(xpath = "//div[@class='itemRow ' and text()='- New Customer -']")
	WebElement  SelectNewCustomer;
	
	@FindBy(xpath = "//input[@class='newCustomer newCustomerProjectField inputFieldWithPlaceholder']")
	WebElement EnterCustomerName;
	
	@FindBy(xpath ="//input[@class='newProject newCustomerProjectField inputFieldWithPlaceholder']")
	WebElement EnterProjectName;
	
	@FindBy(xpath = "(//input[@placeholder='Enter task name'])[1]")
	WebElement EnterTaskName;
	
	@FindBy(xpath = "//div[text()='Create Tasks']")
	WebElement CreateTaskTImeTrackButtonClick;
	
	@FindBy(xpath = "//div[contains(text(),'Customer already contains a project with the speci')]")
	WebElement duplicateProjectNameMessage;
	
	@FindBy(xpath="//table[@class='createTasksTable hideAddToTT']/tbody/tr[1]//td[4]")
	WebElement btnSetDeadline1;
	
	@FindBy(xpath = "//button[text()='June 2021']")
	static WebElement btnSetDeadlineMonthYearHead;
	
	@FindBy(xpath = "//a[@title='Next Month (Control+Right)']")
	static WebElement btnSetDeadlineMonthYearHeadNext;
	
	//table[@class='x-btn-wrap x-btn ']
	
	public void createNewTimeTrack() {
		createNewTimeTrackTask.click();
	}
	
	public WebElement createNewTimeTrackWebElement() {
		return creatNetTimeTrackTask;
	}
	
	public String newTimeTrackTaskTitle() {
		String NewTimeTrackTitle = NewTimeTrackTaskTitle.getText();
		System.out.println("Create New TimeTrack Task Title is : "+NewTimeTrackTitle);
		return NewTimeTrackTitle;
	}
	
	public String headerOfcreateNewTimeTrackTask() {
		String headerNewTimeTrack = HeaderOfcreateNewTimeTrackTask.getText();
		System.out.println("Header of CreateNewTimeTrackTask is : "+headerNewTimeTrack);
		return headerNewTimeTrack;
	}
	
	public void selectcustomerdropdownClick() {
		selectCustomerdropdown.click();
	}
	
	public void selectNewCustomer() {
		SelectNewCustomer.click();
	}
	
	public void setEnterCustomerName(String customername) {
		EnterCustomerName.sendKeys(customername);
	}
	
	public void setEnterProjectName(String projectname) {
		EnterProjectName.sendKeys(projectname);
	}
	
	public String setEnterTaskName(String timetracktaskname) {
		EnterTaskName.sendKeys(timetracktaskname);
		return timetracktaskname;
	}
	
	public void createTaskTImeTrackButtonClick() {
		CreateTaskTImeTrackButtonClick.click();
	}
	
	public void DuplicateProjectNameMessage() {
		duplicateProjectNameMessage.getText();
		
	}
	
	public boolean SetNewTimeTrackTaskTitleText() {
		return NewTimeTrackTaskTitleText.isDisplayed();
	}
	
	public WebElement BtnSetDeadline1() {
		return btnSetDeadline1;
	}
	
	public WebElement BtnSetDeadlineMonthYearHeadNext() {
		return btnSetDeadlineMonthYearHeadNext;
	}
	
	public static String BtnSetDeadlineMonthYearHead() {
		String monthYearHead =  btnSetDeadlineMonthYearHead.getText();
		return monthYearHead;
	}
	
	public static String[] getMonthYear(String monthYearHead)
	{
		return monthYearHead.split(" ");
	}
	
	
	public static void selectDate(String exDay, String exMonth, String exYear)
	{
		
		if(exMonth.equals("February")  && Integer.parseInt(exDay) > 29) {
			System.out.println("Wrong date : " +exMonth +" " +exDay);
			return;
		}
		
		if(Integer.parseInt(exDay) > 31)
		{
			System.out.println("Wrong date : " +exMonth +" " +exDay);
			return;
		}
		
		String monthYearHead = btnSetDeadlineMonthYearHead.getText();
		while(!(getMonthYear(monthYearHead)[0].equals(""+exMonth+"") 
				&&
				getMonthYear(monthYearHead)[1].equals(""+exYear+"")))
		{
			btnSetDeadlineMonthYearHeadNext.click(); //next button
			//driver.findElement(By.xpath("//span[contains(text(),'Prev')]")).click(); //previous button
			monthYearHead = btnSetDeadlineMonthYearHeadNext.getText();
		}
			
		try {
		driver.findElement(By.xpath("//a[text()='"+exDay+"']")).click();
		System.out.println(exDay +"th " +monthYearHead);
		}
		catch(Exception e) {
		System.out.println("Wrong date : " +exMonth +" " +exDay);
		return;
			
		}
	
	}

}
