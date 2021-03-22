@JobBoardActivity2
Feature: Login Test

Scenario: Testing Login
    Given Go to job site and navigate to job page testcase2
    When search job details filled
    Then check job listing is present
    Then Apply for the job
    And Close the JobSearch Browser