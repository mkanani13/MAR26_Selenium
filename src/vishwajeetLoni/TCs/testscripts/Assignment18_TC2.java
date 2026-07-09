package vishwajeetLoni.TCs.testscripts;

//1.Launch the browser and navigate to:
//http://34.173.201.53/access#/login
//2.Open the Login page.
//3.Enter valid customer credentials (Email and Password).
//4.Click the Login button.
//5.Verify that the logged-in user's name is displayed in the top navigation bar.
//6.From the Locality dropdown, select "Baner".
//7.Identify the first restaurant in the list that has at least one available dish (non-zero dish count) within the selected locality (Balance Brew Cafe).
//8.Click the "View & Order" button for the selected restaurant.
//9.From the restaurant menu, locate the first food item whose Stock value is greater than 0 and increase its quantity by clicking the Qty Up Arrow.
//10.Verify that the cart Subtotal is greater than 0.
//11.Click the "Proceed to Checkout →" button.
//12.In the Delivery Details section:
//-Enter a valid delivery address.
//-Enter a valid mobile number.
//13.Click the "Continue to Payment →" button.
//14.Verify that the amount displayed in the Payable section of the Order Summary screen matches the amount displayed in the Total Payable section of the Bill screen.
//15.Enter a valid UPI ID in the payment field.
//16.Select the "I'm not a robot — confirm before paying" checkbox.
//17.Click the "Pay  & Place Order" button.
//18.Verify that the Order Placed screen is displayed and contains the following details under the Track Order section:
//-Restaurant Details
//-Amount Paid
//-Order Number
//-Payment Method (Paid Via)
//
//19. Click on View my orders page
//20. Search order with exact id we have placed
//21. Store the details below
//-Restaurant Name
//-Total Amount Paid
//-Order Number
//-date
//-status
// verify the details from previous page

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vishwajeetLoni.TCs.pages.*;
import vishwajeetLoni.TCs.utilities.DateAndTime;
import vishwajeetLoni.base.ActionOnBrowser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Assignment18_TC2 {

    @BeforeMethod
    public void setup(){
        ActionOnBrowser.start("http://34.66.197.232/#/access");
        TechnoLoginPage login = new TechnoLoginPage();
        login.doLogin();
    }

    @Test
    public void Test2() {
        FindFoodPage findFoodPage = new FindFoodPage();
        findFoodPage.waitForPageLoad();


        System.out.println("Test - Verify username in top right corner");
        Assert.assertTrue(findFoodPage.uname().contains("vishwajeet.customer1"));

        String area = "Warje";
        System.out.println("Test - Verify the location in dropdown is selected as " + area);
        System.out.println(findFoodPage.setSingleLocationinDD(area));

        System.out.println("Name of first restaurant with more than zero dishes");
        String restaurantname = findFoodPage.RestaurantHavingDishes();
        System.out.println(restaurantname);

        System.out.println("Click on View & Order");
        findFoodPage.clickOnViewandOrder(restaurantname);

        RestaurantMenuPage restaurantMenuPage = new RestaurantMenuPage();
        restaurantMenuPage.waitForPageLoad();

        System.out.println("Verify the name of selected restuarant and landing on its Menu");
        String RestaurantMenuName = restaurantMenuPage.getRestaurantName();
        Assert.assertEquals(RestaurantMenuName, restaurantname);

        System.out.println("Get first available dish");
        String dish = restaurantMenuPage.getFirstAvailableDish();

        System.out.println("Enter the quantity and give order");
        restaurantMenuPage.setOrderQty(dish, 1);

        System.out.println("Verify cart subtotal is greater than 0");
        Assert.assertNotEquals(restaurantMenuPage.subTotal(), "₹0.00");

        System.out.println("Proceed to checkout");
        restaurantMenuPage.clickOnProceedToCheckout();

        OrderCheckoutPage orderCheckoutPage = new OrderCheckoutPage();

        System.out.println("Wait for Order Checkout page load");
        orderCheckoutPage.waitForPageLoad();

        System.out.println("Enter Address");
        orderCheckoutPage.enterAddress("Test Address");

        System.out.println("Enter Phone number");
        orderCheckoutPage.enterPhNo("1234567890");

        System.out.println("Capture Payable Amt");
        String payable = orderCheckoutPage.payableAmt();

        System.out.println("Click on Continue to payment btn");
        orderCheckoutPage.clickOnContinueToPaymentBtn();

        PaymentPage paymentPage = new PaymentPage();
        System.out.println("Wait for Payment Page load");
        paymentPage.waitForPageLoad();

        System.out.println("Capture Payable Amt");
        String totalPayable = paymentPage.totalPayableAmt();

        System.out.println("Verify the Payable amt and Total payable amt are same");
        Assert.assertTrue(totalPayable.equals(payable));

        System.out.println("Select UPI payment method");
        paymentPage.UPIclick();

        System.out.println("Click on Place order");
        paymentPage.payAndPlaceorderBtnClick();

        System.out.println("Verify if captcha error displayed");
        paymentPage.isErrorCaptaDisplayed();

        System.out.println("Enter UPI id");
        paymentPage.enterUpiId("test@tttt");

        System.out.println("Click on Place order again");
        paymentPage.payAndPlaceorderBtnClick();

        System.out.println("Verify if captcha error displayed");
        paymentPage.isErrorCaptaDisplayed();

        System.out.println("Click on checkbox");
        paymentPage.selectCaptchaCheckbox();

        System.out.println("Clear UPI id");
        paymentPage.clearUpiId();

        System.out.println("Enter UPI id");
        paymentPage.enterUpiId(" ");

        System.out.println("Click on Place order again");
        paymentPage.payAndPlaceorderBtnClick();

        System.out.println("Verify UPI id required error displayed");
        paymentPage.isUPIIdRequiredErrorDisplayed();

        System.out.println("Enter UPI id");
        paymentPage.enterUpiId("test@name");

        System.out.println("Click on Place order again");
        paymentPage.payAndPlaceorderBtnClick();

        System.out.println("STore the date and time");
        String expectedOrderDateTime = DateAndTime.getCurrentTime();

        OrderPlacedPage orderPlacedPage = new OrderPlacedPage();
        System.out.println("Wait for Order success page to load");
        orderPlacedPage.waitForPageLoad();

        System.out.println("Verify the Order placed header is displayed");
        SoftAssert softAssert = new SoftAssert();
        boolean orderFlag = orderPlacedPage.isOrderPlacedDisplayed();
        softAssert.assertTrue(orderFlag);

        System.out.println("Verify Restaurant name");
        softAssert.assertEquals(orderPlacedPage.getRestaurantName(), restaurantname);

        System.out.println("Verify Amount paid");
        String orderPlacedPageAmt = orderPlacedPage.getAmtPaid();
        softAssert.assertEquals(orderPlacedPageAmt, totalPayable);

        System.out.println("Verify Order number");
        String orderPlacedPageOrderNo = orderPlacedPage.getOrderNumber();
        softAssert.assertTrue(orderPlacedPageOrderNo.startsWith("ORDER#"));

        System.out.println("Verify Payment Method");
        softAssert.assertEquals(orderPlacedPage.getPaymentMode(), "UPI");

        softAssert.assertAll();

        System.out.println("Click on View My Orders");
        orderPlacedPage.clickOnViewMyOrder();

        MyOrdersPage myOrdersPage = new MyOrdersPage();
        myOrdersPage.waitForPageLoad();

        System.out.println("Search the order we recently placed");
        myOrdersPage.searchOrderWithExactNumber(orderPlacedPageOrderNo);

        System.out.println("STEP - get details of the order from my order table");
        Map<String, String> orderDetailsMap = myOrdersPage.getOrderDetails();

        System.out.println("Verify the Order details");

        Assert.assertEquals(orderDetailsMap.get("Order #"), orderPlacedPageOrderNo);
        Assert.assertEquals(orderDetailsMap.get("Date"),expectedOrderDateTime);
        Assert.assertTrue(orderDetailsMap.get("Restaurant").contains(restaurantname));
        Assert.assertEquals(orderDetailsMap.get("Total"),orderPlacedPageAmt);
        //Assert.assertTrue(getOrderStatusList().contains(orderDetailsMap.get("Status")));
        Assert.assertListContainsObject(getOrderStatusList(),orderDetailsMap.get("Status"),"Displayed Status was not in the list");




//        System.out.println("Click on Track Order");
//        orderPlacedPage.clickOnTrackOrder();
//
//        TrackOrderPage trackOrderPage = new TrackOrderPage();
//        trackOrderPage.waitForPageLoad();
//
//        System.out.println("Verify the Order Number");
//        Assert.assertTrue(orderPlacedPageOrderNo.equals(trackOrderPage.TrackOrderOrderNumber()));
//
//        System.out.println("Verify the Amount paid");
//        Assert.assertTrue(orderPlacedPageAmt.equals(trackOrderPage.TrackOrderTotalAmt()));

    }
    // Written here since we are hard coding
    private List<String> getOrderStatusList() {
        List<String> orderStatusList = new ArrayList<>();
        orderStatusList.add("Pending");
        orderStatusList.add("Accepted");
        orderStatusList.add("Out for Delivery");
        orderStatusList.add("Delivered");
        orderStatusList.add("Cancelled");
        return orderStatusList;
    }



}
