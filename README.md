# Automation Testing Assignment

This project is an automated testing framework built using Java, Maven, Selenium WebDriver, and TestNG. It automates two specific scenarios on the website https://the-internet.herokuapp.com/.

## Project Structure

The project follows the Page Object Model (POM) design pattern to organize the test automation code into reusable and maintainable components.

### Directory Structure

```
src
├── main
│   ├── java
│   │   ├── data
│   │   │   └── LoadProperties.java
│   │   ├── pages
│   │   │   ├── DynamicLoadingPage.java
│   │   │   ├── Example2Page.java
│   │   │   ├── FileUploadPage.java
│   │   │   ├── HomePage.java
│   │   │   └── PageBase.java
│   │   └── utils
│   │       ├── ScreenshotUtil.java
│   │       └── TestListener.java
├── test
│   ├── java
│   │   ├── tests
│   │   │   ├── DynamicLoadingIsCompletedSuccessfullyTest.java
│   │   │   ├── FileIsUploadedSuccessfullyTest.java
│   │   │   └── TestBases
│   │   │       └── TestBase.java
│   └── resources
│       └── properties
│           └── config.properties
```

## Scenarios

### Scenario 1: File Upload

1. Navigate to https://the-internet.herokuapp.com/
2. Click on "File Upload"
3. Choose any image from your drive that’s less than 5 MB
4. Click on “Upload”
5. Check that the file is uploaded successfully, and the text “File Uploaded!” is displayed on the screen.

### Scenario 2: Dynamic Loading

1. Navigate to https://the-internet.herokuapp.com/
2. Click on “Dynamic Loading"
3. Click on “Example 2"
4. Click “Start”
5. Wait until loading is finished
6. Check that the text displayed is "Hello World!"

## Setup and Execution

### Prerequisites

- Java JDK 8 or higher
- Maven
- ChromeDriver (Ensure the `chromedriver.exe` is placed in the `drivers` folder)

### Running the Tests

1. Clone the repository:

```bash
git clone https://github.com/MohamedDerbala007/DsquaresAutomationProject.git
```

2. Navigate to the project directory:

```bash
cd yourrepository
```

3. Update the `config.properties` file with the path to your image file:

```
filePath=Uploads/DsquaresFile.PNG
```

4. Execute the tests using Maven:

```bash
mvn clean test
```

### Test Reports

TestNG generates test execution reports in the `test-output` directory. Screenshots of test execution (success and failure) are saved in the `screenshots` directory.

### Documentation

- **`TestBase.java`**: Sets up and tears down the WebDriver instance for tests.
- **`HomePage.java`**: Represents the home page and its interactions.
- **`FileUploadPage.java`**: Represents the file upload page and its interactions.
- **`DynamicLoadingPage.java`**: Represents the dynamic loading page and its interactions.
- **`Example2Page.java`**: Represents the Example 2 page under dynamic loading and its interactions.
- **`LoadProperties.java`**: Loads properties from the configuration file.
- **`ScreenshotUtil.java`**: Utility for capturing screenshots.
- **`TestListener.java`**: TestNG listener for handling test events and attaching screenshots to reports.
- **`DynamicLoadingIsCompletedSuccessfullyTest.java`**: Test class for the dynamic loading scenario.
- **`FileIsUploadedSuccessfullyTest.java`**: Test class for the file upload scenario.

### GitHub Repository

Earn bonus points by delivering the project as a GitHub repository. This provides version control, collaboration features, and public access.

## Contribution

Feel free to fork this repository and submit pull requests for any improvements or additional features.

## License

This project is licensed under the MIT License.

---
