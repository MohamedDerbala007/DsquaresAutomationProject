package tests.TestBases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * TestBase class provides basic setup and teardown methods for WebDriver initialization and termination.
 * It is intended to be extended by test classes that require WebDriver functionality.
 */
public class TestBase {

    public static WebDriver driver;

    /**
     * Setup method to initialize WebDriver before test execution.
     * This method sets up ChromeDriver, maximizes the browser window,
     * sets implicit wait time, and navigates to a predefined URL.
     */
    @SuppressWarnings("deprecation")
    @BeforeClass
    public void startDriver() 
    {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("https://the-internet.herokuapp.com/");
    }

    /**
     * Teardown method to quit WebDriver after test execution.
     * This method checks if the driver instance is not null before quitting.
     */
    @AfterClass
    public void stopDriver() 
    {
        if (driver != null) 
        {
            driver.quit();
        }
    }

    /**
     * Getter method to retrieve the current WebDriver instance.
     *
     * @return WebDriver instance used for test execution.
     */
    public WebDriver getDriver() 
    {
        return driver;
    }
}
