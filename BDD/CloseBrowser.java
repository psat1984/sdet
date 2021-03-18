package stepDefinition;

import io.cucumber.java.en.And;

public class CloseBrowser extends BaseClass{


	@And("^Close the Browser$")
	public void close_Browser() {
		// Close browser
		driver.quit();
	}

}
