package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CalenderPage extends TestBase {
	
	
	//page  factory
	
	@FindBy(xpath="//button[contains(@class,'ui linkedin button')]")
	WebElement Createbutton;
	
	@FindBy(xpath="//div[contains(@class,'ui header item mb5 light-black')]")
	WebElement pageheader;
	
	
	//initialization ofpage factory
	
	public CalenderPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public CalenderPage  ValidateClickBtn() throws IOException {
		
		
		 Createbutton.click();
		 return new CalenderPage();
		
	}
	
	public String ValidatePageText() {
		
		return pageheader.getText();
		
		
		
	}

}
