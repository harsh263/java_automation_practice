#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Harsh234
Feature: Products pop-up open and close test.
  I want to use this template for my feature file

Background:
	When background test step1
	When background test step2
	When background test step3

  @Nisha
  Scenario: Title of your scenario outline
    Given User is on Home page of website
    When User click on each product card and close pop-up
    Then Close the browser
    Then click on the link

    
 	@Harsh
 	Scenario: Test2 for testing Background
 	When User is on Home page of website
 	Then Close the browser