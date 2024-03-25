package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

        public LoginPage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(id = "email")
        public WebElement emailInput;

        @FindBy(id = "password")
        public WebElement passwordInput;

        @FindBy(name= "submit")
        public WebElement loginButton;

        @FindBy(xpath = "//b[text()='Enter your Email address and password correct']")
        public WebElement errorMessage;

        @FindBy(xpath = "//h2[text()='Broker Insurance WebPage']")
         public WebElement homePageText;

        public void enterCredentials(String email, String password) {
            emailInput.sendKeys(email);
            passwordInput.sendKeys(password);
        }

        public void clickLogin() {
            loginButton.click();
        }

        public String getPageText() {
            return homePageText.getText();
        }
    public String getErrorMessage() {
        return errorMessage.getText();
    }

    }


