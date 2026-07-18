package technocredits.technoapp.testscripts;

import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import technocredits.technoapp.base.BrowserActions;
import technocredits.technoapp.constant.FilePaths;
import technocredits.technoapp.pages.LoginPage;
import technocredits.technoapp.utility.PropertyOperations;

public class TestBase {

    PropertyOperations configProperty = new PropertyOperations(FilePaths.CONFIG_FILE_PATH);

    @BeforeMethod
    public void setup() {
        BrowserActions.start(configProperty.getValue("URL"));
        LoginPage loginPage = new LoginPage();
        loginPage.doLogin();
    }

    //    @AfterMethod
    public void tearDown(ITestResult result) {
        String methodName = result.getMethod().getMethodName();

        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Test case failed..!");
            BrowserActions.takeScreenshot(methodName + "_failed_method");
        }

//        if (result.isSuccess()) {
//            System.out.println("Test Execution Done Properly");
//        } else {
//            System.out.println("Test Execution Closed unexpectedly");
//        }

        System.out.println("Execution Done...!");
        BrowserActions.quitBrowser();
    }
}
