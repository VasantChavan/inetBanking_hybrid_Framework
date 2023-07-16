package com.inetBanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditCustomerPage {

	WebDriver driver;
	
	@FindBy(name="XYZ")
	WebElement cutomerDetails;

	public EditCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
		
	
	public void editCustomerDetails()
	{
		
	}
}
