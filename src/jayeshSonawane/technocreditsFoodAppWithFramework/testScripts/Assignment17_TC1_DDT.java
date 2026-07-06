package jayeshSonawane.technocreditsFoodAppWithFramework.testScripts;

import jayeshSonawane.technocreditsFoodAppWithFramework.base.BrowserActions;
import jayeshSonawane.technocreditsFoodAppWithFramework.pages.*;
import jayeshSonawane.technocreditsFoodAppWithFramework.utility.MyExcelOperationsUtility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Assignment17_TC1_DDT {

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

    // DataProvider always returns 2D Array
    @DataProvider(name = "testData")
    public static Object[][] getData() throws IOException {
        List<Map<String, String>> testData = MyExcelOperationsUtility.readExcel("D:\\Work\\Automation Testing (Java+Selenium)\\Intelli_J\\MAR26_Selenium\\src\\jayeshSonawane\\technocreditsFoodAppWithFramework\\testData\\mar26-data-driven.xlsx","Sheet1");
        /* testData
                 |<------------------------------------------------------------Column1---------------------------------------------------------------------------------------------------->|
        Row 1 = [{restaurantname=Balance Brew Cafe, qnty=5, cashOnDelivery=true, locality=Baner, fooditem=Cold Brew Coffee, placeOrderAddress=Aundh, paymentMethod=UPI, mobileNo=8950714840},
        Row 2 =  {restaurantname=Starbucks Cafe, qnty=6, cashOnDelivery=false, locality=Koregaon Park, fooditem=Fries, placeOrderAddress=Wakad, paymentMethod=Card, mobileNo=8976451230},
        Row 3 =  {restaurantname=The Shahar, qnty=9, cashOnDelivery=true, locality=Hadapsar, fooditem=Alfredo pasta, placeOrderAddress=Hinjewadi, paymentMethod=Net, mobileNo=6451238970}    ]
         */
        Object objData[][] = new Object[testData.size()][1];

        // Store Data from List of Map into 2D Array
        for (int i = 0; i < testData.size(); i++) {
            objData[i][0] = testData.get(i);
        }

        return objData;
    }

    public static void main(String[] args) throws IOException {
        getData();
    }

    @Test(dataProvider = "testData")
    public void verifyPlaceOrderFeature(Map<String, String> data) {
        System.out.println("STEP - Verify that the logged-in user's name is displayed in the top navigation bar.");
        FindFoodPage findFoodPage = new FindFoodPage();
        findFoodPage.waitForPageLoad();
        Assert.assertTrue(findFoodPage.verifyLoggedInUser(), "STEP - Verify that the logged-in user's name is displayed in the top navigation bar.");

        String expectedLocality = data.get("locality");
        System.out.println("STEP - From the locality dropdown, select " + expectedLocality);
        findFoodPage.clickOnFindFoodPage();
        findFoodPage.waitForPageLoad();

        FindFoodBasedOnLocalityPage findFoodBasedOnLocalityPage = new FindFoodBasedOnLocalityPage();
        String actualLocality = findFoodBasedOnLocalityPage.selectLocalityFromDropdown(expectedLocality);
        Assert.assertEquals(actualLocality, expectedLocality);

        String expectedRestaurantName = data.get("restaurantname");
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
        int quantity = Integer.valueOf(data.get("qnty"));
        int itemAdded = findFoodMenuPage.addInStockItemIntoCart(quantity);
        // int itemAdded = findFoodMenuPage.addInStockItemIntoCart(fooditem, quantity);
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
        findFoodOrderSummary.enterDeliveryDetails(data.get("placeOrderAddress"), data.get("mobileNo"));
        System.out.println("Click on Continue to Payment");
        findFoodOrderSummary.clickOnContinueToPaymentButton();

        FindFoodPaymentPage findFoodPaymentPage = new FindFoodPaymentPage();
        findFoodPaymentPage.waitForPageLoad();

        if (data.get("paymentMethod").equals("UPI")) {
            System.out.println("STEP - Pay Using UPI");
            findFoodPaymentPage.payUsingUPI();
        } else {
            System.out.println("STEP - Pay Using UPI as Card and Net Payment Options Currently Unavailable");
            findFoodPaymentPage.payUsingUPI();
        }

        System.out.println("STEP - Click on Place Order Button");
        findFoodPaymentPage.clickOnPlaceOrderButton();

        System.out.println("STEP - Check Order is Placed Successfully");
        MyOrdersOrderPlacedPage myOrdersOrderPlacedPage = new MyOrdersOrderPlacedPage();
        myOrdersOrderPlacedPage.waitForPageLoad();
        Assert.assertTrue(myOrdersOrderPlacedPage.isOrderPlaced());
        List<String> orderDetails = myOrdersOrderPlacedPage.getOrderDetails();
        System.out.println("Order Number = " + orderDetails.get(0));
        System.out.println("Amount Paid = " + orderDetails.get(1));
        System.out.println("Payment Mode = " + orderDetails.get(2));
    }

    @AfterMethod
    public void tearDown(){
        // BrowserActions.close();
    }
}
