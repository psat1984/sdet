package com.sdet.SeleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;
    
  

    @Test
    public void exampleTestCase() {
    	driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertEquals(title, "OrangeHRM");
        driver.quit();
      
    }



}

