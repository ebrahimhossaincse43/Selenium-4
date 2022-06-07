package com.bd.ebrahim;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import org.testng.annotations.Test;

public class RelativeLocators extends DriverSetUp{	
	String baseUrl = "https://opensource-demo.orangehrmlive.com";
	
	@Test
	public void loginCredentailsGet() throws InterruptedException {
		driver.get(baseUrl);
		WebElement loginInformation = driver.findElement(By.id("logInPanelHeading"));
		WebElement credentails = driver.findElement(RelativeLocator.with(By.tagName("span")).above(loginInformation));
		System.out.println("/*************************");
		System.out.println(credentails.getText());
		System.out.println("*************************/");
	}
	
	@Test
	public void getListOfSocialMedia() {
		List<WebElement> allSocialMedia = driver.findElements(with(
				By.tagName("img"))
				.near(By.id("footer")));
		System.out.println("/*************************");
		for (WebElement socialMediaList : allSocialMedia) {
			System.out.println(socialMediaList.getAttribute("alt"));
		}
		System.out.println("*************************/");
		
		
		String url =  driver.getCurrentUrl();
		System.out.println(url);
	}
}
