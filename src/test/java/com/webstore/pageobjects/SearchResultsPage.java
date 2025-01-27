package com.webstore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webstore.driverfactory.DriverFactory;

public class SearchResultsPage extends BasePage {

	public WebDriver driver = DriverFactory.getDriver();
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='page-title']/child::h1[contains(text(),'Search')]")
	private WebElement searchPageTitle;

	@FindBy(xpath = "//div[@class='inputs']/child::input")
	private WebElement searchValueAttribute;

	@FindBy(xpath = "//h2[@class='product-title']/child::a")
	private WebElement searchResultProduct;

	@FindBy(xpath = "//div[@class='buttons']/child::input[@value='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "//div[@class='search-results']/strong[contains(text(),'No products')]")
	private WebElement invalidSearchResultsMessage;

	public boolean isSearchPageTitleDisplayed() {
		return searchPageTitle.isDisplayed();

	}

	public String getSearchProductDetail() {
		return searchValueAttribute.getAttribute("value");

	}

	public boolean isSearchedProductDisplayed() {
		return searchResultProduct.isDisplayed();

	}
	
	public String getInvalidSearchResultsMessage() {
		return invalidSearchResultsMessage.getText();
	}
}
