package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.pages.Pages;

import com.utilities.ConfigUtilities;

public abstract class Base {

	public static WebDriver driver;
	
	public static Pages pages;

	public static void initilizePage(Pages page) {
		pages = page;
	}

	@BeforeMethod
	public static void setup() throws Exception {
		String brname = ConfigUtilities.readConfig("browser");
		if (brname.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (brname.equalsIgnoreCase("firfox")) {
			driver = new FirefoxDriver();
		} else if (brname.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		} else if (brname.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("Invalid browser");
		}
		String Url = ConfigUtilities.readConfig("url");
		driver.get(Url);
	}

	@AfterMethod
	public void teardown() throws Exception {

		Thread.sleep(5000);
		if (driver != null) {

			driver.quit();
		}

	}
}
