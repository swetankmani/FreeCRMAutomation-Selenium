package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CompanyPage extends TestBase {
	
	//page factory
	
	@FindBy(xpath= "//div[contains(@class,'ui header item mb5 light-black')]")
	WebElement CompanyText;
	
	
	//initialization of page factory
	
	public CompanyPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	//Actions
	
	public String validateCompanyPageTitle() {
		
		 return driver.getTitle();
	}
	
	public  String validateCompanyPageURL() {
		
		return driver.getCurrentUrl();
		
	}
	
	
	
}
