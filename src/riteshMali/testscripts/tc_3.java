package riteshMali.testscripts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import riteshMali.pages.*;
import riteshMali.utility.DateTimeUtility;

public class tc_3 {

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

        System.out.println("Get first dish");
        String dish = restaurantMenuePage.getFIrstAvailableDish();

        System.out.println("Step - From the restaurant menu, locate the first food item whose Stock value is greater than 0 and increase its quantity by clicking the Qty Up Arrow.");
        restaurantMenuePage.setQuantityOfGivenDish(dish, 2);

        System.out.println("Step - Verify that the dubtotal is greater than 0");
        String subTotalText = restaurantMenuePage.getSubTotal();
        Assert.assertNotEquals(subTotalText, "₹0.00");

        System.out.println("Step - Click to proceed to checkout button");
        restaurantMenuePage.clickOnProceedToCheckout();

        OrderSummary_CheckoutPage orderSummaryCheckoutPage = new OrderSummary_CheckoutPage();
        orderSummaryCheckoutPage.waitForPAgeLoad();
        System.out.println("In the delivery details section, Enter valid delivery address.");
        orderSummaryCheckoutPage.setDeliveryAddress("Wakad");

        System.out.println("Enter a valid mobile number");
        orderSummaryCheckoutPage.setPhoneNo("7218997651");

        System.out.println("Step - Get total payabale amount");
        String orderSummaryTotalPayableAmount = orderSummaryCheckoutPage.getTotalPayableAmount();

        System.out.println("Click on continue to payment button");
        orderSummaryCheckoutPage.clickOnContinueToPaymentBtn();

        PaymentPage paymentPage = new PaymentPage();
        paymentPage.waitForPageLoad();
        System.out.println("Capture total payable in payment section");
        String paymentSummaryTotalPayableAmt = paymentPage.getTotalPayable();

        System.out.println("VERIFY - that the amount displayed in the Payable section of the Order Summary screen matches the amount displayed in the Total Payable section of the Bill screen.");
        Assert.assertEquals(paymentSummaryTotalPayableAmt, orderSummaryTotalPayableAmount);

        System.out.println("STEP - Click on Pay & Place Order");
        paymentPage.clickOnPayPlaceOrderBtn();

        System.out.println("VERIFY - Confirm the capta error notification displayed");
        boolean captaFlag = paymentPage.isErrorCaptaDisplayed();
        Assert.assertTrue(captaFlag);

        System.out.println("STEP - Click on Capta checkbox");
        paymentPage.clickOnCaptaCheckbox();

        System.out.println("STEP - Click on Pay & Place Order");
        paymentPage.clickOnPayPlaceOrderBtn();

//        System.out.println("VERIFY - Confirm the UPI ID error notification displayed");
//        boolean upiFlag = paymentPage.isUPIIdErrorNotificationDisplayed();
//        Assert.assertTrue(upiFlag);

        System.out.println("STEP - Enter a valid UPI ID in the payment field.");
        paymentPage.setUPIId("rmali@okhdfcbank");

        System.out.println("STEP - Click on Pay & Place Order");
        paymentPage.clickOnPayPlaceOrderBtn();
        String expectetOrderDateTime = DateTimeUtility.getCurrentDateTime();

        OrderSuccessPage orderSuccessPage = new OrderSuccessPage();
        SoftAssert softAssert = new SoftAssert();
//
//        System.out.println("VERIFY - Order Placed text is displayed");
//        boolean orderFlag = orderSuccessPage.isOrderPlacedDisplayed();
//        softAssert.assertTrue(orderFlag);

        System.out.println("VERIFY - Restaurant Details");
        String orderSummaryPage_restuarantName = orderSuccessPage.getRestaurantName();
        softAssert.assertEquals(orderSummaryPage_restuarantName, restaurantName);

        System.out.println("VERFIY - Amount Paid");
        String orderSummaryPage_amountPaid = orderSuccessPage.getAmtPaid();
        softAssert.assertEquals(orderSummaryPage_amountPaid, paymentSummaryTotalPayableAmt);

        System.out.println("VERIFY - Order id format is as expected");
        String orderSummaryPage_orderId = orderSuccessPage.getOrderNumber();
        softAssert.assertTrue(orderSummaryPage_orderId.startsWith("ORDER#"));

        System.out.println("VERIFY - Payment Method (Paid Via)");
        String orderSummaryPage_paymentMethod = orderSuccessPage.getPaymentMode();
        softAssert.assertEquals(orderSummaryPage_paymentMethod, "UPI");
        softAssert.assertAll();

        System.out.println("Step - Click on track order");
        orderSuccessPage.clickOnTrackOrder();

        OrderTrackSummary orderTrackSummary = new OrderTrackSummary();
        orderTrackSummary.switchToTrackOrderDetails();

    }
}
