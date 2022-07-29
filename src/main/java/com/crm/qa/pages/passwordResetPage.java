package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class passwordResetPage extends TestBase {

	LoginPage login;
	passwordResetPage pwdreset;

	//page factory

	@FindBy(xpath="//h2[contains(text(),'Forgot my password')]")
	WebElement pgheader;
	@FindBy(css="#email")
	WebElement emailadrss;
	//Initialization of Driver
	public passwordResetPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		login = new LoginPage();
	}

	//Actions

	public passwordResetPage forgetPasswordPageLaunch() throws IOException {

		login.validateForgetYourPasswordLink();
		return new passwordResetPage();
	}

	public String forgetPasswordPageHeader() {

		String str = pgheader.getText();
		System.out.println(str);
		return str;
	}

	public  void enterPasswordPageEmail(String email) {

		emailadrss.sendKeys(email);

	}

}
