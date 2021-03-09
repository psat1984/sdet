package projectActivities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.MobileElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity3 {
	 WebDriverWait wait;
	    AppiumDriver<MobileElement> driver = null;

	    @BeforeTest
	    public void setup() throws MalformedURLException {

	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "emulator-5554");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.google.android.keep");         
	        caps.setCapability("appActivity", ".activities.BrowseActivity"); 
	        caps.setCapability("noReset", true);

	        // Instantiate Appium Driver
	        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	           wait = new WebDriverWait(driver, 10);
	    }

	    @Test
	    public void  GoogleKeepapptoaddanotewithareminder() {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	    	driver.findElementByAccessibilityId("New text note").click();
	    	driver.findElementById("editable_title").sendKeys("title");
	    	driver.findElementById("edit_note_text").sendKeys("edit text");
	    	driver.findElementByAccessibilityId("Single-column view").click();
	    	driver.findElementByAccessibilityId("Time - Currently selected - 8:00 AM").click();
	    	driver.findElementById("reminder_time_morning").click();
	    	driver.findElementById("save").click();
	    	driver.findElementByAccessibilityId("Open navigation drawer").click();
	    	driver.findElementByAccessibilityId("Open navigation drawer").click();
	    	driver.findElementById("drawer_navigation_reminders").click();
	    	
	 
	      List<MobileElement> listitems = driver.findElementsById("browse_text_note");
	    	
	    	for(MobileElement tasks : listitems) {
	    	System.out.println("tasks--"+tasks.getAttribute("content-desc"));
	    	}
	      Assert.assertEquals(listitems.size(),1);
	    
	    }
	    
	    @AfterTest
	    public void tearDown() {
	       driver.quit();
	    }
}
