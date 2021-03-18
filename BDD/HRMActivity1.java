package stepDefinition;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;


public class HRMActivity1 extends BaseClass{


	@Given("^Go to Vacancy portal$")
	public void wpadminPage() throws InterruptedException {
				createWebDriver();
				driver.get("http://alchemy.hguy.co/orangehrm");
		//driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
		
	}
	
	@Given("^Navigate to the Recruitment page$")
	public void navigate_to_recruitement_page() throws InterruptedException {
		driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
		
	}
	
	@Given("^Click on Vacancies Menu$")
	public void navigate_to_vacancies_menu() throws InterruptedException {
		driver.findElement(By.linkText("Vacancies")).click();
	}
		
	@Given("^Add Job Vacancy$")
	public void add_job_vacancy() throws InterruptedException {
	

		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		
	}
	

	
	@When("^Job Vacancy Form is filled and saved job title \"(.*)\", vacancy name \"(.*)\", hiring manager \"(.*)\"$")
	public void job_vacancy_form_is_filled_and_saved(String jobTitleL,String vacancyName,String hiringManager) {
		Select jobTitle = new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
		jobTitle.selectByVisibleText(jobTitleL);
		
		driver.findElement(By.id("addJobVacancy_name")).sendKeys(vacancyName);
		
		driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys(hiringManager);
		
		driver.findElement(By.id("btnSave")).click();
	}
	
	@Then("^verify vacancy is created job title \"(.*)\", vacancy name \"(.*)\", hiring manager \"(.*)\"$")
	public void vacancy_should_be_created(String jobTitleL,String vacancyName,String hiringManagerL) {
		driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
		
		Select jobTitle = new Select(driver.findElement(By.id("vacancySearch_jobTitle")));
		jobTitle.selectByVisibleText(jobTitleL);
		
		Select jobVacancy = new Select(driver.findElement(By.id("vacancySearch_jobVacancy")));
		jobVacancy.selectByVisibleText(vacancyName);
		
		Select hiringManager = new Select(driver.findElement(By.id("vacancySearch_hiringManager")));
		hiringManager.selectByVisibleText(hiringManagerL);
		
		driver.findElement(By.id("btnSrch")).click();
		
		//Verify Vacancy
		assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]/a")).getText(),vacancyName);
		//Verify Job Title
		assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]")).getText(),jobTitleL);
		//Verify Hiring Manager
		assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[4]")).getText(),hiringManagerL);
		
		
	}

}
