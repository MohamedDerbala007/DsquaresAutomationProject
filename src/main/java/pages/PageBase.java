package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * PageBase class provides common methods and actions that can be used by other page classes.
 * It serves as a base class for all page objects.
 */
public class PageBase 
{
    protected WebDriver driver;
    public JavascriptExecutor jse;
    public Select select;
    public Actions action;
    
    /**
     * Constructor to initialize the web driver and page factory elements.
     * 
     * @param driver WebDriver instance to interact with the web browser.
     */
    public PageBase (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    /**
     * Clicks on a specified button element.
     * 
     * @param button WebElement representing the button to be clicked.
     */
    protected static void clickButton(WebElement button)
    {
        button.click();
    }
    
    /**
     * Sets text in a specified text box element.
     * 
     * @param textElement WebElement representing the text box.
     * @param value String value to be entered into the text box.
     */
    protected static void setTextInElementTextBox(WebElement textElement , String value)
    {
        textElement.sendKeys(value);
    }
    
    /**
     * Scrolls the web page to the bottom.
     */
    public void scrollToButtom()
    {
        jse.executeScript("scrollBy(0,2500)");
    }
    
    /**
     * Clears text from a specified text box element.
     * 
     * @param textElement WebElement representing the text box to be cleared.
     */
    protected static void clearText(WebElement textElement)
    {
        textElement.clear();
    }
}
