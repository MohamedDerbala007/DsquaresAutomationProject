package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * DynamicLoadingPage class represents the dynamic loading page of the application.
 * It provides methods to interact with elements on the dynamic loading page.
 */
public class DynamicLoadingPage extends PageBase
{

    /**
     * Constructor to initialize the web driver and page factory elements.
     * 
     * @param driver WebDriver instance to interact with the web browser.
     */
    public DynamicLoadingPage(WebDriver driver) 
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // WebElements identified by their link text
    @FindBy(linkText = "Example 1: Element on page that is hidden")
    // Alternative locator: @FindBy(xpath = "//*[@id=\"content\"]/div/a[1]")
    public WebElement example1;

    @FindBy(linkText = "Example 2: Element rendered after the fact")
    // Alternative locator: @FindBy(xpath = "//*[@id=\"content\"]/div/a[2]")
    public WebElement example2;
    
    /**
     * Clicks on the link for "Example 2: Element rendered after the fact".
     */
    public void clickOnExample2()
    {
        clickButton(example2);
    }
}
