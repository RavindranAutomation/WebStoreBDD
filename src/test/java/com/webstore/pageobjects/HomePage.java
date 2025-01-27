package com.webstore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webstore.driverfactory.DriverFactory;

public class HomePage extends BasePage {

	public WebDriver driver = DriverFactory.getDriver();

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
	private WebElement registrationSuccessMsgElement;

	public String getRegisterSuccessMessage() {
		return getTextFromElement(registrationSuccessMsgElement, 3);

	}
}
