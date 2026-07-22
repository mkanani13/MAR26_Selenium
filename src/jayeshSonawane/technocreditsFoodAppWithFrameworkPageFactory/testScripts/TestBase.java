package jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.testScripts;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.base.BrowserActions;
import jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.pages.AccessPage;
import jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.pages.ChooseApplicationPage;
import jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.pages.SignInPage;
import jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.utility.PropertyOperations;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    PropertyOperations propertyOperations = new PropertyOperations("src/jayeshSonawane/technocreditsFoodAppWithFrameworkPageFactory/config/config.properties");

    @BeforeMethod
    public void setup(){
//        BrowserActions.start("http://34.66.197.232/#/access");
        BrowserActions.start(propertyOperations.getValue("URL"));

        AccessPage accessPage = new AccessPage();
        accessPage.waitForPageLoad();

        accessPage.continueToLogin("F248JK5SK6", "B6FVNRUZ");

        ChooseApplicationPage chooseApplicationPage = new ChooseApplicationPage();
        chooseApplicationPage.waitForPageLoad();
        chooseApplicationPage.clickOnSignIntoFoodApp();

        SignInPage signInPage = new SignInPage();
        signInPage.waitForPageLoad();
        signInPage.doSignIn("user@technocredits.com", "User@123");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        String methodName = result.getMethod().getMethodName();

        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Test case failed..!");
            BrowserActions.takeScreenshot(methodName + "_failed_method");
        }

//        if (!result.isSuccess()) {
//            System.out.println("Test case failed..!");
//            BrowserActions.takeScreenshot(methodName + "_failed_method");
//        }
        BrowserActions.close();
    }
}
