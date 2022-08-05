package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	//page factory
	
	@FindBy(xpath = "//div[contains(@class,'ui header item mb5 light-black')]")
	WebElement ContactText;
	@FindBy(css="button.ui.linkedin.button>i.edit.icon")
	WebElement cntctcreateBtn;
	@FindBy(css="div.ui.header.item.mb5.light-black")
	WebElement newcntctheader;
	@FindBy(name="first_name")
	WebElement frstname;
	@FindBy(name="last_name")
	WebElement lstname;
	@FindBy(css="button.ui.linkedin.button")
	WebElement svbtn;
	@FindBy(css="div.ui.selection.upward.dropdown")
	WebElement statusdrpdwn;
	
	//Driver initialization

	public ContactsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	//Action
	
	public boolean validationContactPage() {
		
	return	ContactText.isDisplayed();
		
	}
	
	public ContactsPage ValidateAddPage(String fstnm,String lstnm) throws IOException {
		
		cntctcreateBtn.click();
		frstname.sendKeys(fstnm);
		lstname.sendKeys(lstnm);
	//	Select s= new  Select(driver.findElement(By.xpath("//*[@name='status']/div[@class='divider default text']")));	
	//	s.selectByValue("New");
		svbtn.click();
		return new ContactsPage();
		
	}
	

}
