

Feature: Retrieve Quotation Functionality

  Scenario Outline: Retrieve and validate quotation for stored IDs
    Given I am on the Retrieve Quotation page
    When I enter the saved ID "<SavedID>" into the ID field
    And I submit the request to retrieve the quotation
    Then I validate the URL is "https://demo.guru99.com/insurance/v1/retrieve_quotation.php"

    Examples:
      | SavedID |
      |34943  |
      | 34944   |
      | 34945  |
      | 34946   |
      | 34947   |
