package com.bd.ebrahim;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class WindowAndTab extends DriverSetUp {
	String baseUrl = "http://automationpractice.com/index.php";

	/*
	 * New Tab
	 * 
	 * @Test public void testNewWindowTab() throws InterruptedException {
	 * driver.get(baseUrl); System.out.println("Before Title: "+driver.getTitle());
	 * WebDriver newWindow = driver.switchTo().newWindow(WindowType.TAB);
	 * Thread.sleep(2000); System.out.println("After Title: "+driver.getTitle()); }
	 */

	/*
	 * New Window
	 * 
	 * @Test public void testNewWindow() throws InterruptedException {
	 * driver.get(baseUrl); String newUrl =
	 * "http://automationpractice.com/index.php?controller=prices-drop";
	 * System.out.println("Before Title: "+driver.getTitle()); WebDriver newWindow =
	 * driver.switchTo().newWindow(WindowType.WINDOW); newWindow.get(newUrl);
	 * Thread.sleep(2000); System.out.println("After Title: "+driver.getTitle()); }
	 */

	@Test
	public void testNewWindowTabHandling() throws InterruptedException {
		driver.get(baseUrl);
		// Automatically Open and Switch To The New Window or Tab
		WebDriver newWindow = driver.switchTo().newWindow(WindowType.TAB);
		newWindow.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		// Work on the new window or tab
		Faker faker = new Faker();
		String email = faker.bothify("????##@gmail.com");
		WebElement emailInput = driver.findElement(By.id("email_create"));
		emailInput.clear();
		emailInput.sendKeys(email);

		WebElement createButton = driver.findElement(By.id("SubmitCreate"));
		createButton.click();
		Thread.sleep(2000);
		// Get the Window ID Handles
		Set<String> allWindowsTabs = driver.getWindowHandles();
		Iterator<String> interate = allWindowsTabs.iterator();
		String mainWindow = interate.next();

		// Switch and Working
		driver.switchTo().window(mainWindow);

		WebElement searchInput = driver.findElement(By.id("search_query_top"));
		searchInput.clear();
		searchInput.sendKeys("Shirt");

		WebElement searchButton = driver.findElement(By.name("submit_search"));
		searchButton.click();

		Thread.sleep(2000);
		System.out.println(driver.getTitle());
	}

}
