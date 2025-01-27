package com.webstore.stepdefinitions;

import java.util.logging.Logger;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.webstore.constants.Cons;
import com.webstore.driverfactory.DriverFactory;
import com.webstore.pageobjectsmanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {
	PageObjectManager pom = new PageObjectManager(DriverFactory.getDriver());

	@Given("User opens the Application")
	public void user_opens_the_application() {
		try {
			pom.getInstanceHeader().clickOnLoginHeader();
			pom.getInstanceLogin().enterEmail(Cons.Email + Keys.TAB);
			pom.getInstanceLogin().enterPassword(Cons.Password);
			pom.getInstanceLogin().clickOnLoginBtn();
		} catch (Exception e) {
			Assert.fail(e + "Exception is caused");
		}
	}

	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String productname) {
		pom.getInstanceHeader().enterValuesInsideTheSearchBox(productname);
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		pom.getInstanceHeader().clickOnSearchButton();
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		Assert.assertEquals(pom.getInstaceSearch().isSearchPageTitleDisplayed(), true);
		Assert.assertEquals(pom.getInstaceSearch().isSearchedProductDisplayed(), true);
	}

	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProduct) {
		pom.getInstanceHeader().enterValuesInsideTheSearchBox(invalidProduct);
	}

	@Then("User should get {string} message")
	public void user_should_get_message(String noResultsMessage) {
		Assert.assertEquals(pom.getInstaceSearch().getInvalidSearchResultsMessage(), noResultsMessage);

	}

	@When("User not entered any product name into Search box field")
	public void user_not_entered_any_product_name_into_search_box_field() {
		pom.getInstanceHeader().enterValuesInsideTheSearchBox("");
	}

	@Then("User should get alert with {string}")
	public void user_should_get_alert_with(String expectedAlert) {
		String actualAlert = pom.getInstanceHeader().handleWithoutProductSearchAlert();
		Assert.assertEquals(actualAlert,expectedAlert);
	}
}
