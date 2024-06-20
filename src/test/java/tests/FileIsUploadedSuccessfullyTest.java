package tests;

import java.nio.file.Paths;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import data.LoadProperties;
import pages.FileUploadPage;
import pages.HomePage;
import tests.TestBases.TestBase;
import utils.ScreenshotUtil;

/**
 * Test class to verify successful file upload functionality.
 * This test navigates to the homepage, opens the file upload section,
 * selects a file specified in the properties file, uploads it,
 * and verifies the appearance of a confirmation message.
 */
public class FileIsUploadedSuccessfullyTest extends TestBase
{
    // Page objects
    HomePage homeObject;
    FileUploadPage fileUploadObject;

    // File path loaded from properties file
    String relativeFilePath = LoadProperties.filePath.getProperty("filePath");

    /**
     * Test method to verify successful file upload.
     * It performs steps to upload a file and validate the confirmation message.
     */
    @Test
    public void userCanUploadFileSuccessfully()
    {
        // Initialize WebDriverWait with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Instantiate HomePage object using driver from TestBase
        homeObject = new HomePage(driver);

        // Wait for file upload link to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(homeObject.fileUpload));

        // Navigate to the file upload section by clicking on the link
        homeObject.openFileUpload();
        
        // Instantiate FileUploadPage object using driver from TestBase
        fileUploadObject = new FileUploadPage(driver);

        // Wait for file input field to be visible
        wait.until(ExpectedConditions.visibilityOf(fileUploadObject.chooseFileInput));

        // Construct absolute file path based on relative path from properties
        String absoluteFilePath = Paths.get(System.getProperty("user.dir"), relativeFilePath).toString();
        
        // Upload file using the constructed absolute file path
        fileUploadObject.uploadFile(absoluteFilePath);

        // Wait for confirmation message to be visible
        wait.until(ExpectedConditions.visibilityOf(fileUploadObject.confirmationMessage));

        // Assertion to verify that the confirmation message indicates successful upload
        Assert.assertEquals(fileUploadObject.confirmationMessage.getText(), "File Uploaded!");
        
        // Take a screenshot after successful file upload (uncomment when needed)
        // ScreenshotUtil.captureScreenshot(driver, "SuccessfulFileUpload");
    }
}
