#Author: your.email@your.domain.com

Feature: Date picker test
  I want to use this template for my feature file

  @datepicker
  Scenario Outline: Date picker test with different data
    Given Navigate to date picker page
    And Click on date text box
    When Select the date "<date>" "<month>" "<year>" and click
    Then Validate the selected date

    Examples: 
      | date  | month  | year	 |
      | 18 		|	July		 | 2022	 |