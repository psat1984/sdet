package com.sdet.SeleniumProject;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity8 {

	@Test
	public void exampleTestCase() {
		// open browser
		WebDriver driver = new FirefoxDriver();

		driver.get("http://alchemy.hguy.co/orangehrm");
		// login
		WebElement firstName = driver.findElement(By.id("txtUsername"));
		WebElement lastName = driver.findElement(By.id("txtPassword"));
		firstName.sendKeys("orange");
		lastName.sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("menu_dashboard_index")).click();
		driver.findElement(By.linkText("Apply Leave")).click();
		driver.findElement(By.linkText("Apply Leave")).click();
		Select dropdown = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));

		dropdown.selectByVisibleText("Paid Leave");
		WebElement fromdate = driver.findElement(By.id("applyleave_txtFromDate"));
		fromdate.click();

		fromdate.sendKeys("2020-12-28");
		driver.findElement(By.xpath("//ol")).click();
		;

		WebElement todate = driver.findElement(By.id("applyleave_txtToDate"));
		todate.click();
		driver.findElement(By.linkText("28")).click();
		driver.findElement(By.id("applyleave_txtComment")).sendKeys("vacation");
		driver.findElement(By.id("applyBtn")).click();
		driver.findElement(By.linkText("My Leave")).click();
		WebElement calfromdate = driver.findElement(By.id("calFromDate"));
		calfromdate.clear();
		calfromdate.sendKeys("2020-12-28");
		// driver.findElement(By.linkText("25")).click();

		WebElement caltodate = driver.findElement(By.id("calToDate"));
		caltodate.clear();
		caltodate.sendKeys("2020-12-28");
		// driver.findElement(By.linkText("29")).click();
		driver.findElement(By.id("btnSearch")).click();
		// List<WebElement> cols =
		// driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[7]"));

		// System.out.println("Number of columns are: " + cols.size());

		System.out.println("Number of rows are: " + rows.size());

		for (int i = 0; i <= rows.size(); i++) {
			String vacation = rows.get(i).getText();
			if (vacation.equalsIgnoreCase("vacation")) {
				String status=driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[6]")).getText();
				Assert.assertTrue(status!=null);
				break;
			}
		}
		
		driver.quit();

	}

}
