package com.inetBanking.testcases;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageobject.HomePage;
import com.inetBanking.pageobject.LoginPage;
import com.inetBanking.pageobject.NewCustomerPage;
import com.inetBanking.testbase.TestBase;

public class NewCustomerTC_001 extends TestBase {

	NewCustomerPage newCustomer;
	
	int row =1;

//	@Test(priority = 1)
//	public void verifyNewCustomerTC_001() {
//
//		LoginPage login = new LoginPage(driver);
//		login.setUserName(excelDataProvider.getStringCellData("Login", 1, 0));
//		login.setPassword(excelDataProvider.getStringCellData("Login", 1, 1));
//
//		HomePage homepage = login.clickOnLoginBtn();
//
//		newCustomer = homepage.clickOnNewCustomerLink();
//
//		String actTitle = newCustomer.verifyNewCustomerPage();
//		// String expTitle = "Guru99 Bank New Customer Entry Page";
//
//		if (actTitle.contains("New Customer")) {
//
//			Assert.assertTrue(true);
//			System.out.println("Navigated to " + driver.getTitle());
//		} else {
//			Assert.assertTrue(false);
//		}
//	}

//	@Test(priority = 2)
//	public void createNewCutomerTC_002() {
//
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//
//		newCustomer.setCutomerName("Vaishali");
//		newCustomer.selectGender("Female");
//		newCustomer.setDOB("22-04-1999");
//		newCustomer.setAddress("Karve road near Jijau Gardon");
//		newCustomer.setCity("Pune");
//		newCustomer.setState("Maharashtra");
//		newCustomer.setPIN("411001");
//		newCustomer.setMobile("9987654098");
//
//		newCustomer.setEmail("vaishali132@gmail.com");
//		newCustomer.setPassword("Vaishali@1233$");
//
//		newCustomer.clickOnSubmit();
//
//		String successMsg = driver.findElement(By.xpath("//p[text()='Customer Registered Successfully!!!']")).getText();
//
//		System.out.println(successMsg);
//
//		String customerID = driver.findElement(By.xpath("//table[@id='customer']/tbody/tr[4]/td[2]")).getText();
//
//		System.out.println(customerID);//93522
//	}

	@Test(dataProvider = "fetchExcelTestData")
	public void createNewCustomerTC_002(String customerName, String Gender, String dob,
			String address, String city, String state, String pin, String mobile, 
			String email, String password) 
	{

//		System.out.println(customerName+"   "+Gender+"    "+dob+"   "+address+"   "+city+"   "+state+"  "+pin+
//				"  "+mobile+"   "+email+"   "+password);
		
		
		LoginPage login = new LoginPage(driver);
		login.setUserName(excelDataProvider.getStringCellData("Login", 1, 0));
		login.setPassword(excelDataProvider.getStringCellData("Login", 1, 1));

		HomePage homepage = login.clickOnLoginBtn();

		newCustomer = homepage.clickOnNewCustomerLink();
		
		newCustomer.setCutomerName(customerName);
		newCustomer.selectGender(Gender);
		newCustomer.setDOB(dob);
		newCustomer.setAddress(address);
		newCustomer.setCity(city);
		newCustomer.setState(state);
		newCustomer.setPIN(pin);
		newCustomer.setMobile(mobile);

		newCustomer.setEmail(email);
		newCustomer.setPassword(password);

		newCustomer.clickOnSubmit();

		String successMsg = driver.findElement(By.xpath("//p[text()='Customer Registered Successfully!!!']")).getText();

		System.out.println(successMsg);

		String customerID = driver.findElement(By.xpath("//table[@id='customer']/tbody/tr[4]/td[2]")).getText();

		System.out.println(customerID);//1682
		
				
		try {
			excelDataProvider.setStringCellData("newCustomer",row,customerID );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		row = row+1;
		
		
		
		//newCustomer	= homepage.clickOnNewCustomerLink();  30648 18847

		
	}
	
	@DataProvider
	public String[][] fetchExcelTestData()
	{
		
		String[][] data = excelDataProvider.getExcelTestData("newCustomer");
		return data;
	}

}


