package com.inetBanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// Login Page Repository

	WebDriver driver;

	@FindBy(name = "uid")
	WebElement txt_Username;

	@FindBy(name = "password")
	WebElement txt_Password;

	@FindBy(name = "btnLogin")
	WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String username) {
		txt_Username.clear();
		txt_Username.sendKeys(username);
	}

	public void setPassword(String passwrd) {
		txt_Password.clear();
		txt_Password.sendKeys(passwrd);

	}

	public HomePage clickOnLoginBtn() {
		loginBtn.click();
		return new HomePage(driver);
	}

}
