package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // Making our driver instance private so that it is not directly accessible from outside of the class.
    // We make it static because we want it to be shared across all instances of this class.
    private static WebDriver driver = null;

    // Private constructor to prevent instantiation of the class.
    private Driver() {
    }

    /**
     * This method returns the singleton driver instance. If the instance is null, it initializes the driver
     * with the specified browser type from the configuration. This ensures that only one instance of the driver
     * is created and used throughout the execution of the program.
     *
     * @return WebDriver instance
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            // Reading the browser type from the configuration file
            String browserType = ConfigurationReader.getProperty("browser");

            // Initialize the WebDriver based on the specified browser type
            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Unsupported browser type: " + browserType);
            }

            // Common configurations for the driver
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        return driver;
    }

    /**
     * This method quits the driver instance and sets it to null to ensure
     * the proper cleanup of resources and the ability to start a new instance later if necessary.
     */
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

