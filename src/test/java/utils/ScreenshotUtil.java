package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * ScreenshotUtil class provides methods to capture screenshots using Selenium WebDriver.
 * It utilizes Apache Commons IO for file handling operations.
 */
public class ScreenshotUtil {

    /**
     * Capture a screenshot of the current WebDriver instance and save it as a PNG file.
     *
     * @param driver         WebDriver instance to capture screenshot from.
     * @param screenshotName Name to assign to the captured screenshot file (without extension).
     */
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        // Convert WebDriver instance to TakesScreenshot to capture screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        try {
            // Copy the captured screenshot to the specified directory with the given name
            FileUtils.copyFile(srcFile, new File("screenshots/" + screenshotName + ".png"));
        } catch (IOException e) {
            // Print stack trace if an IOException occurs during file copy
            e.printStackTrace();
        }
    }
}
