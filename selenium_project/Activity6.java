package com.sdet.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver;
	
    @Test
    public void exampleTestCase() {
    	//open browser
    	driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        //login
        WebElement firstName = driver.findElement(By.id("txtUsername"));
        WebElement lastName = driver.findElement(By.id("txtPassword"));
        firstName.sendKeys("orange");
        lastName.sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
      //navigation menu location
       wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[contains(@class, 'menu')]")))) ;
       //directory menu 
       wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("menu_directory_viewDirectory")))) ;
       wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("menu_directory_viewDirectory"))));
       driver.findElement(By.id("menu_directory_viewDirectory")).click();
       driver.findElement(By.id("menu_directory_viewDirectory")).click();
       String header = driver.findElement(By.xpath("//div[@class='head']/h1")).getText();
	   Assert.assertEquals("Search Directory", header);
	   //closing the browser
       driver.quit();
}
}