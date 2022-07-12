package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalenderPage;
import com.crm.qa.pages.CallsPage;
import com.crm.qa.pages.CampaignsPage;
import com.crm.qa.pages.CasesPage;
import com.crm.qa.pages.CompanyPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.DocumentsPage;
import com.crm.qa.pages.EmailPage;
import com.crm.qa.pages.FormsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	CalenderPage calenderpage;
	CompanyPage CompaniesPage;
	DealsPage dealpage;
	TasksPage taskpage;
	CasesPage casepage;
	CallsPage callspage;
	DocumentsPage documentpage;
	EmailPage emailpage;
	CampaignsPage campaignspage;
	FormsPage formspage;
	
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
	
	@Test(priority=8)
	
	public void validateDealsPagelink() throws IOException {
		
		dealpage = homepage.ClickOnDealPage();
		System.out.println("Deal Page Current URL:- " + driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("dealpage_url"));
	} 
	
	@Test(priority = 9)
	
	public void  validateTasksPageLink() throws IOException {
		
		
		taskpage = homepage.ClickOnTasksPage();
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("taskpage_url"));
		
	}
	
	@Test(priority=10)
	
	public void  validateCasesPageLink() {
		
		casepage = homepage.ClickOnCasesPage();
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("casespage_url"));
		
	}
	
	@Test(priority=11)
	
	public void  validateCallsPageLink() {
		
		callspage = homepage.ClickOnCallsPage();
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("callspage_url"));
	}
	
	@Test(priority=12)
	
	public  void validateDocumentsPageLink() {
		
		documentpage = homepage.ClickOnDocumentPage();
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("documentspage_url"));
		
	}
	
	@Test(priority=13)
	
	public void validateEmailPageLink() {
		
		emailpage = homepage.ClickOnEmailPage();
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("emailpage_url"));	
	}
	
	@Test(priority=14)
	
	public void validateCampaignsPageLink() {
		
		campaignspage = homepage.ClickOnCampaignsPage();
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("campaignpage_url"));
		
	}
	
	@Test(priority=15)
	
public void validateFormPageLink() {
		
		formspage = homepage.ClickOnFormsPage();
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("formspage_url"));
		
	}
	
	
@AfterMethod
	
	public void tearDown() {
		
		driver.quit();
	}
	
}
