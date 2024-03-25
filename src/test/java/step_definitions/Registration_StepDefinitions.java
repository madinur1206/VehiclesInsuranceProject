package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.RegistrationPage;
import utilities.Driver;

import java.util.Map;

public class Registration_StepDefinitions {
    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 5);
    RegistrationPage registrationPage = new RegistrationPage();

    @Given("I am on the Insurance Page Registration form")
    public void i_am_on_the_insurance_page_registration_form() {
        driver.get("https://demo.guru99.com/insurance/v1/index.php");
        registrationPage.RegisterLink.click();
    }

    @When("I fill in the following mandatory details and submit the form:")
    public void i_fill_in_the_following_mandatory_details(Map<String, String> userDetails) {
      registrationPage.register1(userDetails.get("Email"), userDetails.get("Password"), userDetails.get("Confirm password"));

            //registrationPage.register1(userDetails.get("Email"), userDetails.get("Password"), "Pass123!");
        }

    @Then("I should be redirected to {string}")
    public void i_should_be_redirected_to(String expectedUrl) {
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals("The user was not redirected to the expected URL", expectedUrl, driver.getCurrentUrl());
    }
    @When("I fill in the following mandatory details with wrong Email format and submit the form:")
    public void i_fill_in_the_following_mandatory_details_with_wrong_email_format_and_submit_the_form(Map<String, String> userDetails)
    {
        registrationPage.register1(userDetails.get("Email"), userDetails.get("Password"), userDetails.get("Confirm password"));

    }
    @Then("I should stay in same page{string}")
    public void i_should_stay_in_same_page(String expectedUrl) {
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals("The user was not redirected to the expected URL", expectedUrl, driver.getCurrentUrl());

    }
    @When("I fill in the following mandatory details with non-matching password and submit the form:")
    public void i_fill_in_the_following_mandatory_details_with_non_matching_password_and_submit_the_form(Map<String, String> userDetails) {
        registrationPage.register1(userDetails.get("Email"), userDetails.get("Password"), userDetails.get("Confirm password"));

    }
    @Then("I should see {string}")
        public void i_should_see(String expectedErrorMessage) {
            // Wait for the error message to be visible on the page.
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(registrationPage.errorMessage));

            // Retrieve the actual error message from the web element defined in your RegistrationPage class
            String actualErrorMessage = registrationPage.errorMessage.getText();
            // Assert that the actual error message matches the expected error message
            Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        }

    }





