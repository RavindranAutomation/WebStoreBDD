package com.webstore.stepdefinitions;

import org.testng.Assert;

import com.webstore.driverfactory.DriverFactory;
import com.webstore.pageobjects.HeadersPage;
import com.webstore.pageobjects.HomePage;
import com.webstore.pageobjects.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	HeadersPage headerPage;
	LoginPage loginPage;
	HomePage homePage;

	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		headerPage = new HeadersPage(DriverFactory.getDriver());
		headerPage.clickOnLoginHeader();

	}

	@When("User enters email address {string} into email field")
	public void user_enters_email_address_into_email_field(String email) {
		loginPage = new LoginPage(DriverFactory.getDriver());
		loginPage.enterEmail(email);

	}

	@When("User enters password {string} into password field")
	public void user_enters_password_into_password_field(String pass) {
		loginPage.enterPassword(pass);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLoginBtn();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		Assert.assertEquals(true, headerPage.isLogoutDisplayed());
	}

	@Then("User should logout")
	public void user_should_logout() {
		headerPage.clickOnLogoutHeader();
	}

}
