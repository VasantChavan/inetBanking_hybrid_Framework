package com.inetBanking.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageobject.LoginPage;
import com.inetBanking.testbase.TestBase;

public class LoginTC_001 extends TestBase {

//	@Test
//	public void verifyLoginPageTitleTC_001() {
//		
//		String expTitle = "Guru99 Bank Home Page";
//		String actTitle = driver.getTitle();
//
//		System.out.println(actTitle);
//		if (expTitle.equals(actTitle)) {
//			Assert.assertTrue(true);
//		} else {
//			Assert.assertTrue(false);
//		}
//
//	}

	@Test
	public void verifyLoginFunctionalityTC_002() {

		LoginPage login = new LoginPage(driver);
		login.setUserName("mngr511285");
		login.setPassword("YpepUne");

		login.clickOnLoginBtn();

		String expTitle = "Guru99 Bank Manager HomePage";
		String actTitle = driver.getTitle();
		if (expTitle.equals(actTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}
	
	

}
