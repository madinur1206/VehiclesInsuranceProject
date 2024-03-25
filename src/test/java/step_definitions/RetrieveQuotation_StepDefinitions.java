package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.RetrieveQuotationPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class RetrieveQuotation_StepDefinitions {
    RetrieveQuotationPage retrieveQuotationPage = new RetrieveQuotationPage();

    @Given("I am on the Retrieve Quotation page")
    public void iAmOnTheRetrieveQuotationPage() {
        String url = ConfigurationReader.getProperty("homePageURL"); // Ensure this key exists in your configuration.
        Driver.getDriver().get(url);
        retrieveQuotationPage.retrieveQuotation.click();
    }

    @When("I enter the saved ID {string} into the ID field")
    public void i_enter_the_saved_id_into_the_id_field(String savedId) {
        retrieveQuotationPage.quotationIdInput.clear();
        retrieveQuotationPage.quotationIdInput.sendKeys(savedId);
    }

    @When("I submit the request to retrieve the quotation")
    public void i_submit_the_request_to_retrieve_the_quotation() {
        retrieveQuotationPage.retrieveButton.click();


    }
    @Then("I validate the URL is {string}")
    public void i_validate_the_url_is(String expectedUrl) {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals("The URL did not match the expected value.", expectedUrl, actualUrl);
    }
}