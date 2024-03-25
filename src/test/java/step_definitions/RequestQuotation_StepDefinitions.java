
package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.RequestQuotationPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class RequestQuotation_StepDefinitions {
    RequestQuotationPage requestQuotationPage = new RequestQuotationPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    private List<Integer> storedQuotationIDs = new ArrayList<>();

    @Given("I am on the Request Quotation page")
    public void i_am_on_the_request_quotation_page() {
        String url = ConfigurationReader.getProperty("homePageURL"); // Ensure this key exists in your configuration.
        Driver.getDriver().get(url);
        requestQuotationPage.requestQuotationButton.click();
    }

    @When("I fill the {string} with {string}")
    public void i_fill_the_breakdownCover_with(String dropdownName, String value) {
        new Select(requestQuotationPage.breakdownCover).selectByVisibleText(value);

    }

    @When("I select {string} for {string}")
    public void i_select_for_WindscreenRepair(String option, String fieldName) {
        if (fieldName.equalsIgnoreCase("Windscreen Repair")) {
            if (option.equalsIgnoreCase("Yes")) {
                requestQuotationPage.windscreenRepairYes.click();
            } else if (option.equalsIgnoreCase("No")) {
                requestQuotationPage.windscreenRepairNo.click();
            }
        }
    }

    @When("I enter {string} in the {string} field")
    public void iEnterInTheField(String value, String fieldName) {
        switch (fieldName) {
            case "Incidents":
                requestQuotationPage.incidentsInput.sendKeys(value);
                break;
            case "Registration":
                requestQuotationPage.registrationInput.sendKeys(value);
                break;
            case "Annual Mileage":
                requestQuotationPage.annualMileageInput.sendKeys(value);
                break;
            case "Estimated Value":
                Assert.assertTrue("Value must be numeric.", value.matches("\\d+"));
                requestQuotationPage.estimatedValueInput.sendKeys(value);
                break;
        }
    }
    @When("I select {string} for Parking Location")
    public void iSelectForParkingLocation(String location) {
        new Select(requestQuotationPage.parkingLocationDropdown).selectByVisibleText(location);
    }
    @When("I select {string}, {string}, {string} for Start of Policy")
    public void iSelectForStartOfPolicy(String year, String month, String day) {
        new Select(requestQuotationPage.startOfPolicyYearDropdown).selectByVisibleText(year);
        new Select(requestQuotationPage.startOfPolicyMonthDropdown).selectByVisibleText(month);
        new Select(requestQuotationPage.startOfPolicyDayDropdown).selectByVisibleText(day);
    }
    @When("I submit the request for quotation")
    public void iSubmitTheRequestForQuotation() {
        requestQuotationPage.calculatePremiumButton.click();
    }
    @Then("I should see a quotation generated")
    public void iShouldSeeAQuotationGenerated() {
        String premiumTextContent = requestQuotationPage.premiumText.getText();
        Assert.assertTrue("Quotation text does not include 'Premium'", premiumTextContent.contains("Premium"));
    }
    @When("I click the {string} button")
    public void iClickTheButton(String buttonName) {
            requestQuotationPage.saveQuotationButton.click();
        }
    @Then("I should see a message confirming the quotation has been saved")
    public void iShouldSeeAMessageConfirmingTheQuotationHasBeenSaved() {
        Assert.assertTrue("Quotation save confirmation not visible.",requestQuotationPage.confirmationMessage.isDisplayed());
    }
    @And("I store the quotation ID for later retrieval")
    public void iStoreTheQuotationIdForLaterRetrieval() {
        int id = requestQuotationPage.extractQuotationID();
        System.out.println("Quotation ID: " + id); // For demonstration, shows ID in output.
        // Here you would store 'id' where needed for later use.
    }

}

