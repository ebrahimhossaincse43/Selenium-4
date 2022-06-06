package com.bd.ebrahim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetUp {
	WebDriver driver;
	String baseUrl = "https://opensource-demo.orangehrmlive.com";

	@BeforeSuite
	public void start() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
