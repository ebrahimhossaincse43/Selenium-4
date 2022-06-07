package com.bd.ebrahim;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v100.log.Log;
import org.testng.annotations.Test;

public class ConsoleLogs extends DriverSetUp{
	
	 @Test
	  public void viewBrowserConsoleLogs(){
	    // Get The DevTools & Create A Session
		ChromeDriver driver = new ChromeDriver();
	    DevTools devTools = driver.getDevTools();
	    devTools.createSession();

	    // Enable The Console Logs
	    devTools.send(Log.enable());

	    // Add A Listener For The Logs
	    devTools.addListener(Log.entryAdded(), logEntry -> {
	      System.out.println("----------");
	      System.out.println("Level: " + logEntry.getLevel());
	      System.out.println("Text: " + logEntry.getText());
	      System.out.println("Broken URL: " + logEntry.getUrl());
	    });

	    // Load The AUT
	    driver.get("http://the-internet.herokuapp.com/broken_images");
	 }
}
