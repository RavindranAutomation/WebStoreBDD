package com.webstore.pageobjectsmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.webstore.driverfactory.DriverFactory;
import com.webstore.pageobjects.HeadersPage;
import com.webstore.pageobjects.HomePage;
import com.webstore.pageobjects.LoginPage;
import com.webstore.pageobjects.PassRecoveryPage;
import com.webstore.pageobjects.RegisterPage;
import com.webstore.pageobjects.SearchResultsPage;

public class PageObjectManager {

	WebDriver driver= DriverFactory.getDriver();

	public PageObjectManager(WebDriver pomDriver) {
		this.driver = pomDriver;
		PageFactory.initElements(pomDriver, this);
	}


	private HeadersPage headerPage;

	public HeadersPage getInstanceHeader() {
		headerPage = new HeadersPage(driver);
		return headerPage;
	}

	private LoginPage loginPage;

	public LoginPage getInstanceLogin() {
		loginPage = new LoginPage(driver);
		return loginPage;
	}
	
	private HomePage homePage;

	public HomePage getInstanceHome() {
		homePage = new HomePage(driver);
		return homePage;
	}
	
	private RegisterPage registerPage;

	public RegisterPage getInstanceRegister() {
		registerPage = new RegisterPage(driver);
		return registerPage;
	}
	
	private PassRecoveryPage recoveryPage;

	public PassRecoveryPage getInstanceRecovery() {
		recoveryPage = new PassRecoveryPage(driver);
		return recoveryPage;
	}
	
	private SearchResultsPage searchPage;

	public SearchResultsPage getInstaceSearch() {
		searchPage = new SearchResultsPage(driver);
		return searchPage;
	}
	
	
}
