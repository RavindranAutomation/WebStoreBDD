Feature: Webstore Login functionality

  @Sanity @Regression
  Scenario Outline: Successfull login with valid credentials
    Given User navigates to login page
    When User enters email address "<email>" into email field
    And User enters password "<pass>" into password field
    And User clicks on Login button
    Then User should get successfully logged in
    And User should logout

    Examples: 
      | email                 | pass       |
      | RaviTest@yopmail.com  | Test@12345 |
      | RaviTest2@yopmail.com | Test@12345 |
  #@Sanity @Regression
  #Scenario Outline: Unsuccessfull login with valid credentials
    #Given User navigates to login page
    #When User enters email address "<email>" into email field
    #And User enters password "<pass>" into password field
    #And User clicks on Login button
    #Then User should not get successfully logged in
#
    #Examples: 
      #| email                  | pass      |
      #| ravindn10898@gmail.com | Test@1345 |
      #| ravik23n@yopmail.com   | Test@145  |
