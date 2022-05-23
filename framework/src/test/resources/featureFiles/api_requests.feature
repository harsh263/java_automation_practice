#Author: harsh.shah263@gmail.com
#Keywords Summary :
#Feature: Verify response code all the API requests.
@api_smoke
Feature: Title of your feature
  I want to use this template for my feature file

  @smoke1
  Scenario Outline: Verify response code for all API requests
    Given Create request specification
    When Perform Get reuest with endpoint "<get_endpoint>"
    Then Verify response message as "<status>"
    When Perform Post reuest with endpoint "<post_endpoint>" with "<post_data>"
    Then Verify response message as "<status>"
    When get user id of new created user

    Examples: 
      | get_endpoint | post_endpoint | status  | post_data        |
      | /v2/users    | /v2/users     | success | test_post_data_1 |
