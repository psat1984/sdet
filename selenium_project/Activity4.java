package com.sdet.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity4 {
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
	        WebElement pim = driver.findElement(By.cssSelector("a#menu_pim_viewPimModule"));
            pim.click();
            driver.findElement(By.cssSelector("a#menu_pim_addEmployee")).click();
            driver.findElement(By.cssSelector("input#firstName")).sendKeys("0123abc");
            driver.findElement(By.cssSelector("input#lastName")).sendKeys("987abc");
            driver.findElement(By.cssSelector("input#chkLogin")).click();
            driver.findElement(By.id("user_name")).sendKeys("0123abc987abc@gmail.com");
            driver.findElement(By.id("btnSave")).click();
            driver.findElement(By.cssSelector("a#menu_admin_viewAdminModule")).click();
            driver.findElement(By.id("searchSystemUser_userName")).sendKeys("0123abc987abc@gmail.com");  
            driver.findElement(By.id("searchBtn")).click();
            WebElement employeeElement = driver.findElement(By.linkText("0123abc987abc@gmail.com"));
            Assert.assertEquals(employeeElement.getText(), "0123abc987abc@gmail.com");
            driver.quit();
	    }
}
