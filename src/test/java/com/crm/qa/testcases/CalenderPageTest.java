package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalenderPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.ScreenshotUtil;

public class CalenderPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	CalenderPage calenderpage; 
	

	public CalenderPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	
	public void setup() throws IOException {
	
	initialization();
	
	loginpage = new LoginPage();	
	homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	calenderpage = homepage.ClickOnCalenderPage();
	}
	
	@Test
	public void ValidateCalendarButton() throws IOException {
		
		
		calenderpage.ValidateClickBtn();
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("contact_create_url"));
		System.out.println(calenderpage.ValidatePageText());
		
	}
	
	@Test
	
	public void ValidatePageText() {
		
	System.out.println(calenderpage.ValidatePageText());
	Assert.assertEquals(calenderpage.ValidatePageText(), "Calendar");
		
	}
	
	
@AfterMethod
	
	public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus()) {
			ScreenshotUtil.captureScreenshot(driver, result.getName());	
		}
		
		driver.quit();
	}
	

	
	
}
