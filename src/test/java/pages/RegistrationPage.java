package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

public class RegistrationPage {
    // Constructor to initialize elements with Page Factory using Driver utility
    public RegistrationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText="Register")
    public WebElement RegisterLink;
    @FindBy(name="email")
   public WebElement emailField;

    @FindBy(name="password")
   public WebElement passwordField;

    @FindBy(name="c_password")
    public WebElement confirmPasswordField;

    @FindBy(xpath="//input[@type='submit']")
    public WebElement createButton;

    @FindBy(xpath="//span[text()='PAssword and con.password does not match']")
    public WebElement errorMessage;

    // Method to fill in registration details and click create
    public void register1(String email, String password, String confirmPassword) {

        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
        createButton.click();
    }

}
