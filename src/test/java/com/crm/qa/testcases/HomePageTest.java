package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalenderPage;
import com.crm.qa.pages.CompanyPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	CalenderPage calenderpage;
	CompanyPage CompaniesPage;
	
	public HomePageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	
	public  void setup() throws IOException {
		
		initialization();
		
		loginpage = new LoginPage();	
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	
	public  void HomePageTitleTest() throws IOException {
		
		
		Assert.assertEquals (homepage.validateHomePageTitle(),"Cogmento CRM");
		
	}
	
	@Test(priority=2)
	
	public void HomePageTextValidation() throws IOException {
		
		Assert.assertEquals(homepage.validateHomePageText(), "Contacts activity stream");
	}
	
	@Test(priority=3)
	
	public void HomePageLinkCountValidation() {
		
		Assert.assertEquals(homepage.validateHomePageLinks(), 28);
	}
	
	@Test(priority=4)
	
	public void HomePageLogoValidation() {
		
	
		Assert.assertTrue(homepage.validateHomePageLogo());
		
	}
	
	@Test(priority=5)
	
	public void validateClicksonContactPage() throws IOException {
		
		contactpage= homepage.ClickOnContactsPage();
		System.out.println("Contact Page Current URL- " + driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("contact_url"));
	
	}
	
	@Test(priority=6)
	
	public void validateCalanderPagelink() throws IOException {
		
		calenderpage = homepage.ClickOnCalenderPage();
		System.out.println("Calender Page Current URL- " + driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("calender_url"));

	}
	
	@Test(priority = 7)
	
	public  void  validateCompaniesPageLink() throws IOException {
		
		CompaniesPage = homepage.ClickOnCompaniesPage();
		System.out.println("Calender Page Current URL- " + driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("companies_url"));
		
		
		
		
	}
	
@AfterMethod
	
	public void tearDown() {
		
		
		driver.quit();
	}
	
}
