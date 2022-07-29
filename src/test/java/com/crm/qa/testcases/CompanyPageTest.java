package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CompanyPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.ScreenshotUtil;

public class CompanyPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	CompanyPage companypage;

	public CompanyPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@BeforeMethod
	
	public void setup() throws IOException {
		
		initialization();
		loginpage = new LoginPage();	
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		companypage=homepage.ClickOnCompaniesPage();
	}
	
	
	@Test
	
	public  void CompanyPageTitleValidation() {
		
		System.out.println(companypage.validateCompanyPageTitle());
		Assert.assertEquals(companypage.validateCompanyPageTitle(),"Cogmento CRM");
	}
	
	@Test
	public  void CompanyPageURLValidation() {
		
		System.out.println(companypage.validateCompanyPageURL());
		Assert.assertEquals(companypage.validateCompanyPageURL(),"https://ui.freecrm.com/companies");
		
	}
	
	
	
	
	
@AfterMethod
	
	public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus()) {
			ScreenshotUtil.captureScreenshot(driver, result.getName());	
		}
		
		driver.quit();
	}
	

	
	

}
