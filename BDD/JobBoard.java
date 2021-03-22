package stepDefinition;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;


public class JobBoard {

	 WebDriver driver;
	    WebDriverWait wait;
	    
	    @Given("^User logging into wp-adminpage$")
	    public void wp_admin_Page_1() throws InterruptedException {
	        //Setup instances
	        driver = new FirefoxDriver();
	        wait = new WebDriverWait(driver, 10);
	        
	        //Open browser
	        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	        Thread.sleep(5000);
	        driver.findElement(By.id("user_login")).sendKeys("root");
	        //Enter password
	        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	        //Click Login
	        driver.findElement(By.id("wp-submit")).click();
	    }
	    
	    @When("^Create User$")
	    public void enterCredentials() {
	        //Enter username
	    	driver.findElement(By.linkText("Users")).click();
	    	driver.findElement(By.linkText("Add New")).click();
	    	 driver.findElement(By.id("user_login")).sendKeys("abcdefz");
	    	 driver.findElement(By.id("email")).sendKeys("abcdefz@gmail.com");
	    	 driver.findElement(By.id("createusersub")).click();
	    	 
	    	//
	    }
	  
	    @Then("^check user is created$")
	    public void checkUserDetails() {
	        //Enter username
	    	  driver.findElement(By.id("user-search-input")).sendKeys("abcdefz");
	    	   	 driver.findElement(By.id("search-submit")).click();
	    	   	boolean display= driver.findElement(By.linkText("abcdefz")).isDisplayed();
	    	   	System.out.println(display);
	    	   	Assert.assertTrue("true",display);
	    	 
	    	
	    }
	  
	    
	    @And("^Close the Admin Browser$")
	    public void closeAdminBrowser() {
	        //Close browser
	        driver.close();
	    }
	
}
