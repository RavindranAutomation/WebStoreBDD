package com.webstore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webstore.driverfactory.DriverFactory;

public class PassRecoveryPage extends BasePage {
	public WebDriver driver = DriverFactory.getDriver();
	public PassRecoveryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='page-title']/child::h1[contains(text(),'recovery')]")
	private WebElement passwordRecoveryTitle;

	@FindBy(xpath = "//div[@class='inputs']/child::input")
	private WebElement passwordRecoveryEmailField;

	@FindBy(xpath = "//div[@class='buttons']/child::input[@name='send-email']")
	private WebElement recoveryBtn;

	@FindBy(xpath = "//div[@class='page-title']/following::div/child::div[contains(text(),'instructions')]")
	private WebElement PasswordRecoveryInstructionMessage;

	public boolean isPasswordRecoveryTitleisDisplayed() {
		return passwordRecoveryTitle.isDisplayed();

	}

	public void enterEmailInRecoveryEmailField() {
		typeTextIntoElement(passwordRecoveryEmailField, "ravindrann10898@gmail.com", 3);

	}

	public void clickOnRecoveryBtn() {
		javaScriptClick(recoveryBtn, 3);

	}

	public String getRecoveryInstructionMessage() {
		return getTextFromElement(PasswordRecoveryInstructionMessage, 3);

	}

}
