package com.webstore.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="@failed_scenarios/failedscenario.txt",
		glue= {"com.opencart.stepdefinitions","com.opencart.hooks"},
		dryRun=!true,
		monochrome=true
		
	)


public class ReRunner {

}
