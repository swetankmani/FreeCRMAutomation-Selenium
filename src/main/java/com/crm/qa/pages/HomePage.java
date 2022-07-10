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
		System.out.println("Contact page  object:- " +new ContactsPage());
		return new ContactsPage();
		
		
	}  
	

}
