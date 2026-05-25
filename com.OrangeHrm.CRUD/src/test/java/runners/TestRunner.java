package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = "stepdefinitions",
	    plugin = {
	        "pretty",
	        "html:target/cucumber-report.html",
	        "json:target/cucumber.json",
	        "rerun:target/failed_scenarios.txt"
	    },
	    monochrome = true,
	    dryRun = false,
	    publish = true
	)
	public class TestRunner extends AbstractTestNGCucumberTests {
	}