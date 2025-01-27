Feature: Webstore search functionality

  @Sanity @Regression
  Scenario: User searches for a valid product
    Given User opens the Application
    When User enters valid product "Smartphone" into Search box field
    And User clicks on Search button
    Then User should get valid product displayed in search results
    And User should logout

  @Sanity @Regression
  Scenario: User searches for an invalid product
    Given User opens the Application
    When User enters invalid product "Honda" into Search box field
    And User clicks on Search button
    Then User should get "No products were found that matched your criteria." message
    And User should logout

  @Regression @Master
  Scenario: User searches without any product
    Given User opens the Application
    When User not entered any product name into Search box field
    And User clicks on Search button
    Then User should get alert with "Please enter some search keyword"
    And User should logout
