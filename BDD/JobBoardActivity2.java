package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JobBoardActivity2 {

	WebDriver driver;
	WebDriverWait wait;

	@Given("^Go to job site and navigate to job page testcase2$")
	public void wp_admin_Page_2() throws InterruptedException {
		// Setup instances
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);

		// Open browser
		driver.get("https://alchemy.hguy.co/jobs/");
		Thread.sleep(5000);

	}

	@When("^search job details filled$")
	public void searchJobDetails() throws Throwable {
		driver.findElement(By.linkText("Jobs")).click();

		driver.findElement(By.xpath("//input[@id='search_keywords']")).sendKeys("01tester02");
		// input
		driver.findElement(By.xpath("//input[@id='job_type_freelance']")).click();
		driver.findElement(By.xpath("//input[@id='job_type_internship']")).click();
		driver.findElement(By.xpath("//input[@id='job_type_part-time']")).click();
		driver.findElement(By.xpath("//input[@id='job_type_temporary']")).click();

		driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();

	}

	@Then("^check job listing is present$")
	public void checkJobListing() {
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//ul[@class='job_listings']//h3[text()='01tester02']")));
		driver.findElement(By.xpath("//ul[@class='job_listings']//h3[text()='01tester02']")).click();
		String jobtitle = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
		System.out.println("Job Title:" + jobtitle);

	}

	@Then("^Apply for the job$")
	public void applyforjob() throws Throwable {
		driver.findElement(By.xpath("//input[@class='application_button button']")).click();
	}

	@And("^Close the JobSearch Browser$")
	public void closeJobSearchBrowser() {
		// Close browser
		driver.close();
	}

}
