
# RESTAssuredAppiumCucumberFramework

 
RESTAssuredAppiumCucumberFramework - Appium and REST Assured test automation framework with Page Object Model design using Java + Cucumber + Maven + TestNG. Framework follows many of the industry best practices and supports Android, iOS and Rest API testing in a single code base.






## Technologies /Tools used in building the framework 

- IntelliJ - IDE 
- Appium - Mobile Automation library 
- Maven - Build automation tool 
- Java - Programming language 
- Cucumber - BDD 
- Gherkin - DSL 
- TestNG - Test Management library 
- Log4J - Logging framework 
- Extent Reports - Reporting framework 
- JSON - Test Data 
- GitHub - Version control

## How to Run Project


- Download the code from Git 
- Try to use IntelliJ as I have used the same
- Build the maven project
- Used Java version/compiler - Java 15
- Please install the Android Studio for android device emulator
- Create two Android emulator first one Pixel 4 using Android 12 and Second one Pixel 5 using Android 5.32
- Verify that all the dependencies are downloaded properly
- To run the Mobile Automation Please use testing xml – mobileRun.xml
- To run the Rest API Automation Please use testing xml – restAssured.xml
- Once the tests are completed one can view the test run status in the below folder for mobile automation. Folder: \target\Pixel4\cucumber and \target\Pixel5\cucumber
- Once the tests are completed one can view the test run status in the below folder for RestAssured .  Folder : \target\RestAPI\cucumber

    
## Running Tests

To run tests, run the following command

```bash
  mvn test
```

