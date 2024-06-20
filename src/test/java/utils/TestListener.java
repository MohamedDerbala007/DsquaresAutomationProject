package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import tests.TestBases.TestBase;

import java.io.File;

/**
 * TestListener class implements the TestNG ITestListener interface to capture screenshots
 * on test success and failure events.
 */
public class TestListener implements ITestListener {

    /**
     * This method runs when a test method starts.
     *
     * @param result Information about the currently running test.
     */
    @Override
    public void onTestStart(ITestResult result) {
        // Do nothing
    }

    /**
     * This method runs when a test method successfully completes.
     *
     * @param result Information about the successfully completed test.
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((TestBase) testClass).getDriver();

        // Generate a unique name for the success screenshot
        String successScreenshotName = result.getName() + "_Success_";
        
        // Capture screenshot and save it
        ScreenshotUtil.captureScreenshot(driver, successScreenshotName);

        // Prepare HTML code to display the success screenshot in the TestNG report
        String screenshotPath = "screenshots/" + successScreenshotName + ".png";
        String screenshotAbsolutePath = new File(screenshotPath).getAbsolutePath();
        String html = "<a href='file:///" + screenshotAbsolutePath + "'> <img src='file:///" + screenshotAbsolutePath + "' height='100' width='100'/> </a>";
        
        // Log the screenshot HTML into the TestNG report
        Reporter.log(html);
    }

    /**
     * This method runs when a test method fails.
     *
     * @param result Information about the failed test.
     */
    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((TestBase) testClass).getDriver();

        // Generate a unique name for the failure screenshot
        String failureScreenshotName = result.getName() + "_Failure";
        
        // Capture screenshot and save it
        ScreenshotUtil.captureScreenshot(driver, failureScreenshotName);

        // Prepare HTML code to display the failure screenshot in the TestNG report
        String screenshotPath = "screenshots/" + failureScreenshotName + ".png";
        String screenshotAbsolutePath = new File(screenshotPath).getAbsolutePath();
        String html = "<a href='file:///" + screenshotAbsolutePath + "'> <img src='file:///" + screenshotAbsolutePath + "' height='100' width='100'/> </a>";
        
        // Log the screenshot HTML into the TestNG report
        Reporter.log(html);
    }

    /**
     * This method runs when a test method is skipped.
     *
     * @param result Information about the skipped test.
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        // Do nothing
    }

    /**
     * This method runs when a test method fails within success percentage.
     *
     * @param result Information about the failed test within success percentage.
     */
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Do nothing
    }

    /**
     * This method runs before any test methods are run.
     *
     * @param context Information about the test context.
     */
    @Override
    public void onStart(ITestContext context) {
        // Do nothing
    }

    /**
     * This method runs after all test methods have been run.
     *
     * @param context Information about the test context.
     */
    @Override
    public void onFinish(ITestContext context) {
        // Do nothing
    }
}
