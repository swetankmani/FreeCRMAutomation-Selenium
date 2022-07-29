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
import com.crm.qa.pages.passwordResetPage;
import com.crm.qa.util.ScreenshotUtil;

public class passwordResetPageTest extends TestBase {


	passwordResetPage pwdrst;

	public passwordResetPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub

	}

	@BeforeMethod
	public void setup() throws IOException {

		initialization();
		pwdrst = new passwordResetPage();

	}

	@Test(priority=1)
	public void validateForgetPageCurrentURL() throws IOException {
		pwdrst = pwdrst.forgetPasswordPageLaunch();
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("forget_pwd_link"));
	}

	@Test(priority = 2)

	public void  validateForgetPageHeader() throws IOException {

		pwdrst.forgetPasswordPageLaunch();
		String  x =	pwdrst.forgetPasswordPageHeader();
		Assert.assertEquals(x, "Forgot my password");
	}
	
	@Test(priority =3)
	
public void  validateForgetPageEmailadress() throws IOException {
		
		pwdrst.forgetPasswordPageLaunch();
		pwdrst.enterPasswordPageEmail(prop.getProperty("username"));
	

	}


	@AfterMethod

	public void tearDown(ITestResult result) throws EmailException {
		if(ITestResult.FAILURE==result.getStatus()) {
			ScreenshotUtil.captureScreenshot(driver, result.getName());	
		}

		driver.quit();
	}


}
