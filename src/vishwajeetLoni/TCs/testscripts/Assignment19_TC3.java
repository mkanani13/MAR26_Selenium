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
//9.From the restaurant menu, locate the first food item whose Stock value is greater than 0 and increase its quantity by clicking the Qty Up Arrow by one(1) time.
//10.Select the "PUNE50 - 10% off.68 uses left.10% off, upto 100 uses" dropdown option.
//11.Verify that the cart Subtotal is greater than 0 equaling to the (QtyPrice) of the Selected Dish.
//12.Verify that the Discount provided is 10% of the Subtotal value.
//13.Verify that the Payable amount is equal to the difference of Subtotal and Discount. (i.e Payable = Subtotal - Discount)
//14.Click the "Proceed to Checkout →" button.
//15.In the Delivery Details section:
//-Enter a valid delivery address.
//-Enter a valid mobile number.
//16.Click the "Continue to Payment →" button.
//17.Click the "Pay  & Place Order" button.
//18.Verify that the amount displayed in the Payable section of the Order Summary screen matches the amount displayed in the Total Payable section of the Bill screen.
//19.Verify that an Alert message pop-up is displayed showing "Please confirm the captcha before paying" in red background text in the page.
//20.Enter a valid UPI ID in the payment field.
//21.Select the "I'm not a robot — confirm before paying" checkbox.
//22.Click the "Pay * & Place Order" button.
//23.Verify that the Order Placed screen is displayed and contains the following details under the Track Order section/tab:
//-Restaurant Details
//-Amount Paid
//-Order Number
//-Payment Method (Paid Via)
//24.Click on "View my orders" section/tab.
//25.Verify that the Order number of the order placed in the "Track Order" tab/section is present in the Order# column of the "View my orders" tab/section.
//26.Verify that the Amount paid displayed in the "Track Order" tab/section is same as the price displayed under the Total column for the placed "Order number" in the "View my orders" tab/section.

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vishwajeetLoni.TCs.pages.*;
import vishwajeetLoni.base.ActionOnBrowser;

import java.util.ArrayList;
import java.util.List;

public class Assignment19_TC3 {

    @BeforeMethod
    public void setup(){
        ActionOnBrowser.start("http://34.66.197.232/#/access");
        TechnoLoginPage login = new TechnoLoginPage();
        login.doLogin();
    }

    @Test //(invocationCount = 3) The test is iterated 3 times when test is run
    public void Test3() {
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

        OrderPlacedPage orderPlacedPage = new OrderPlacedPage();
        System.out.println("Wait for Order success page to load");
        orderPlacedPage.waitForPageLoad();

        System.out.println("Verify the Order placed header is displayed");
        SoftAssert softAssert = new SoftAssert();
        boolean orderFlag = orderPlacedPage.isOrderPlacedDisplayed();
        softAssert.assertTrue(orderFlag);

        System.out.println("Verify Restaurant name");
        String orderPlacedPageResName = orderPlacedPage.getRestaurantName();
        softAssert.assertEquals(orderPlacedPageResName, restaurantname);

        System.out.println("Verify Amount paid");
        String orderPlacedPageAmt = orderPlacedPage.getAmtPaid();
        softAssert.assertEquals(orderPlacedPageAmt, totalPayable);

        System.out.println("Verify Order number");
        String orderPlacedPageOrderNo = orderPlacedPage.getOrderNumber();
        softAssert.assertTrue(orderPlacedPageOrderNo.startsWith("ORDER#"));

        List<String> orderPlacedPageOrderDetailsExpected = new ArrayList<>();
        orderPlacedPageOrderDetailsExpected.add(orderPlacedPageOrderNo);
        orderPlacedPageOrderDetailsExpected.add(orderPlacedPageResName);
        orderPlacedPageOrderDetailsExpected.add(orderPlacedPageAmt);

        System.out.println("Verify Payment Method");
        softAssert.assertEquals(orderPlacedPage.getPaymentMode(), "UPI");

        softAssert.assertAll();

        System.out.println("Click on Track Order");
        orderPlacedPage.clickOnTrackOrder();

        System.out.println("Switch to track order page");
        TrackOrderPage trackOrderPage = new TrackOrderPage();
        trackOrderPage.switchToTrackOrderWindow();
        trackOrderPage.waitForPageLoad();

        System.out.println("Verify the Order Number");
        Assert.assertEquals(trackOrderPage.TrackOrderOrderNumber(), orderPlacedPageOrderNo);

        System.out.println("Verify the Amount paid");
        Assert.assertEquals(trackOrderPage.TrackOrderTotalAmt(), orderPlacedPageAmt);

        System.out.println("Verify the Restaurant name");
        Assert.assertEquals(trackOrderPage.TrackOrderRestaurantName(), orderPlacedPageResName);

//        This is same validation as above just in list format for Order no, Amt paid and Res name
        System.out.println("STEP - get order summary details");
        List<String> orderDetailsActualList = trackOrderPage.getOrderDetails();
        Assert.assertEquals(orderDetailsActualList, orderPlacedPageOrderDetailsExpected);

        System.out.println("Verify - Food delivery status and message");
        boolean deliveryStatusFlag = trackOrderPage.isOrderDelivered();
        boolean deliveryMessageFlag = trackOrderPage.isEnjoyYourMealTextPresent();
        System.out.println("Order delivery status" + deliveryStatusFlag);
        System.out.println("Order delivery message" + deliveryMessageFlag);
        Assert.assertEquals(deliveryStatusFlag,deliveryMessageFlag);

        System.out.println("Wait for food delivery");
       // trackOrderPage.waitForOrderDelivery();
        trackOrderPage.waitForOrderDelivery1();

        System.out.println("Again Verify - Food delivery status and message");

        System.out.println("Order delivery status" + deliveryStatusFlag);
        System.out.println("Order delivery message" + deliveryMessageFlag);
        Assert.assertEquals(deliveryStatusFlag,deliveryMessageFlag);

    }

}
