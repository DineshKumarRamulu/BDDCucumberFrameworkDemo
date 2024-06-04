package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/features"},
		glue= {"stepsdefinitions","apphooks"},
		//tags = "@smoke or @Regression",
		tags = "@AddPlaceAPI or @DeletePlaceAPI",
		dryRun = false,
		plugin = {"pretty","html:test-output/CucumberHTMLReport.html","json:test-output/cucumber-report.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome =true
		)

public class TestRunner {
	




}
