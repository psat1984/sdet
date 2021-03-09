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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
public class ChromeActivity2 {
	
		AppiumDriver<MobileElement> driver = null;
		 WebDriverWait wait;
		 @BeforeClass
		    public void startUp() throws MalformedURLException, InterruptedException {
		        // Set the Desired Capabilities
		        DesiredCapabilities caps = new DesiredCapabilities();
		        caps.setCapability("deviceName", "emulator-5554");
		        caps.setCapability("platformName", "Android");
		        caps.setCapability("appPackage", "com.android.chrome");
		        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		        caps.setCapability("noReset", true);

		        // Instantiate Appium Driver
		        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		        wait = new WebDriverWait(driver, 50);
		    }
	
		 
		  @Test
		    public void validlogin() {
		        driver.get("https://www.training-support.net/selenium");
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View")));
				  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollToEnd(2).scrollIntoView(UiSelector().textContains(\"Login Form\"))")).click();
		        driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").sendKeys("admin");
		        driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").sendKeys("password");
		        driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
		        

		        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@resource-id='action-confirmation']")));
			 	
				 //Check Message when the credentials are correct
				 MobileElement confirmationMessage = driver.findElementByXPath("//android.view.View[@resource-id='action-confirmation']");
				 Assert.assertEquals("Welcome Back, admin", confirmationMessage.getText());
				System.out.println("Credentials are correct");
		    }
			 
		   @Test
		    public void invalidlogin() {
		        driver.get("https://www.training-support.net/selenium");
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View")));
		       
		        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollToEnd(2).scrollIntoView(UiSelector().textContains(\"Login Form\"))")).click();
		       // driver.findElement(MobileBy.AndroidUIAutomator("text(\"To-Do List \")"));
		        driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").sendKeys("admin1");
		        driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").sendKeys("password1");
		driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
		        

		        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@resource-id='action-confirmation']")));
			 	
				 //Check Message when the credentials are correct
				 MobileElement confirmationMessage = driver.findElementByXPath("//android.view.View[@resource-id='action-confirmation']");
				 Assert.assertEquals("Invalid Credentials", confirmationMessage.getText());
				System.out.println("Credentials are incorrect");

		     }


		@AfterTest
		public void tearDown() {
		    driver.quit();
		}

}
