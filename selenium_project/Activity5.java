package com.sdet.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity5 {
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
        driver.findElement(By.xpath("//b[contains(text(),'My Info')]")).click();
        driver.findElement(By.xpath("//b[contains(text(),'My Info')]")).click();
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("testuser1");
        driver.findElement(By.id("personal_txtEmpLastName")).clear();
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("testuserlast1");
        driver.findElement(By.id("personal_optGender_2")).click();
        driver.findElement(By.id("personal_DOB")).clear();
        driver.findElement(By.id("personal_DOB")).sendKeys("1991-05-25");
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        driver.quit();
        
     
    }
}