package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * FileUploadPage class represents the file upload page of the application.
 * It provides methods to interact with elements on the file upload page.
 */
public class FileUploadPage extends PageBase
{
	/**
	 * Constructor to initialize the web driver and page factory elements.
	 * 
	 * @param driver WebDriver instance to interact with the web browser.
	 */
	public FileUploadPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// WebElements identified by their ID
	@FindBy(id = "file-upload")
	public WebElement chooseFileInput;

	@FindBy(id = "file-submit")
	public WebElement uploadBtn;

	// WebElement identified by tag name
	@FindBy(tagName = "h3")
	public WebElement confirmationMessage;

	/**
	 * Uploads a file by setting the file path in the file input element and clicking the upload button.
	 * 
	 * @param filePath The path of the file to be uploaded.
	 */
	public void uploadFile(String filePath) 
	{
		chooseFileInput.sendKeys(filePath);
		clickButton(uploadBtn);
	}
}
