package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * HomePage class represents the home page of the application.
 * It provides methods to interact with elements on the home page.
 */
public class HomePage extends PageBase
{
    /**
     * Constructor to initialize the web driver and page factory elements.
     * 
     * @param driver WebDriver instance to interact with the web browser.
     */
    public HomePage(WebDriver driver) 
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // WebElements identified by their XPath or link text
    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[18]/a")
    public WebElement fileUpload;

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[14]/a")
    public WebElement dynamicLoading;
    
    /**
     * Clicks on the file upload link to navigate to the File Upload page.
     */
    public void openFileUpload()
    {
        clickButton(fileUpload);
    }
    
    /**
     * Clicks on the dynamic loading link to navigate to the Dynamic Loading page.
     */
    public void openDynamicLoading()
    {
        clickButton(dynamicLoading);
    }
}
