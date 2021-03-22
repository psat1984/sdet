package cucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:/SDET-WorkSpace/Cucumber_Project/src/test/java/features",
    glue = {"stepDefinition"},
    tags = "@JobBoardActivity4",
   // plugin = { "pretty", "html:target/cucumber-reports/reports"  },
    plugin = { "json:target/cucumber-reports/reportsJB4.json" },
    monochrome = true
)
public class ActivitiesRunnerPorject4_JobBoard {

}
