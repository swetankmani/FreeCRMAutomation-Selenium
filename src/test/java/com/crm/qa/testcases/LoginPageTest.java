package com.crm.qa.testcases;

import java.awt.List;
import java.io.IOException;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.WebElement;
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
	java.util.List<WebElement> lgnpglnk;

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
	@Test(priority = 3)
	public void validateLoginPageLink() {
		
	int lnk =loginpage.validateLoginPageLinks();
	Assert.assertEquals(lnk, 3);
	}
	
	@Test(priority = 4)
	public void validateLoginPageLinkText() {
		
		lgnpglnk =  loginpage.validateLoginPageLinksText();
		 Assert.assertEquals(lgnpglnk.get(0).getText(),prop.getProperty("forget_page_link1"));
		 Assert.assertEquals(lgnpglnk.get(1).getText(),prop.getProperty("forget_page_link2"));
		 Assert.assertEquals(lgnpglnk.get(2).getText(),prop.getProperty("forget_page_link3"));
		
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
