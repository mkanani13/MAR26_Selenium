package riteshMali.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import riteshMali.base.BrowserActions;
import riteshMali.pages.FindFoodPage;
import riteshMali.pages.LoginPage;
import riteshMali.pages.RestaurantMenuePage;

public class tc_2 {

    @BeforeClass
    void startup() {
        LoginPage loginpage = new LoginPage();
        loginpage.doLogin();
    }

    @Test
    void verifyRestaurantDetails() {
        System.out.println("Step - select restaurant from location dropdown");
        FindFoodPage findfoodpage = new FindFoodPage();
        findfoodpage.setLocationInDropdown("Baner");

        System.out.println("Get the first restaurant name having dishes");
        String restaurantName = findfoodpage.getFirstRestaurantHavingDishes();
        ;

        System.out.println("Step - Click on click and view order");
        findfoodpage.clickOnViewOrder(restaurantName);

        RestaurantMenuePage restaurantMenuePage = new RestaurantMenuePage();
        restaurantMenuePage.waitPageLoad();

        System.out.println("Verify - Navigated to selected restaurant");
        String restaurantMenu_RestaurantName = restaurantMenuePage.getRestaurantName();
        Assert.assertEquals(restaurantMenu_RestaurantName, restaurantName);

//    @AfterClass
//    void tearDown(){
//        BrowserActions.quitBrowser();
//    }

    }
}
