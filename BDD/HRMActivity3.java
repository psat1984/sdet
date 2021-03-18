package stepDefinition;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
public class HRMActivity3 extends BaseClass{
	
	String empId="";
	@Given("^Find PIM option in the menu and click it$")
	public void pim_option_in_the_menu_click() {
		WebElement PIMOptions = driver.findElement(By.id("menu_pim_viewPimModule"));
		PIMOptions.click();
		PIMOptions = driver.findElement(By.id("menu_pim_viewPimModule"));
		PIMOptions.click();

		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Employee Information')]"))));

		assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Employee Information");
		System.out.println("Employee Information Page is displayed");
	}
	
	@Given("^Click the Add button to add a new Employee$")
	public void click_on_add_employee() {
		driver.findElement(By.id("btnAdd")).click();
		System.out.println("Add Button is clicked");

	}
	

	@When("^fill required fields click Save \"(.*)\", \"(.*)\"$")
	public void fill_required_fields(String firstName,String lastName) {
	
		// Fill in the required fields and click Save.
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		System.out.println("Employee Details are entered");

		empId = driver.findElement(By.id("employeeId")).getAttribute("value");
		System.out.println("Employee Id : " + empId);
		//make sure to create login details to check
		driver.findElement(By.id("chkLogin")).click();
		driver.findElement(By.id("user_name")).sendKeys(firstName+lastName);

		driver.findElement(By.id("btnSave")).click();
		System.out.println("Save Button is clicked");

	}

	@Then("Verify Employee created {string}, {string}")
	public void verify_employee_is_created(String firstName,String lastName) {
		// Navigate back to the Admin page and verify the creation of your employee
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Employee Information')]"))));
		System.out.println("Navigated to Admin Page");

		driver.findElement(By.id("empsearch_id")).clear();
		driver.findElement(By.id("empsearch_id")).sendKeys(empId);

		driver.findElement(By.id("searchBtn")).click();
		System.out.println("The new employee created is searched");

		assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]")).getText(), empId);
		System.out.println("Employee id is displayed correctly");

		assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]")).getText(), firstName);
		System.out.println("First Name is displayed correctly");

		assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[4]")).getText(), lastName);
		System.out.println("Last Name is displayed correctly");
		
		driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[1]/input")).click();
		driver.findElement(By.id("btnDelete")).click();
		
		driver.findElement(By.id("dialogDeleteBtn")).click();

	}
}


