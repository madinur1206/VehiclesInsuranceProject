package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RetrieveQuotationPage {
    public RetrieveQuotationPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(id= "ui-id-3")
    public WebElement retrieveQuotation;
    @FindBy(name= "id")
    public WebElement quotationIdInput;
    @FindBy(id = "getquote")
    public WebElement retrieveButton;
    public String expectedUrl = "https://demo.guru99.com/insurance/v1/retrieve_quotation.php";

}
