package jayeshSonawane.technocreditsFoodAppWithFramework.testScripts;

import jayeshSonawane.technocreditsFoodAppWithFramework.base.BrowserActions;
import jayeshSonawane.technocreditsFoodAppWithFramework.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment17_TC1 {

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
    public void verifyPlaceOrderFeature(){
        System.out.println("STEP - Verify that the logged-in user's name is displayed in the top navigation bar.");
        FindFoodPage findFoodPage = new FindFoodPage();
        findFoodPage.waitForPageLoad();
        Assert.assertTrue(findFoodPage.verifyLoggedInUser(), "STEP - Verify that the logged-in user's name is displayed in the top navigation bar.");

        String expectedLocality = "Kothrud";
        System.out.println("STEP - From the locality dropdown, select " + expectedLocality);
        findFoodPage.clickOnFindFoodPage();
        findFoodPage.waitForPageLoad();

        FindFoodBasedOnLocalityPage findFoodBasedOnLocalityPage = new FindFoodBasedOnLocalityPage();
        String actualLocality = findFoodBasedOnLocalityPage.selectLocalityFromDropdown(expectedLocality);
        Assert.assertEquals(actualLocality, expectedLocality);

        String expectedRestaurantName = "Abhishek Pure Veg";
        System.out.println("STEP - Open the restaurant " + expectedRestaurantName + " and Click on View & Order");
        findFoodBasedOnLocalityPage.waitForPageLoad(expectedRestaurantName);
        String restaurantName = findFoodBasedOnLocalityPage.getRestaurantName(expectedRestaurantName);
        Assert.assertEquals(restaurantName, expectedRestaurantName, "STEP - Open the restaurant " + expectedRestaurantName + " and Click on View & Order");
        findFoodBasedOnLocalityPage.selectRestaurant(restaurantName);

        System.out.println("STEP - Add any available (in-stock) dish to the shopping cart.");
        FindFoodMenuPage findFoodMenuPage = new FindFoodMenuPage();
        findFoodMenuPage.waitForPageLoad();
        System.out.println("Verify Restaurant");
        String actualRestaurantName = findFoodMenuPage.getRestaurantName();
        Assert.assertEquals(actualRestaurantName, restaurantName, "Verify Restaurant");
        int quantity = 2;
        int itemAdded = findFoodMenuPage.addInStockItemIntoCart(quantity);
        Assert.assertEquals(itemAdded, quantity, "Verify Quantity");

        System.out.println("STEP - Verify that the cart displays a subtotal greater than zero.");
        Double subTotal = findFoodMenuPage.getSubTotal();
        Assert.assertTrue(subTotal > 0, "STEP - Verify that the cart displays a subtotal greater than zero.");
        System.out.println("Click on Proceed to Checkout");
        findFoodMenuPage.clickOnProceedToCheckoutButton();

        System.out.println("STEP - Enter a valid delivery address and mobile number.");
        FindFoodCheckoutPage findFoodOrderSummary = new FindFoodCheckoutPage();
        findFoodOrderSummary.waitForPageLoad();
        System.out.println("Verify Restaurant");
        Assert.assertTrue(findFoodOrderSummary.verifyRestaurant(restaurantName));
        System.out.println("Verify Subtotal");
        Double currentSubTotal = findFoodOrderSummary.getSubTotal();
        Assert.assertEquals(currentSubTotal, subTotal, "Verify Subtotal");
        findFoodOrderSummary.enterDeliveryDetails("Wakad", "9876543210");
        System.out.println("Click on Continue to Payment");
        findFoodOrderSummary.clickOnContinueToPaymentButton();

        FindFoodPaymentPage findFoodPaymentPage = new FindFoodPaymentPage();
        findFoodPaymentPage.waitForPageLoad();
        System.out.println("STEP - Pay Using UPI");
        findFoodPaymentPage.payUsingUPI();
        System.out.println("STEP - Click on Place Order Button");
        findFoodPaymentPage.clickOnPlaceOrderButton();

        System.out.println("STEP - Check Order is Placed Successfully");
        MyOrdersOrderPlacedPage myOrdersOrderPlacedPage = new MyOrdersOrderPlacedPage();
        myOrdersOrderPlacedPage.waitForPageLoad();
        Assert.assertTrue(myOrdersOrderPlacedPage.isOrderPlaced());


    }

    @AfterMethod
    public void closeBrowser(){
        //BrowserActions.close();
    }


}
