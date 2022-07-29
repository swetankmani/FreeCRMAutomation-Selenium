package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory = OR 
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement Loginlnk;

	@FindBy(xpath="//input[@name='email']")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement LoginBtn;

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement SignupBtn;

	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	WebElement Frgtpwd;

	//initialising the page objects

	public LoginPage() throws IOException {
		super();

		PageFactory.initElements(driver, this);

	}

	//Actions

	public passwordResetPage validateForgetYourPasswordLink() throws IOException {
		Loginlnk.click();
		Frgtpwd.click();
		return new passwordResetPage();
	}


	public String  validateLoginPageTitle() {

		return driver.getTitle();
	}


	public HomePage login(String un,String pwd) throws IOException {

		Loginlnk.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		LoginBtn.click();
		return new  HomePage();
	}

}
