@activity1_5
Feature: Data driven test with Example

Scenario Outline: Testing with Data from Scenario
    Given User is on Login page2
    When User enters "<Usernames>" and "<Passwords>"
    Then Read the page title and confirmation message2
    And Close the Browser2
    
Examples:
    | Usernames | Passwords |
    | admin     | password  |
    | adminUser | Password  |