package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.ExcelRead;
import com.crm.qa.util.Excelutil;
import com.crm.qa.util.TestUtil;

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
	
	
	@Test(priority=2)
	
	public  void ContactPageNewValidation() throws IOException {

	//	ExcelRead.getRowCount();
		
		contactpage.ValidateAddPage("swetank","Mani");

		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("contact_new_url"));
	}
	
@AfterMethod
	
	public void tearDown() {
		
		
		driver.quit();
	}

}
