package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactPageTest extends TestBase {
	
	ContactsPage contactpage;
	LoginPage  loginpage;
	HomePage homepage;
	
	public ContactPageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	
public  void setup() throws IOException {
		
		initialization();
		
		loginpage = new LoginPage();	
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		contactpage = homepage.ClickOnContactsPage();
		
	}
	
	@Test(priority=1)
	
	public  void ContactPageTextValidation() {
		
	
		Assert.assertTrue(contactpage.validationContactPage());
		
	}
	
	
@AfterMethod
	
	public void tearDown() {
		
		
		driver.quit();
	}

}
