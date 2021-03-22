@JobBoard
Feature: Login Test

Scenario: Testing Login
    Given User logging into wp-adminpage
     When Create User
    Then check user is created
    And Close the Admin Browser