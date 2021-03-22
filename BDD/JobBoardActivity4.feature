@JobBoardActivity4
Feature: Login Test

  Scenario Outline: Using Examples table to post a job
    Given Go to job site and navigate to job page testcase3 and testcase4
    And Navigate to Post Jobs Page
    And give the credentials
    Then Enter Email "<email>", Job Title "<jobTitle>", Job Type "<jobType>", Description " <Description> ", Company Name " <companyName> "
    And Click on Preview and Post
    And Verify in the Job Listing "<jobTitle>"
    And Close the JobSearch Browser1

    Examples: 
      | email  						| jobTitle | jobType  |Description 			|companyName |
      | jan30test@test.com | Tester	 | Full Time|Full Time Tester	|ABC					|
   		| feb01@test.com | Tester	 |Internship|Internship Tester|ABC					|