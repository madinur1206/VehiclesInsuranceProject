package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

public class RequestQuotationPage {
    public RequestQuotationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ui-id-2")
    public WebElement requestQuotationButton;
    @FindBy(id = "quotation_breakdowncover")
    public WebElement breakdownCover;

    @FindBy(id = "quotation_windscreenrepair_t")
    public WebElement windscreenRepairYes;

    @FindBy(id = "quotation_windscreenrepair_f")
    public WebElement windscreenRepairNo;

    @FindBy(name = "incidents")
    public WebElement incidentsInput;

    @FindBy(name = "registration")
    public WebElement registrationInput;

    @FindBy(name = "mileage")
    public WebElement annualMileageInput;

    @FindBy(name = "value")
    public WebElement estimatedValueInput;

    @FindBy(name = "parkinglocation")
    public WebElement parkingLocationDropdown;

    // Assuming Start of Policy is represented by dropdowns
    @FindBy(name= "year")
    public WebElement startOfPolicyYearDropdown;

    @FindBy(name= "month")
    public WebElement startOfPolicyMonthDropdown;

    @FindBy(name = "date")
    public WebElement startOfPolicyDayDropdown;


    @FindBy(xpath = "//input[@type='button']")
    public WebElement calculatePremiumButton;

    @FindBy(name= "submit")
    public WebElement saveQuotationButton;

    @FindBy(id= "resetquote")
    public WebElement resetFormButton;

    @FindBy(id= "calculatedpremium")
    public WebElement premiumText;

    @FindBy(xpath = "//b[text()='You have saved this quotation!']")
    public WebElement confirmationMessage;

   //@FindBy(css = "html>body>b:nth-of-type(2)")
    //public WebElement quotationIdMessage;
   @FindBy(tagName = "body")
   public WebElement ID;


    /*public int extractQuotationID() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        WebElement idElement = wait.until(ExpectedConditions.visibilityOf(quotationIdMessage));
        String messageText = idElement.getText();
        // Ensure the text is not empty and contains "identification number is"
        if (!messageText.isEmpty() && messageText.contains("identification number is")) {
            String idStr = messageText.replaceAll("[^\\d]", ""); // Remove all non-digits
            return Integer.parseInt(idStr);
        } else {
            throw new IllegalStateException("Quotation ID not found in the text.");
        }
    }
*/
    public int extractQuotationID() {
        String idText = ID.getText(); // Step 1: Extract text
        System.out.println("Extracted ID Text: " + idText); // Optional: for debugging

        // Step 2: Clean the string to keep only digits and parse it to integer
        String numericPart = idText.replaceAll("[^\\d]", ""); // Remove non-numeric characters

        if (numericPart.isEmpty()) {
            throw new IllegalStateException("No numeric ID found in the extracted text.");
        }

        return Integer.parseInt(numericPart); // Convert the cleaned string to an integer
    }

}









