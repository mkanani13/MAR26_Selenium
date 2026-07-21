package raghunathMate.puneFoodDelivery.testPageLayer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import raghunathMate.puneFoodDelivery.pageLayer.FoodOrderPage;
import raghunathMate.puneFoodDelivery.pageLayer.LoginPage;
import raghunathMate.puneFoodDelivery.testBase.BrowserAction;

public class TC_ORD_01 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.out.println("Step-1 : Open the application URL in the browser.");
        BrowserAction.start();
    }

    @Test
    public void verifyPlacingOrder() {
        System.out.println("Step-2_3_4 : Go to the login page and login with valid customer.");
        LoginPage loginpage = new LoginPage();
        loginpage.loginToApplication();
        System.out.println("Step-5 : verify user name is visible at expected position.");
        FoodOrderPage foodorderpage = new FoodOrderPage();
        foodorderpage.userNameVisibilityCheck();
        System.out.println("Step-6 : Selecting Kothrud from dropdown.");
        foodorderpage.selectLocationFromDropDown("Kothrud");
        System.out.println("Step-7 : Open the restaurant Abhishek Pure Veg");
        foodorderpage.selectRestraurant("Abhishek Pure Veg");
        System.out.println("Step-8 : Add one in-stock dish to the cart.");
        //foodorderpage.placeOrderWhichStockShouldBeNonZero();
        System.out.println("Step - applied coupon.");
        foodorderpage.appliedDiscountCoupon("SAVE20 — 20% off · 8 uses left");
        //foodorderpage.appliedDiscountCoupon("No coupon");
        System.out.println("SteP-9_10. Verify the order totals show a non-zero subtotal and verifying payable and discount");
        foodorderpage.subTotalAndPayableVerification();
    }

    @AfterMethod

    public void tearDown() {
        driver.quit();
    }
}
