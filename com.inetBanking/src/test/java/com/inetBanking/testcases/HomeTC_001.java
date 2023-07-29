package com.inetBanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageobject.HomePage;
import com.inetBanking.pageobject.LoginPage;

import com.inetBanking.testbase.TestBase;
import com.inetBanking.utility.Helper;

public class HomeTC_001 extends TestBase {

//	
//	@Test
//	public void navigateToNewCustomerTC_001()
//	{
//		
//		LoginPage login = new LoginPage(driver);
//		String username = excelDataProvider.getStringCellData("Login", 1, 0);
//		String password = excelDataProvider.getStringCellData("Login", 1, 1);
//		//String expTitle = excelDataProvider.getStringCellData("Login", 1, 2);
//
//
//		login.setUserName(username);
//		login.setPassword(password);
//		
//		HomePage homepage = login.clickOnLoginBtn();
//		
//		homepage.clickOnNewCustomerLink();
//		
//		System.out.println(driver.getTitle());
//		
//	}

	@Test
	public void verifyLogoutFunctionality() throws InterruptedException {
		
		extentTest= extentReports.createTest("Login Test");
		LoginPage login = new LoginPage(driver);
		
		extentTest.info("Login Page loaded successfully");

		String username = excelDataProvider.getStringCellData("Login", 1, 0);
		String password = excelDataProvider.getStringCellData("Login", 1, 1);

		login.setUserName(username);
		login.setPassword(password);
		
		extentTest.info("Username and password enterted successfully");
		
	

		HomePage homepage = login.clickOnLoginBtn();
		
		Thread.sleep(3000);
		
		extentTest.pass("Login Sucess");

		homepage.clickOnLogoutLink();
		
		extentTest.info("Logout link shoule be actioned");

		Helper.handleAlertPopUp(driver);
		extentTest.info("Alert shoule be actioned");

		String actTitle = driver.getTitle();
		String expTitle = "Guru99 Bank Home Page";

		if (actTitle.equals(expTitle)) {
			Assert.assertTrue(true);
			//Helper.captureScreenshot(driver);
			//Helper.captureScreenshot(driver, "LoginPage");
			
			extentTest.pass("Logout Sucess");
		} else {
			//Helper.captureScreenshot(driver, "HompePage");
			//Helper.captureScreenshot(driver);
			extentTest.fail("Logout Failed");
			Assert.assertTrue(false);
		}
	}
}
