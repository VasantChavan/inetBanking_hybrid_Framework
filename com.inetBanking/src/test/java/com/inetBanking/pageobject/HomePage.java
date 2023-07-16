package com.inetBanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(linkText = "New Customer")
	WebElement newCustometLink;

	@FindBy(linkText = "Edit Customer")
	WebElement editCustomerLink;
	
	@FindBy(linkText = "Log out")
	WebElement logoutLink;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		

	public NewCustomerPage clickOnNewCustomerLink() {
		newCustometLink.click();
		return new NewCustomerPage(driver);
	}

	public EditCustomerPage clickOnEditCustomerLink() {
		editCustomerLink.click();
		return new EditCustomerPage(driver);
	}
	
	public void clickOnLogoutLink()
	{
		logoutLink.click();
	}
}
