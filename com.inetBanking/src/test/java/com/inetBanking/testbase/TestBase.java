package com.inetBanking.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.inetBanking.utility.ConfigDataProvider;
import com.inetBanking.utility.ExcelDataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	public ConfigDataProvider configDataProvider;
	public ExcelDataProvider excelDataProvider;

	@BeforeSuite
	public void init() {
		configDataProvider = new ConfigDataProvider("config");
		excelDataProvider = new ExcelDataProvider("TestData");
	}

	@BeforeMethod
	@Parameters({ "browsername" })
	public void setup(@Optional("chrome") String brName) {
		if (brName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (brName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (brName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Expected browser isn't exists");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(configDataProvider.getAppURL());

	}

	@AfterMethod
	public void teardown() throws InterruptedException {

		Thread.sleep(3000);
		driver.quit();

	}

}
