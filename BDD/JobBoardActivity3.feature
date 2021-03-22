@JobBoardActivity3
Feature: Login Test

 Scenario: Posting a job using parameterization
    Given Go to job site and navigate to job page testcase3 and testcase4
    And Navigate to Post Jobs Page
    And give the credentials
    Then Enter Email "jan29test@test.com", Job Title "Tester", Job Type "Full Time", Description " description", Company Name "IBM"
    And Click on Preview and Post
    And Verify in the Job Listing "Tester"
    And Close the JobSearch Browser1
