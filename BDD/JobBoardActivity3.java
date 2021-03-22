package stepDefinition;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JobBoardActivity3 {
	

	WebDriver driver;
	WebDriverWait wait;

	@Given("^Go to job site and navigate to job page testcase3 and testcase4$")
	public void wp_admin_Page_3_4() throws InterruptedException {
		// Setup instances
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);

		Thread.sleep(5000);
		 driver.get("https://alchemy.hguy.co/jobs/");
	        Thread.sleep(5000);
	       

	}

		@Given("^Navigate to Post Jobs Page$")
		public void navigate_to_post_jobs_page() {
			driver.findElement(By.xpath("//a[text()='Post a Job']")).click();
		}

		@Given("^give the credentials$")
		public void sign_in_to_post_jobs() {
			driver.findElement(By.xpath("//div[contains(@class,'account-sign-in')]/a")).click();

			// Enter UserName and Password and Login
			driver.findElement(By.id("user_login")).sendKeys("root");
			driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");

			driver.findElement(By.id("wp-submit")).click();
		}

		@Then("^Enter Email \"(.*)\", Job Title \"(.*)\", Job Type \"(.*)\", Description \"(.*)\", Company Name \"(.*)\"$")
		public void enter_email_job_title_job_type_description_company_name(String email, String jobTitle, String jobType,
				String description, String companyName) {
			driver.findElement(By.id("job_title")).sendKeys(jobTitle);

			Select select = new Select(driver.findElement(By.id("job_type")));

			select.selectByVisibleText(jobType);
			
			driver.findElement(By.id("application")).sendKeys(email);
			
			driver.findElement(By.id("job_description_ifr")).sendKeys(description);
			
			driver.findElement(By.id("company_name")).sendKeys(companyName);

		}

		@Then("^Click on Preview and Post$")
		public void click_on_save_draft() {
			driver.findElement(By.xpath("//input[@name='submit_job']")).click();
			
			driver.findElement(By.id("job_preview_submit_button")).click();
			
		}
		
		@Then("^Verify in the Job Listing \"(.*)\"$")
		public void verify_job_listing(String jobTitle) {

			driver.findElement(By.xpath("//a[text()='click here']")).click();
			
			assertEquals(jobTitle,driver.findElement(By.className("entry-title")).getText());
		}
		
		@And("^Close the JobSearch Browser1$")
		public void closeJobSearchBrowser1(){
			// Close browser
			driver.close();
		}
	
}
