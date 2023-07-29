package com.inetBanking.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Helper {

	public static String captureScreenshot(WebDriver driver) {
		
		String screenshotPath = System.getProperty("user.dir")+"/Screenshots/inetBanking_/" + getCurrentDateTime() + ".png";
		try {
//			TakesScreenshot ts = (TakesScreenshot) driver;
//			File scr = ts.getScreenshotAs(OutputType.FILE);
//			File target = new File("./Screenshots/inetBanking_" + getCurrentDateTime() + ".png");
//			FileHandler.copy(scr, target);

			
			FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
					new File(screenshotPath));

			System.out.println("Captured screenshot Successfully!!!");
		} catch (Exception e) {
			System.out.println("Exception raised in try block :- " + e);
		}
		
		return screenshotPath;

	}

	public static void handleAlertPopUp(WebDriver driver) {
		if (isAlertPresent(driver)) {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		} else {
			System.out.println("Alert popup not exists...!!!");
		}

	}

	public static boolean isAlertPresent(WebDriver driver) {

		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static String getCurrentDateTime() {
		return new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss").format(new Date());
	}

	public static void handleNormalDropdown(WebElement dropdown, int index) {
		new Select(dropdown).selectByIndex(index);
	}

	public static void handleNormalDropdown(WebElement dropdown, String visibleTxt) {
		new Select(dropdown).selectByVisibleText(visibleTxt);
	}

	public static void handleNormalDropdown(String value, WebElement dropdown) {
		new Select(dropdown).selectByValue(value);
	}

}
