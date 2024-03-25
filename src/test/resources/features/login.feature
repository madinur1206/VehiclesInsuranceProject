
Feature: Login to Insurance WebPage

  As a user
  I want to log in with my email and password
  So that I can access the Broker Insurance WebPage

  Background:
    Given I am on the Insurance WebPage login form

  Scenario Outline: Login attempts with different credentials
    When I enter "<email>" and "<password>"
    When I click the "login" button
    Then I expect to "<Outcome>" after login attempt

    Examples:
      | email                   | password    | Outcome                                            |
      | elshat90@gmail.com | 1234  | be redirected to the Broker Insurance WebPage     |
      | incorrect_email@site.com| correct_pw  | see an error message                              |
      | correct_email@site.com  | incorrect_pw| see an error message                              |
      | incorrect_email@site.com| incorrect_pw| see an error message                              |
