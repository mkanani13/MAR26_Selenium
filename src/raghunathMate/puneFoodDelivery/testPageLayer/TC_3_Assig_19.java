package raghunathMate.puneFoodDelivery.testPageLayer;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import raghunathMate.puneFoodDelivery.pageLayer.*;
import raghunathMate.puneFoodDelivery.testBase.BrowserAction;
import raghunathMate.puneFoodDelivery.utility.TimeAndDateStamp;

public class TC_3_Assig_19 {

    @BeforeMethod
    public void setUp(){

        System.out.println("Step - 1.Launch the browser and navigate to http://34.66.197.232/#/restaurants");
        BrowserAction.start();

        System.out.println("Getting access for application");
        StudentAccessPage stdaccesspage = new StudentAccessPage();
        stdaccesspage.waitForPageLoad();
        stdaccesspage.getStudentAccess("35EGM7D45W", "7MNT2R2F");

        System.out.println("Verify access is granted or not");
        ChooseApplicationPage chooseapppage = new ChooseApplicationPage();
        chooseapppage.waitForPageLoad();
        chooseapppage.VerifyAccessGrantedOrNot();

        System.out.println("Selecting application");
        chooseapppage.chooseApplication();

        System.out.println("Step - 2_3_4 - Open the Login page, Enter valid customer credentials and Click the Login button");
        LoginPage loginpage = new LoginPage();
        loginpage.waitForPageLoad();
        loginpage.loginToApplication();
    }

    @Test
    public void Assignment_19() {
        SoftAssert softassert = new SoftAssert();
        System.out.println("Step - 5.Verify that the logged-in user's name is displayed in the top navigation bar.");
        FoodOrderPage foodorderpage = new FoodOrderPage();
        foodorderpage.waitPageLoad();
        foodorderpage.userNameVisibilityCheck();

        System.out.println("Step- 6.From the Locality dropdown, select Baner");
        foodorderpage.selectLocationFromDropDown("Baner");
        foodorderpage.waitPageLoad();

        System.out.println("Step - 7.Identify the first restaurant in the list that has at least one available dish (non-zero dish count) within the selected locality (Balance Brew Cafe).");
        String restraurantName = foodorderpage.getFirstRestraurantwhichHasNonZeroDish();
        System.out.println("Restraurant Name:- " + restraurantName);

        System.out.println("Step - 8.Click the View & Order button for the selected restaurant.");
        foodorderpage.selectRestraurant(restraurantName);

        System.out.println("VERIFY - Navigated to Selected Restaurant Menu");
        MenuCardPage menucardpage = new MenuCardPage();
        menucardpage.waitForPageLoad();
        String restroNameFromMenuCard = menucardpage.getRestraurantNameFromMenuCard();
        System.out.println("Restro Name From Menu Card :- " + restroNameFromMenuCard);
        softassert.assertEquals(restraurantName, restroNameFromMenuCard, "Name is not matched");

        System.out.println("Step - 9.From the restaurant menu, locate the first food item whose Stock value is greater than 0 and increase its quantity by clicking the Qty Up Arrow.");
        String dishName = menucardpage.getDishNameWhichStockShouldBeNonZero();
        System.out.println("Dish Name: " + dishName);
        menucardpage.quantityForGivenDish(dishName, 1);

        System.out.println("Step - 10.Verify that the cart Subtotal is greater than 0.");
        String subTotal = menucardpage.getSubTotal();
        System.out.println("Sub total:- " + subTotal);
        softassert.assertNotEquals(subTotal, "₹0.00", "Subtotal is equal to Zero");

        System.out.println("Step - 11.Click the Proceed to Checkout button.");
        menucardpage.clickOnProceedToCheckOutButton();

        System.out.println("Step - 12.In the Delivery Details section Enter a valid delivery address.");
        OrderSummaryPage ordersummarypage = new OrderSummaryPage();
        ordersummarypage.waitForPageLoad();
        String payableAmt = ordersummarypage.getTotalPayableAmt();
        ordersummarypage.enterDeliveryAddress("Vadgaon Budruk-411041");
        System.out.println(" Step - Enter a valid mobile number");
        ordersummarypage.enterMobileNumber("9876543210");

        System.out.println("Step-13.Click the Continue to Payment → button.");
        ordersummarypage.clickOnProceedToPaymentButton();

        System.out.println("Step - 14.Verify that the amount displayed in the Payable section of the Order Summary screen matches the amount displayed in the Total Payable section of the Bill screen.");
        PaymentPage paymentpage = new PaymentPage();
        paymentpage.waitForPageLoad();
        String totalPayableAmt = paymentpage.getPayableAmtFromBillSection();
        System.out.println("total Payable Amt:- " + totalPayableAmt);
        softassert.assertEquals(payableAmt, totalPayableAmt);

        System.out.println("VERIFY - Confirm the capta error notification displayed");
        paymentpage.clickOnPayAndPlaceOrderButton();
        boolean checkBoxErrorMsgFlag = paymentpage.isErrorMsgNotificationForWithoutClickingIamNotRobotCheckBoxProceed();
        softassert.assertTrue(checkBoxErrorMsgFlag);

        System.out.println("Step - 15.Select the I'm not a robot — confirm before paying checkbox.");
        paymentpage.clickingCheckBoxOfIAmNotRobot();

        System.out.println("VERIFY - Confirm the UPI ID error notification displayed");
        paymentpage.clickOnPayAndPlaceOrderButton();
        boolean UPIErrorMsgFlage = paymentpage.isErrorMsgForWithoutEnterUIPIdProceed();
        softassert.assertTrue(UPIErrorMsgFlage);

        System.out.println("Step - 16.Enter a valid UPI ID in the payment field.");
        paymentpage.enterUPIId("name@okhdfcBank");

        System.out.println("Step - 17.Click the Pay  & Place Order button.");
        paymentpage.clickOnPayAndPlaceOrderButton();

        System.out.println("Step - 18.Verify that the Order Placed screen is displayed and contains the following details under the Track Order section:");
        OrderSuccessPage ordersuccesspage = new OrderSuccessPage();
        ordersuccesspage.waitForPageLoad();
        ordersuccesspage.getOrderDetailsFromOrderSuccessPage();

        System.out.println("Step - get current date and time");
        String expectedDateAndTime = TimeAndDateStamp.getCurrentDateAndTime();
        System.out.println("Expected date :- " + expectedDateAndTime);


        System.out.println("Verify restraurant name from order success placed page ");
        String restoNameFromOrderSuccessPage = ordersuccesspage.getRestroNameFromOrderSuccessPage();
        softassert.assertEquals(restoNameFromOrderSuccessPage, restraurantName, "Restaurant name is not matched");

        System.out.println("Verify restaurant name from order success placed page ");
        String amtpaid = ordersuccesspage.getPaidAmtFromOrderSuccessPage();
        System.out.println("Amt paid :- " + amtpaid);

        softassert.assertEquals(amtpaid, payableAmt, "Amount is not matched");

        System.out.println("Get OrderId from order success page");
        String orderIDFromOrderSuccessPage = ordersuccesspage.getOrderId();
        System.out.println("order ID From Order Success Page :-" + orderIDFromOrderSuccessPage);

        System.out.println("Clicking track order button");
        ordersuccesspage.clickOnTrackOrderButton();

        System.out.println("Switching to track order window");
        TrackOrderPage trackorderpage = new TrackOrderPage();
        trackorderpage.switchWindow();
        trackorderpage.waitForPageLoad();

        System.out.println("getting order id fro track order page");
        String orderIdFromTrackPage = trackorderpage.getOrderIdFromTrackOrderPAge();
        System.out.println("order Id From Track Page :-"+ orderIdFromTrackPage);
    }
}
