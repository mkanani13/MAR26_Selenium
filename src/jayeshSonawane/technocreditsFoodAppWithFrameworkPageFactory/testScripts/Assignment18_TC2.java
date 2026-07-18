package jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.testScripts;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment18_TC2 {

//    @BeforeMethod
//    public void setup(){
//        BrowserActions.start("http://34.66.197.232/#/access");
//
//        AccessPage accessPage = new AccessPage();
//        accessPage.waitForPageLoad();
//
//        accessPage.continueToLogin("F248JK5SK6", "B6FVNRUZ");
//
//        ChooseApplicationPage chooseApplicationPage = new ChooseApplicationPage();
//        chooseApplicationPage.waitForPageLoad();
//        chooseApplicationPage.clickOnSignIntoFoodApp();
//
//        SignInPage signInPage = new SignInPage();
//        signInPage.waitForPageLoad();
//        signInPage.doSignIn("user@technocredits.com", "User@123");
//    }

    @Test
    public void assignment18_TC2() {

        FindFoodBasedOnLocalityPage findFoodBasedOnLocalityPage = new FindFoodBasedOnLocalityPage();
        findFoodBasedOnLocalityPage.waitForPageLoad();
        findFoodBasedOnLocalityPage.selectLocalityFromDropdown("Baner");
        System.out.println("STEP - Identify the first restaurant in the list that has at least one available dish (non-zero dish count) within the selected locality (Balance Brew Cafe)");
        String restaurantName = findFoodBasedOnLocalityPage.selectFirstRestaurantWithAvailability();
        String expectedRestaurantName = "Balance Brew Cafe";
        Assert.assertEquals(restaurantName, expectedRestaurantName);

        FindFoodMenuPage  findFoodMenuPage = new FindFoodMenuPage();
        findFoodMenuPage.waitForPageLoad();
        findFoodMenuPage.addInStockItemIntoCart(2);

    }

//    @AfterMethod
//    public void tearDown(){
//        // BrowserActions.close();
//    }
}
