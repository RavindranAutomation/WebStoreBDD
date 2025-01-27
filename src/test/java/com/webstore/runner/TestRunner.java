package com.webstore.runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/FeatureFiles/Login.feature",
		glue= {"com.webstore.stepdefinitions","com.webstore.hooks"},
		dryRun=!true,
		monochrome=true,
		publish = true,

		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:failed_scenarios/failedscenario.txt",
				"html:target/cucumber-reports/Cucumber.html",
				"json:target/cucumber-reports/Cucumber.json"

		}
		)

public class TestRunner {

	

}
