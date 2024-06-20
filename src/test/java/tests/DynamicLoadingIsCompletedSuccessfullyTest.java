package tests;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;
import pages.Example2Page;
import pages.HomePage;
import tests.TestBases.TestBase;
import utils.ScreenshotUtil;

/**
 * Test class to verify the successful completion of dynamic loading example 2.
 * This test navigates through the homepage to the dynamic loading page, clicks on example 2,
 * starts the dynamic loading process, and verifies the appearance of a confirmation message.
 */
public class DynamicLoadingIsCompletedSuccessfullyTest extends TestBase
{
    // Page objects
    HomePage homeObject;
    DynamicLoadingPage dynamicLoadingObject;
    Example2Page example2Object;
    
    /**
     * Test method to verify successful dynamic loading completion.
     * It clicks through various elements and verifies expected text on the page.
     */
    @Test
    public void dynamicLoadingIsCompletedSucessfully()
    {
        // Initialize WebDriverWait with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Instantiate HomePage object using driver from TestBase
        homeObject = new HomePage(driver);
        
        // Wait for dynamic loading link to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(homeObject.dynamicLoading));
        
        // Navigate to the dynamic loading page by clicking on the link
        homeObject.openDynamicLoading();
        
        // Instantiate DynamicLoadingPage object using driver from TestBase
        dynamicLoadingObject = new DynamicLoadingPage(driver);
        
        // Wait for Example 2 link to be visible
        wait.until(ExpectedConditions.visibilityOf(dynamicLoadingObject.example2));
        
        // Click on Example 2 link
        dynamicLoadingObject.clickOnExample2();
        
        // Instantiate Example2Page object using driver from TestBase
        example2Object = new Example2Page(driver);
        
        // Wait for Start button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(example2Object.startBtn));
        
        // Click on Start button to trigger dynamic loading
        example2Object.clickOnStartBtn();
        
        // Wait for confirmation message to be visible
        wait.until(ExpectedConditions.visibilityOf(example2Object.confirmationMsg));
        
        // Assertion to verify that the confirmation message is displayed
        Assert.assertTrue(example2Object.confirmationMsg.isDisplayed(), "Confirmation message is not displayed.");
        
        // Assertion to verify the text of the confirmation message
        Assert.assertEquals(example2Object.confirmationMsg.getText(), "Hello World!", "Incorrect confirmation message text.");
        
        // Take a screenshot after successful dynamic loading (uncomment when needed)
        // ScreenshotUtil.captureScreenshot(driver, "SuccessfulDynamicLoading");
    }
}
