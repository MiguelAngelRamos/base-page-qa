Feature: Login functionality
  As a user
  I want to validate the login form
  So that I see correct validation messages

  Scenario: Login with invalid email and password
    Given I am on the login page
    When I enter email "usuario@invalido" and password "123"
    And I submit the login form
    Then I should see email validation error
    And I should see password validation error
