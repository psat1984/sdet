@activity1_4
Feature: Data driven test without Example

Scenario: Testing with Data from Scenario
    Given User on Login page
    When enters "admin" and "password"
    Then page title and confirmation message
    And Close Browser1