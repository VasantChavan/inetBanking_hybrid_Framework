package com.inetBanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {

	WebDriver driver;

	// Object repository for the New Customer Page

	@FindBy(name = "name")
	WebElement txt_newCutomer;

	@FindBy(xpath = "//input[@type='radio' and @value='m']")
	WebElement maleradioBtn;

	@FindBy(xpath = "//input[@type='radio' and @value='f']")
	WebElement femaleRadioBtn;

	@FindBy(name = "dob")
	WebElement txt_dob;

	@FindBy(name = "addr")
	WebElement txt_Address;

	@FindBy(name = "city")
	WebElement txt_City;

	@FindBy(name = "state")
	WebElement txt_State;

	@FindBy(name = "pinno")
	WebElement txt_Pin;

	@FindBy(name = "telephoneno")
	WebElement txt_Mobile;

	@FindBy(name = "emailid")
	WebElement txt_Email;

	@FindBy(name = "password")
	WebElement txt_Password;

	@FindBy(name = "sub")
	WebElement submitBtn;
	
	


	public NewCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String verifyNewCustomerPage() {

		return driver.getTitle();
	}

	public void setCutomerName(String customername) {
		txt_newCutomer.clear();
		txt_newCutomer.sendKeys(customername);

	}

	public void selectGender(String gender) {

		if (gender.equals("Male")) {
			maleradioBtn.click();
		} else {
			femaleRadioBtn.click();
		}
	}

	public void setDOB(String dob) {

		// 22-04-2022
		String[] date = dob.split("-");
		String day = date[0];
		String month = date[1];
		String year = date[2];

		txt_dob.sendKeys(day);
		txt_dob.sendKeys(month);
		txt_dob.sendKeys(year);

	}

	public void setAddress(String address) {
		txt_Address.clear();
		txt_Address.sendKeys(address);
	}

	public void setCity(String city) {
		txt_City.clear();
		txt_City.sendKeys(city);
	}

	public void setState(String state) {
		txt_State.clear();
		txt_State.sendKeys(state);
	}

	public void setPIN(String pin) {
		txt_Pin.clear();
		txt_Pin.sendKeys(pin);
	}

	public void setMobile(String mobile) {
		txt_Mobile.clear();
		txt_Mobile.sendKeys(mobile);
	}

	public void setEmail(String email) {
		txt_Email.clear();
		txt_Email.sendKeys(email);
	}

	public void setPassword(String pass) {
		txt_Password.clear();
		txt_Password.sendKeys(pass);
	}

	public void clickOnSubmit() {
		
		try {
			Thread.sleep(2000);
			submitBtn.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
