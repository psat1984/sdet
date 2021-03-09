package projectActivities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Chromeactivity1 {
	   WebDriverWait wait;
	    AppiumDriver<MobileElement> driver = null;
	 @BeforeTest
	    public void setup() throws MalformedURLException {

	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "emulator-5554");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.android.chrome");
	        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	        caps.setCapability("noReset", true);

	        // Instantiate Appium Driver
	        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	        wait = new WebDriverWait(driver, 10);
	    }

	    @Test
	    public void testSearchAppium() throws InterruptedException {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	       
	        Thread.sleep(10000);
	        driver.get("https://www.training-support.net/selenium");
	        Thread.sleep(10000);
	        
	        //MobileElement listcard=driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).getChildByText(UiSelector().className(\"android.widget.TextView\"), \"To-Do List\")"));
	      //listcard.click();
	        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingToEnd(5)"));
	        MobileElement listitem=driver.findElementByXPath("//android.view.View[contains(@text,'To-Do List')]");
	        listitem.click();
	        Thread.sleep(10000);
	        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Add tasks to list");
	        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
	        Thread.sleep(5000);
	        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Get number of tasks");
	        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
	        Thread.sleep(5000);
	        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Clear the list");
	        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
	        Thread.sleep(3000);
	       List<MobileElement> listofTasks= driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View");
	   listofTasks.size();
	   Assert.assertEquals(listofTasks.size(), 4);
	   for(MobileElement task : listofTasks)
	   {
		   
		 task.click();
		 Thread.sleep(2000);
	   }
	   
	   driver.findElement(MobileBy.AndroidUIAutomator("textContains(\"Clear List\")")).click();
	   List<MobileElement> listofTasks1= driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View");
		  
		   Assert.assertEquals(listofTasks1.size(), 0);
	    }
	   // @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }
}
