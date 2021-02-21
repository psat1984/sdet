package com.sdet.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity3 {
	 WebDriver driver;
	    
	  

	    @Test
	    public void exampleTestCase() {
	    	driver = new FirefoxDriver();
	        driver.get("http://alchemy.hguy.co/orangehrm");
	        WebElement firstName = driver.findElement(By.id("txtUsername"));
	        WebElement lastName = driver.findElement(By.id("txtPassword"));
	        firstName.sendKeys("orange");
	        lastName.sendKeys("orangepassword123");
	        driver.findElement(By.id("btnLogin")).click();
	        String homeTitle=driver.getTitle();
	        String homeUrl= driver.getCurrentUrl();
	        Assert.assertEquals(homeTitle, "OrangeHRM");
	        Assert.assertEquals(homeUrl, "http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/dashboard");
	        driver.quit();
}
}