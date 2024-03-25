
Feature: Insurance Page Registration

  As a new user
  I want to sign up with my email and password
  So that I can register for insurance and either be redirected to the login page or informed of any errors

  Scenario Outline: Positive registration with valid email and matching passwords
    Given I am on the Insurance Page Registration form
    When I fill in the following mandatory details and submit the form:
      | Email              | <Email>              |
      | Password           | <Password>           |
      | Confirm password   | <ConfirmPassword>    |
    Then I should be redirected to "https://demo.guru99.com/insurance/v1/index.php"

  Examples:
    | Email                | Password   | ConfirmPassword |
    | elshat1234@gmail.com | Pass123!   | Pass123!        |

  Scenario Outline: Negative registration with invalid email format
    Given I am on the Insurance Page Registration form
    When I fill in the following mandatory details with wrong Email format and submit the form:
      | Email              | <Email>     |
      | Password           | <Password>  |
      | Confirm password   |  <ConfirmPassword>  |
    Then I should stay in same page"https://demo.guru99.com/insurance/v1/register.php"

    Examples:
      | Email        | Password  |    ConfirmPassword |
      | missingat    | Pass123!  |Pass123! |
      | noatdomain@  | Pass123!  | Pass123! |

  Scenario Outline: Negative registration with non-matching passwords
    Given I am on the Insurance Page Registration form
    When I fill in the following mandatory details with non-matching password and submit the form:
      | Email              | <Email>              |
      | Password           | <Password>           |
      | Confirm password   | <ConfirmPassword>    |
    Then I should see <ErrorMessage>

    Examples:
      | Email               | Password   | ConfirmPassword | ErrorMessage  |
      | elshat45789@gmail.com   | Pass123!   | PassWrong!      | "PAssword and con.password does not match"|
