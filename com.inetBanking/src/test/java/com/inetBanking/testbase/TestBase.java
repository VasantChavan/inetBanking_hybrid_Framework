package com.inetBanking.testbase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inetBanking.utility.ConfigDataProvider;
import com.inetBanking.utility.ExcelDataProvider;
import com.inetBanking.utility.Helper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	public ConfigDataProvider configDataProvider;
	public ExcelDataProvider excelDataProvider;
	public ExtentHtmlReporter extentHtmlReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;

	@BeforeSuite
	public void init() {
		
		configDataProvider = new ConfigDataProvider("config");
		excelDataProvider = new ExcelDataProvider("TestData");
		
		extentHtmlReporter=new ExtentHtmlReporter("./Reports/inetBanking_report_"+Helper.getCurrentDateTime()+".html");
		extentHtmlReporter.config().setDocumentTitle("RT Automation Reports");
		extentHtmlReporter.config().setReportName("RT Test");
		//extentHtmlReporter.config().setTheme(Theme.STANDARD );
		extentHtmlReporter.config().setTheme(Theme.DARK );
		
		extentReports =new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
		
		extentReports.setSystemInfo("Hostname", "Local Host");
		extentReports.setSystemInfo("OS", "Windows");
		extentReports.setSystemInfo("Browser", "Chrome");
		extentReports.setSystemInfo("TE", "Vaishali");
		extentReports.setSystemInfo("Test Cases", "Smoke Test cases");	
		
		
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
	public void teardown(ITestResult result) throws Exception {

		Thread.sleep(3000);
		
		if(result.getStatus()== ITestResult.FAILURE)
		{
			extentTest.fail("Test Case Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
		driver.quit();

	}
	
	@AfterTest
	public void extentFlush()
	{
		
		extentReports.flush();
	}

}
