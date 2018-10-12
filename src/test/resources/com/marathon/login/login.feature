Feature: LoginScenarioOutline
  As a Marathon Staff
  I like to login to construction website

  Scenario Outline: Login functionality to Construction Website
    Given I navigate to Construction Website
    When I enter Username as "<username>" and Password as "<password>"
    Then Login should be checked

    Examples:
      | username  | password  |
      | username1 | password1 |
      | nawa      | password2   |
      | username3 | password3 |