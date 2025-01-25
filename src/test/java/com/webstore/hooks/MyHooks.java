package com.webstore.hooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.webstore.constants.Cons;
import com.webstore.driverfactory.DriverFactory;
import com.webstore.utilities.CommonUtils;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {
	@Before
	public void beforeScenario() {
		CommonUtils.loadProperties();
		if (DriverFactory.getDriver() == null) {
			DriverFactory.launchBrowser(Cons.BrowserName);
			DriverFactory.getDriver().get(Cons.Url);
			DriverFactory.getDriver().manage().window().maximize();
		}

	}

	@AfterStep
	public static void takeScreenshot(Scenario scenario) {
		String scenarioName = scenario.getName();
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Failed  - " + scenarioName);
		}

	}

	@AfterAll
	public static void tearDown() {
		DriverFactory.getDriver().quit();
	}

}
