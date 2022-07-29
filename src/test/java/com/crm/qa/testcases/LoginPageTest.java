package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.commons.mail.EmailException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.ScreenshotUtil;
import com.crm.qa.util.SendsimpleTextEmail;

public class LoginPageTest extends  TestBase {
	
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void  SetUp() throws IOException {
		
		initialization();
		loginpage = new LoginPage();
		
	}
	
	@Test(priority = 1)
	
	public void loginPageTitleTest() {
	String title = 	loginpage.validateLoginPageTitle();
	Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, marketing campaigns and support.");
	}
	
	@Test(priority = 2)
	
	public  void loginTest() throws IOException {
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@AfterMethod
	
	public void tearDown(ITestResult result) throws EmailException {
		if(ITestResult.FAILURE==result.getStatus()) {
			ScreenshotUtil.captureScreenshot(driver, result.getName());	
			//SendsimpleTextEmail.sendEmail();
		}
		
		driver.quit();
	}
	

}
