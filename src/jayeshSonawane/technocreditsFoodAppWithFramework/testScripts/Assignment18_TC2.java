package jayeshSonawane.technocreditsFoodAppWithFramework.testScripts;

import jayeshSonawane.technocreditsFoodAppWithFramework.base.BrowserActions;
import jayeshSonawane.technocreditsFoodAppWithFramework.pages.AccessPage;
import jayeshSonawane.technocreditsFoodAppWithFramework.pages.ChooseApplicationPage;
import jayeshSonawane.technocreditsFoodAppWithFramework.pages.FindFoodBasedOnLocalityPage;
import jayeshSonawane.technocreditsFoodAppWithFramework.pages.SignInPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment18_TC2 {

    @BeforeMethod
    public void setup(){
        BrowserActions.start("http://34.66.197.232/#/access");

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

    @Test
    public void assignment18_TC2() {

        FindFoodBasedOnLocalityPage findFoodBasedOnLocalityPage = new FindFoodBasedOnLocalityPage();
        findFoodBasedOnLocalityPage.waitForPageLoad();
        findFoodBasedOnLocalityPage.selectLocalityFromDropdown("Baner");
        // Identify the first restaurant in the list that has at least one available dish (non-zero dish count) within the selected locality (Balance Brew Cafe).
        // (//p[not(contains(text(),'0 dishes'))][1])[1]/preceding-sibling::h3/parent::div/parent::div/following-sibling::a
    }

    @AfterMethod
    public void tearDown(){
        // BrowserActions.close();
    }
}
