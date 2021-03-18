package stepDefinition;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HRMActivity2 extends BaseClass {
	
	@Given("^Navigate to Recruitment page$")
	public void navigate_to_the_recruitement_page() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
		
	}
	
	@Given("^Click on Add to add candidate$")
	public void add_candidate() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("btnAdd")).click();
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("addCandidateHeading")));
	}
	


	@Then("^Fill the details of the candidate$")
	public void fill_the_details_of_candidate() {
		driver.findElement(By.id("addCandidate_firstName")).sendKeys("Mounika");
        driver.findElement(By.id("addCandidate_lastName")).sendKeys("Yerragundla");
        
        driver.findElement(By.id("addCandidate_email")).sendKeys("Yerragundla_mounika@test.com");
	}

	@Then("^Save$")
	public void save() {
	    //Click button to upload
	    driver.findElement(By.id("btnSave")).click();

	}
	@Then("^Confirm Candidate Entry$")
	public void confirm_candidate_entry() {
		
			
		driver.findElement(By.id("menu_recruitment_viewCandidates")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("candidateSearch_candidateName")));
		
		driver.findElement(By.id("candidateSearch_candidateName")).sendKeys("Mounika Yerragundla");
		
		driver.findElement(By.id("btnSrch")).click();
		
		//Verify Candidate
		assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[2]/td[3]/a")).getText(),"Mounika Yerragundla");

	}


}
