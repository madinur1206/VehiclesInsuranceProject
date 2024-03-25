package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Login_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("I am on the Insurance WebPage login form")
    public void i_am_on_the_insurance_web_page_login_form() {
        String url = ConfigurationReader.getProperty("loginURL");
        Driver.getDriver().get(url);
    }
    @When("I enter {string} and {string}")
    public void i_enter_and(String email, String password) {
        loginPage.enterCredentials(email, password);
    }

    @When("I click the login page {string} button")
    public void i_click_the_login_button(String button) {

        loginPage.clickLogin();
    }
    @Then("I expect to {string} after login attempt")
    public void i_expect_to_outcome_after_login_attempt(String outcome) {
        if (outcome.equals("be redirected to the Broker Insurance WebPage")) {
            wait.until(ExpectedConditions.visibilityOf(loginPage.homePageText));
            Assert.assertTrue(loginPage.homePageText.isDisplayed());
        } else if (outcome.equals("see an error message")) {
            wait.until(ExpectedConditions.visibilityOf(loginPage.errorMessage));
            Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        } else {
            throw new IllegalArgumentException("Unexpected outcome: " + outcome);
        }
    }
}
