package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/features"},
		glue= {"stepsdefinitions","apphooks"},
		tags = "@smoke or @Regression",
		//tags = "@product",
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)

public class TestRunner {
	




}
