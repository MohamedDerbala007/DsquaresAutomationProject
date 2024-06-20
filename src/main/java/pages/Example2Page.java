package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Example2Page class represents the Example 2 page of the dynamic loading section of the application.
 * It provides methods to interact with elements on the Example 2 page.
 */
public class Example2Page extends PageBase
{

    /**
     * Constructor to initialize the web driver and page factory elements.
     * 
     * @param driver WebDriver instance to interact with the web browser.
     */
    public Example2Page(WebDriver driver) 
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    // WebElements identified by their tag name and id
    @FindBy(tagName = "button")
    public WebElement startBtn;
    
    @FindBy(id = "finish")
    public WebElement confirmationMsg;
    
    /**
     * Clicks on the start button to begin dynamic loading.
     */
    public void clickOnStartBtn()
    {
        clickButton(startBtn);
    }
}
