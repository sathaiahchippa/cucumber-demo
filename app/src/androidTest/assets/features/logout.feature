@logout
Feature: Logout
    Perform login on email and password are inputted

  @sample
  Scenario: Input email and password in wrong format-non outline
    Given I have a LoginActivity
    When I input email
    And I input password
    Then I press submit button

  @sample2
  Scenario: Input email and password in wrong format-non
    Given I have a LoginActivity
    When I input email
    And I input password
    Then I press submit button

  Scenario: Input email and password in wrong format-default
    Given I have a LoginActivity
    When I input email
    And I input password
    Then I press submit button

  Scenario: Input email and password in wrong format-default2
    Given I have a LoginActivity
    When I input email for test data not found
    And I input password
    Then I press submit button

  Scenario: Test home button
    Given I have a LoginActivity
    When I press home button
    Then Home screen is displayed

  @sample222
  Scenario: Input email and password in wrong format-non outline-test
    Given I have a LoginActivity
    When I input email
    Then I press submit button