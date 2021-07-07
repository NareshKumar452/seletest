package com.dcrs.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configurations/config.properties");
		
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e.getMessage() );
		}
		
	}
	
	
	
	public String getApplicatioURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	
	public String getUsername()
	{
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getInvalidUser()
	{
		String invalidUser = pro.getProperty("invaidusername");
		return invalidUser;
	}
	
	public String getCustomerName() {
		String customername = pro.getProperty("customername");
		return customername;
	}
	
	public String getProjectName() {
		String projectname = pro.getProperty("projectname");
		return projectname;
	}
	
	public String getTimeTrackTaskName() {
		String timetracktaskname = pro.getProperty("timetracktaskname");
		return timetracktaskname;
	}
	
	public String getCreateNewTaskPageText() {
		String createNewTaskPageText = pro.getProperty("CreateNewTaskPageText");
		return createNewTaskPageText;
	}
}
