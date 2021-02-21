package com.sdet.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

@Test
public class Activity7 {
WebDriver driver;
	
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
       // WebElement myinfotab1 =driver.findElement(By.xpath("//b[contains(text(),'My Info')]")).click();
        WebElement myinfotab=driver.findElement(By.xpath("//b[contains(text(),'My Info')]"));
        myinfotab.click();
        driver.findElement(By.xpath("//b[contains(text(),'My Info')]")).click();
        driver.findElement(By.linkText("Qualifications")).click();
        driver.findElement(By.id("addWorkExperience")).click();
        driver.findElement(By.id("experience_employer")).sendKeys("IBM");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Tester");
        driver.findElement(By.id("experience_comments")).sendKeys("project purpose");
        driver.findElement(By.id("btnWorkExpSave")).click();
        driver.quit();
     
}
}
