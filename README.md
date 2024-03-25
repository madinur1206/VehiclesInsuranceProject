# Insurance Quotation Automation Test Suite

This repository contains a Selenium-based automated test suite for generating and retrieving insurance quotations for vehicles. The test suite is built using the Page Object Model (POM) design pattern and is data-driven to allow testing with various vehicle data sets.

## Project Overview

The test suite automates the following processes on the demo insurance site:

1. Creation of insurance quotations for five different vehicles.
2. Retrieval of the quotation IDs generated for these vehicles.
3. Validation of the retrieval functionality by entering the saved quotation IDs.

The automation covers the end-to-end process, from logging into the application to verifying the successful storage and retrieval of insurance data.

## Testing Scope

The scope of the assessment includes:

- Navigating to the [Insurance Quotation Page](https://demo.guru99.com/insurance/v1/index.php).
- Filling out the quotation form with data for five different vehicles.
- Submitting the form and capturing the unique quotation ID for each vehicle.
- Navigating to the 'Retrieve Quotation' page and entering each saved ID to validate successful retrieval.

## Assumptions

The following assumptions were made during the development of this test suite:

- The web elements' locators remain constant.
- The site's workflow for generating and retrieving quotes does not change.
- The quotation IDs are always numerical and displayed in a consistent format.
- The website's response times may vary, and adequate waits have been implemented to account for this.
- Each test case is independent and can be run in any sequence without affecting the others.
- Test data for the vehicles is dynamically driven and can be expanded for additional test coverage.

## Setup and Execution

Instructions on how to set up and execute the test suite are provided below:

### Prerequisites

- Java JDK 8 or above.
- Maven for managing the project dependencies and executing the test suite.
- WebDriver executables for the intended browser testing (e.g., ChromeDriver for Google Chrome).

### Running the Tests

To execute the entire test suite, use the following command in the terminal:
mvn clean test
--To run only the failed tests from the previous execution:
mvn test -Dcucumber.options="@target/rerun.txt"
Test Reports
After execution, the test reports can be found in the target/cucumber-reports directory, with separate reports for the initial run and any reruns of failed tests.

Repository Structure
src/main/java/pages: Contains the Page Object classes for the web pages.
src/test/java/step_definitions: Contains the step definition classes for the Cucumber scenarios.
src/test/resources/features: Contains the feature files that define the test scenarios in Gherkin language.
Contributions and Feedback
Contributions to the test suite are welcome. Please ensure to follow the existing code style and add tests for any new features. Feedback and suggestions can be submitted via the issue tracker on this repository.