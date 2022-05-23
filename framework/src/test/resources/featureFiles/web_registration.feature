#Author: harsh.shah263@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Register as new user and login using the same user.
#Given: User is on Home page of the system under test.
#When: Navigate to registration page and fill and submit form.
#Then: To observe the successful registration and login.
@ui_smoke
Feature: Registration feature

  Scenario: Perform registration and login feature
    Given Open browser and Home page of website
    Given Accept cookies and welcome message
    When Navigate to Login page
    And Navigate to Registration form page
    And Fill up Registration form with random data and submit
    Then Verify successful Login using new user
    
   Scenario: Pagination test on Home page
   Given Open browser and Home page of website
   Given Accept cookies and welcome message
   When change product pagination option
   Then verify number of product cards on first page 
   