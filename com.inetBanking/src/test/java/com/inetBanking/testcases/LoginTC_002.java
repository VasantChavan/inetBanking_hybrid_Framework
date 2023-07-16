package com.inetBanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageobject.LoginPage;
import com.inetBanking.testbase.TestBase;
import com.inetBanking.utility.Helper;

public class LoginTC_002 extends TestBase{

	

	@Test
	public void verifyLoginFunctionalityTC_001() {

		LoginPage login = new LoginPage(driver);
		login.setUserName(configDataProvider.getUserName());
		login.setPassword(configDataProvider.getPassword());

		login.clickOnLoginBtn();
		
		Helper.handleAlertPopUp(driver);

		String expTitle = "Guru99 Bank Manager HomePage";
		String actTitle = driver.getTitle();
		
		if (expTitle.equals(actTitle)) {
			Assert.assertTrue(true);
			//Helper.captureScreenshot(driver, "HompePage");
			Helper.captureScreenshot(driver);
		} else {
			//Helper.captureScreenshot(driver, "LoginPage");
			Helper.captureScreenshot(driver);
			Assert.assertTrue(false);
			
		}
		
		//Assert.assertEquals(actTitle, expTitle,"actual browser title doesn't matched with expected title");

		
	}
}
