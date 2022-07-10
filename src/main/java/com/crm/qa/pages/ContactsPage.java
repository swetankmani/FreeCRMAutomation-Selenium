package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	
	
	@FindBy(xpath = "//div[contains(@class,'ui header item mb5 light-black')]")
	WebElement ContactText;
	
	
	//Driver initialization

	public ContactsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean validationContactPage() {
		
	return	ContactText.isDisplayed();
		
	}
	
@AfterMethod
	
	public void tearDown() {
		
		
		driver.quit();
	}


}
