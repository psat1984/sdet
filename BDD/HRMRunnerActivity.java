package cucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:/SDET-WorkSpace/Cucumber_Project/src/test/java/features",
    glue = {"stepDefinition"},
    tags = "@HRM",
    plugin = {"pretty","html:target/cucumber-reports/hrmreport1.html","json:target/cucumber-reports/hrmreport.json"},
	monochrome = true
)
public class HRMRunnerActivity {

}
