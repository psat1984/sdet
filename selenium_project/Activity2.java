package com.sdet.SeleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity2 {
	 WebDriver driver;
	    
	  

	    @Test
	    public void exampleTestCase() {
	    	driver = new FirefoxDriver();
	        driver.get("http://alchemy.hguy.co/orangehrm");
	        String url = driver.getCurrentUrl();
	        System.out.println("Page title is: " + url);
	        driver.quit();
	      
	    }
}
