package com.crm.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	
	//page factory
	
	@FindBy(xpath="//div[contains(text(),'Contacts activity stream')]")
	WebElement HomepageText;
	
	@FindBy(tagName="a")
	List <WebElement> HomepageLink;
	
	@FindBy(xpath= "//div[contains(@class,'header item')]")
	WebElement HomePageLogo;
	
		
	@FindBy(xpath = "//span[contains(text(),'Contacts')]\r\n")
	WebElement  ContactPageLink;
	
	@FindBy(xpath = "//span[contains(text(),'Calendar')]")
	WebElement CalendarPageLink;
	
	@FindBy(xpath = "//span[contains(text(),'Companies')]")
	WebElement CompaniesPageLink;
	
	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement DealsPageLink;
	
	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement TasksPageLink;
	
	@FindBy(xpath = "//i[@class='comments icon']")
	WebElement CasesPageLink;
	
	@FindBy(xpath = "//span[contains(text(),'Calls')]")
	WebElement 	CallsPageLink;
	
	@FindBy(xpath = "//span[contains(text(),'Documents')]")
	WebElement 	DocumentsPageLink;
	
	@FindBy(xpath = "//span[contains(text(),'Email')]")
	WebElement 	EmailPageLink;
	
	@FindBy(xpath = "//span[contains(text(),'Campaigns')]")
	WebElement 	CampaignsPageLink;
	
	@FindBy(xpath = "//span[contains(text(),'Forms')]")
	WebElement 	FormsPageLink;
	
	
	//Initialization of page factory 
	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	//Actions
	
	public String validateHomePageTitle() {
		
		return driver.getTitle();
	}
	
	public String validateHomePageText() {
		
		 return  HomepageText.getText();
		 
	} 
	
	public  boolean  validateHomePageLogo() {
		
		boolean b = HomePageLogo.isDisplayed();
		return b;
	}
	
	
	public  int validateHomePageLinks() {
		
	if(HomePageLogo.isDisplayed() == true) {
		for(int i = 0 ; i<HomepageLink.size();i++) {
			
			 System.out.println(HomepageLink.get(i).getText());
			 
		}
		
		
	} else {
		
		System.out.println("User is not at HomePage");
		
		}
	return HomepageLink.size();
	}
	
	public ContactsPage  ClickOnContactsPage() throws IOException {
		
		ContactPageLink.click();
		return new ContactsPage();
		
		
	}  
	
	public CalenderPage ClickOnCalenderPage() throws IOException {
		
		CalendarPageLink.click();
		return new CalenderPage();
		
	}
	
public CompanyPage ClickOnCompaniesPage() throws IOException {
		
		CompaniesPageLink.click();
		return new CompanyPage();
		
	}
	

}
