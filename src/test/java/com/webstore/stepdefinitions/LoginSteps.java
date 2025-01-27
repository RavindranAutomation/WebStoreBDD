package com.webstore.stepdefinitions;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.webstore.driverfactory.DriverFactory;
import com.webstore.pageobjectsmanager.PageObjectManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	PageObjectManager pom = new PageObjectManager(DriverFactory.getDriver());

	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		pom.getInstanceHeader().clickOnLoginHeader();

	}

	@When("User enters email address {string} into email field")
	public void user_enters_email_address_into_email_field(String email) {

		pom.getInstanceLogin().enterEmail(email + Keys.TAB);

	}

	@When("User enters password {string} into password field")
	public void user_enters_password_into_password_field(String pass) {
		pom.getInstanceLogin().enterPassword(pass);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		pom.getInstanceLogin().clickOnLoginBtn();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {

		Assert.assertEquals(true, pom.getInstanceHeader().isLogoutDisplayed());
	}

	@Then("User should logout")
	public void user_should_logout() {
		pom.getInstanceHeader().clickOnLogoutHeader();
	}

	@Then("User should not get successfully logged in")
	public void user_should_not_get_successfully_logged_in() {
		if (pom.getInstanceLogin().isInvalidAttemptAlertDispalyed()) {
			Assert.assertEquals("Login was unsuccessful. Please correct the errors and try again.",
					pom.getInstanceLogin().getInvalidLoginAlertMessage());

		} else {
			Assert.fail();
		}

	}

	@Then("User should get {string} alert message")
	public void user_should_get_alert_message(String invalidEmailALert) {

		Assert.assertEquals(invalidEmailALert, pom.getInstanceLogin().getInvalidEmailEnteredMessage());

	}

	@When("User clicks on the forget password link")
	public void user_clicks_on_the_forget_password_link() {
		pom.getInstanceLogin().clickOnForgotPassword();
	}

	@When("User enters the email in the recovery email field")
	public void user_enters_the_in_the_recovery_email_field() {
		pom.getInstanceRecovery().enterEmailInRecoveryEmailField();
	}

	@Then("User should get proper {string} message")
	public void user_should_get_proper_message(String expectedInstructionMessage) {
		String actualInstructionMessage = pom.getInstanceRecovery().getRecoveryInstructionMessage();
		Assert.assertEquals(actualInstructionMessage, expectedInstructionMessage);

	}

	@And("User clicks on the recovery button")
	public void user_clicks_on_the_recovery_button() {
		pom.getInstanceRecovery().clickOnRecoveryBtn();
	}

}
