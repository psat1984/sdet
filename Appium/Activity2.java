package Activities;

import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.MobileElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Activity2 {
	AppiumDriver<MobileElement> driver = null; 	
	
	@BeforeClass
	    
	    public void calc() throws MalformedURLException {
	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceId", "2eed910sa");
	        caps.setCapability("deviceName", "emulator-5554");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.android.calculator2");
	        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
	        caps.setCapability("noReset", true);
	        
	        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer,caps);
	}

	@Test
	public void multiply() {
		driver.findElementById("digit_7").click();
		driver.findElementById("op_mul").click();
	      
		driver.findElementById("digit_4").click();
	      
		driver.findElementById("eq").click();
		String result = driver.findElementById("result").getText();
		System.out.println(result);
	      Assert.assertEquals(result,"28");
	      
	    }
	
	@AfterClass
	public void afterClass(){
		driver.quit();
	}
	
}
