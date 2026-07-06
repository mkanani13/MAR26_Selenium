package jayeshSonawane.technocreditsFoodAppWithFramework.testScripts;

import jayeshSonawane.technocreditsFoodAppWithFramework.base.BrowserActions;
import jayeshSonawane.technocreditsFoodAppWithFramework.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment19_TC3 {

    @BeforeMethod
    public void setup() {
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
    public void verifyOrderDelivered(){

        FindFoodPage findFoodPage = new FindFoodPage();
        findFoodPage.waitForPageLoad();

        System.out.println("STEP - Verify that the logged-in user's name is displayed in the top navigation bar.");
        MyProfilePage  myProfilePage = new MyProfilePage();
        myProfilePage.clickOnMyProfilePage();
        myProfilePage.waitforPageLoad();
        String expectedUserName = myProfilePage.getUserName();

        findFoodPage.clickOnFindFoodPage();
        findFoodPage.waitForPageLoad();
        String actualUserName = findFoodPage.getUserName();
        Assert.assertEquals(actualUserName, expectedUserName);

        String locality = "Baner";
        System.out.println("STEP - From the Locality dropdown, select " + locality);
        FindFoodBasedOnLocalityPage findFoodBasedOnLocalityPage = new FindFoodBasedOnLocalityPage();
        findFoodBasedOnLocalityPage.waitForPageLoad();
        findFoodBasedOnLocalityPage.selectLocalityFromDropdown(locality);
        System.out.println("STEP - Identify the first restaurant in the list that has at least one available dish (non-zero dish count) within " + locality + " and Click View & Order");
        String restaurantName = findFoodBasedOnLocalityPage.selectFirstRestaurantWithAvailability();

        System.out.println("From the restaurant menu, locate the first food item whose Stock value is greater than 0 and increase its quantity by clicking the Qty Up Arrow by one(1) time.");
        FindFoodMenuPage findFoodMenuPage = new FindFoodMenuPage();
        findFoodMenuPage.waitForPageLoad();
        findFoodMenuPage.addInStockItemIntoCart(1);
        System.out.println("STEP - Select Coupon");
        String couponCode = "PUNE50";
        findFoodMenuPage.selectCoupon(couponCode);
        double subTotal = findFoodMenuPage.getSubTotal();
        double discount = findFoodMenuPage.getDiscount();
        double payable = findFoodMenuPage.getPayable();
        Assert.assertTrue(subTotal > 0, "Sub-Total value must be greater than 0");
        Assert.assertEquals(subTotal, findFoodMenuPage.expectedSubTotal(), "Verify SubTotal");
        Assert.assertEquals(discount, findFoodMenuPage.expectedDiscount(), "Verify Discount");
        Assert.assertEquals(payable, findFoodMenuPage.expectedPayable(), "Verify Payable");
        System.out.println("STEP - Click on Proceed to Checkout");
        findFoodMenuPage.clickOnProceedToCheckoutButton();

        FindFoodCheckoutPage findFoodCheckoutPage = new FindFoodCheckoutPage();
        findFoodCheckoutPage.waitForPageLoad();
        Assert.assertTrue(findFoodCheckoutPage.verifyRestaurant(restaurantName));
        Assert.assertEquals(subTotal, findFoodCheckoutPage.getSubTotal());
        System.out.println("STEP - Enter Valid Delivery Address and Contact Mobile Number");
        findFoodCheckoutPage.enterDeliveryDetails("Wakad","9730287487");
        System.out.println("STEP - Click on Continue to Payment");
        findFoodCheckoutPage.clickOnContinueToPaymentButton();


    }

    @AfterMethod
    public void tearDown() {
//        BrowserActions.close();
    }

}
