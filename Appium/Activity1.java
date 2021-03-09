package projectActivities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1 {

	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@BeforeTest
	public void setup() throws MalformedURLException {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "emulator-5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", " com.google.android.apps.tasks");
		caps.setCapability("appActivity", ".ui.TaskListsActivity");
		caps.setCapability("noReset", true);

		// Instantiate Appium Driver
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver, 5);
	}

	@Test
	public void testSearchAppium() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(10000);

		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Create new task\"]").click();
		Thread.sleep(10000);
		driver.findElementById("com.google.android.apps.tasks:id/add_task_title")
				.sendKeys("Complete Activity with Google Tasks");
		Thread.sleep(10000);
		driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Create new task\"]").click();
		Thread.sleep(10000);
		driver.findElementById("com.google.android.apps.tasks:id/add_task_title")
				.sendKeys("Complete Activity with Google Keep");
		Thread.sleep(5000);
		driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Create new task\"]").click();
		Thread.sleep(10000);
		driver.findElementById("com.google.android.apps.tasks:id/add_task_title")
				.sendKeys("Complete the second Activity Google Keep");
		Thread.sleep(5000);
		driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();

		// /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText
		String task1 = driver
				.findElementByXPath("//android.widget.TextView[@text='Complete Activity with Google Tasks']").getText();
		Assert.assertEquals(task1, "Complete Activity with Google Tasks");
		String task2 = driver
				.findElementByXPath("//android.widget.TextView[@text='Complete Activity with Google Keep']").getText();
		Assert.assertEquals(task2, "Complete Activity with Google Keep");
		String task3 = driver
				.findElementByXPath("//android.widget.TextView[@text='Complete the second Activity Google Keep']")
				.getText();
		Assert.assertEquals(task3, "Complete the second Activity Google Keep");
	}

	// @AfterTest
	public void tearDown() {
		driver.quit();
	}

}