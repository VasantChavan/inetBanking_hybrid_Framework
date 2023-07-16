package com.inetBanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageobject.LoginPage;
import com.inetBanking.testbase.TestBase;

public class LoginTC_003 extends TestBase {

	@Test
	public void verifyLoginFunctionalityTC_003() {

		LoginPage login = new LoginPage(driver);

//		String username = excelDataProvider.getStringCellData(0, 1, 0);
//		String password = excelDataProvider.getStringCellData(0, 1, 1);
//		String expTitle = excelDataProvider.getStringCellData(0, 1, 2);
		
		String username = excelDataProvider.getStringCellData("Login", 1, 0);
		String password = excelDataProvider.getStringCellData("Login", 1, 1);
		String expTitle = excelDataProvider.getStringCellData("Login", 1, 2);


		login.setUserName(username);
		login.setPassword(password);
		
		login.clickOnLoginBtn();

		if (expTitle.equals(driver.getTitle())) {
			Assert.assertTrue(true);
			System.out.println("Login Success  !!!");

		} else {
			System.out.println("Login Failed  !!!");
			Assert.assertTrue(false);

		}

	}

}
