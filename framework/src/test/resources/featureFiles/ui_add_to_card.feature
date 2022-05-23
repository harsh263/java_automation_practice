#Author: harsh.shah263@gmail.com
#Scenario: To verify the Add to card functionality.
#Given: Should be logged in with standsrd user
#When: Click on Add to cark button of some of the products
#Then: To observe the list of products available in Basket

@ui_regression
Feature: Product add to card functionality

  Scenario: Add products to card and verify
  	Given Open browser and Home page of website
    And Accept cookies and welcome message
    And Perform Login with standard test user
   