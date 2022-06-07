package com.bd.ebrahim;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Screenshots extends DriverSetUp {
	
	private File getSreenShotMethodImageFile = new File("..//Selenium_4//src//screenshots//fullPage.png");
	private File entirePageImageFile = new File("..//Selenium_4//src//screenshots//entirepage.png");

	@BeforeMethod
	public void home() throws InterruptedException {
		String url = "http://automationpractice.com/index.php";
		driver.get(url);
		Thread.sleep(1000);
	}

	@Test(priority = 0)
	public void getElementScreenshots() throws IOException, InterruptedException {
		WebElement logo = driver.findElement(By.id("header_logo"));
		File source = logo.getScreenshotAs(OutputType.FILE);
		File destination = new File("..//Selenium_4//src//screenshots//logo.png");
		FileHandler.copy(source, destination);
	}

	@Test(priority = 1)
	public void takeWebElementPageSectionScreenshot() throws InterruptedException, IOException {
		WebElement pageSection = driver.findElement(By.id("htmlcontent_home"));
		File source = pageSection.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("..//Selenium_4//src//screenshots//pageSection.png"));
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void takeCurrentScreenScreenshots() throws IOException {
		// Take Screenshot of viewable area
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Write Screenshot to a file
		FileUtils.copyFile(scrFile, getSreenShotMethodImageFile);
	}

	@Test(priority = 3)
	public void screenshotEntirePageAshot() throws IOException {
		// Take Screenshot of entire page by AShot
		Screenshot entirePageScreenShot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
				.takeScreenshot(driver);
		// Write Screenshot to a file
		ImageIO.write(entirePageScreenShot.getImage(), "PNG", entirePageImageFile);
	}

}
