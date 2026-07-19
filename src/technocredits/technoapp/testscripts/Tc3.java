package technocredits.technoapp.testscripts;

import org.testng.Assert;
<<<<<<< HEAD
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import technocredits.technoapp.base.BrowserActions;
import technocredits.technoapp.pages.*;
import technocredits.technoapp.utility.DateTimeUtility;

import java.util.*;

public class Tc3 {

    @BeforeMethod
    public void setup(){
        BrowserActions.start("http://34.66.197.232/#/access");
        LoginPage loginPage = new LoginPage();
        loginPage.doLogin();
    }

    @Test
    public void verifyPlaceOrderFeature(){
=======
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import technocredits.technoapp.constant.FilePaths;
import technocredits.technoapp.pages.*;
import technocredits.technoapp.utility.DateTimeUtility;
import technocredits.technoapp.utility.ExcelOperations;
import technocredits.technoapp.utility.PropertyOperations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tc3 extends TestBase {

    PropertyOperations configProperty = new PropertyOperations(FilePaths.CONFIG_FILE_PATH);


//    @BeforeMethod
//    public void setup() {
//        BrowserActions.start(configProperty.getValue("URL"));
//        LoginPage loginPage = new LoginPage();
//        loginPage.doLogin();
//    }

    @DataProvider(name = "testData")
    public Object[][] getData() throws IOException {
        List<Map<String, String>> data = ExcelOperations.readExcel(FilePaths.TEST_DATA_EXCEL_FILE_PATH, "Sheet1");
        Object objData[][] = new Object[data.size()][1];

        for (int i = 0; i < data.size(); i++)
            objData[i][0] = data.get(i);

        return objData;
    }

    @Test(dataProvider = "testData")
    public void verifyPlaceOrderFeature(Map<String, String> data) {
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe
        FindFoodPage findFoodPage = new FindFoodPage();
        findFoodPage.waitForPageLoad();

        System.out.println("STEP - Select location as Baner");
        findFoodPage.setLocationInDropdown("Baner");

        System.out.println("Get the name of the first restaurant having dishes");
        String restaurantName = findFoodPage.getFirstRestaurantNameHavingDishes();
        System.out.println(restaurantName);

        System.out.println("STEP - Click on View & Order of the restaurants having dishes");
        findFoodPage.clickOnViewOrder(restaurantName);

        RestauarantMenuPage restauarantMenuPage = new RestauarantMenuPage();
        restauarantMenuPage.waitForPage();

        System.out.println("VERIFY - Navigated to Selected Restaurant Menu");
        String restaurantMenu_RestaurantName = restauarantMenuPage.getRestaurantName();
        Assert.assertEquals(restaurantMenu_RestaurantName, restaurantName);

        System.out.println("Get first available dish");
        String dish = restauarantMenuPage.getFirstAvailableDish();

        System.out.println("STEP - From the restaurant menu, locate the first food item whose Stock value is greater than 0 and increase its quantity by clicking the Qty Up Arrow.");
<<<<<<< HEAD
        restauarantMenuPage.setQuantityOfGivenDish(dish,2);
=======
        restauarantMenuPage.setQuantityOfGivenDish(dish, 2);
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe

        System.out.println("VERIFY - that the cart Subtotal is greater than 0.");
        String subTotalText = restauarantMenuPage.getSubTotal();
        Assert.assertNotEquals(subTotalText, "₹0.00");

        System.out.println("STEP - Click the Proceed to Checkout → button.");
        restauarantMenuPage.clickOnProceedToCheckout();

        OrderSummary_CheckoutPage orderSummaryCheckoutPage = new OrderSummary_CheckoutPage();
        orderSummaryCheckoutPage.waitForPageLoad();

        System.out.println("STEP - In the Delivery Details section, Enter a valid delivery address.");
        orderSummaryCheckoutPage.setDeliveryAddress("Wakad");

        System.out.println("STEP - Enter a valid mobile number");
        orderSummaryCheckoutPage.setPhoneNum("9765463742");

        System.out.println("Capture total payable amount in checkout order summary");
        String orderSummaryTotalPayableAmt = orderSummaryCheckoutPage.getTotalPayableAmt();

        System.out.println("STEP - Click the Continue to Payment button.");
        orderSummaryCheckoutPage.clickOnContinueToPaymentBtn();

        PaymentPage paymentPage = new PaymentPage();
        paymentPage.waitForPageLoad();
        System.out.println("Capture total payable in the payment section");
        String paymentSummaryTotalPayableAmt = paymentPage.getTotalPayable();

        System.out.println("VERIFY - that the amount displayed in the Payable section of the Order Summary screen matches the amount displayed in the Total Payable section of the Bill screen.");
        Assert.assertEquals(paymentSummaryTotalPayableAmt, orderSummaryTotalPayableAmt);

        System.out.println("STEP - Click on Pay & Place Order");
        paymentPage.clickOnPayPlaceOrderBtn();
//
        System.out.println("VERIFY - Confirm the capta error notification displayed");
        boolean captaFlag = paymentPage.isErrorCaptaDisplayed();
        Assert.assertTrue(captaFlag);

        System.out.println("STEP - Click on Capta checkbox");
        paymentPage.clickOnCaptaCheckbox();

        System.out.println("STEP - Click on Pay & Place Order");
        paymentPage.clickOnPayPlaceOrderBtn();

<<<<<<< HEAD
         System.out.println("VERIFY - Confirm the UPI ID error notification displayed");
         boolean upiFlag = paymentPage.isUPIIdErrorNotificationDisplayed();
         Assert.assertTrue(upiFlag);
=======
        System.out.println("VERIFY - Confirm the UPI ID error notification displayed");
        boolean upiFlag = paymentPage.isUPIIdErrorNotificationDisplayed();
        Assert.assertTrue(upiFlag);
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe

        System.out.println("STEP - Enter a valid UPI ID in the payment field.");
        paymentPage.setUPIId("mkanani@okhdfcbank");

        System.out.println("STEP - Click on Pay & Place Order");
        paymentPage.clickOnPayPlaceOrderBtn();
        String expectedOrderDateTime = DateTimeUtility.getCurrentDateTime();

        OrderSuccessPage orderSuccessPage = new OrderSuccessPage();
        orderSuccessPage.waitForPageLoad();

        SoftAssert softAssert = new SoftAssert();
        System.out.println("VERIFY - Order Placed text is displayed");
        boolean orderFlag = orderSuccessPage.isOrderPlacedDisplayed();
        softAssert.assertTrue(orderFlag);

        System.out.println("VERIFY - Restaurant Details");
        String orderSummaryPage_restuarantName = orderSuccessPage.getRestaurantName();
        softAssert.assertEquals(orderSummaryPage_restuarantName, restaurantName);

        System.out.println("VERFIY - Amount Paid");
        String orderSummaryPage_amountPaid = orderSuccessPage.getAmtPaid();
<<<<<<< HEAD
        softAssert.assertEquals(orderSummaryPage_amountPaid,paymentSummaryTotalPayableAmt);
=======
        softAssert.assertEquals(orderSummaryPage_amountPaid, paymentSummaryTotalPayableAmt);
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe

        System.out.println("VERIFY - Order id format is as expected");
        String orderSummaryPage_orderId = orderSuccessPage.getOrderNumber();
        softAssert.assertTrue(orderSummaryPage_orderId.startsWith("ORDER#"));

        List<String> orderDetailsExpectedList = new ArrayList<>();
        orderDetailsExpectedList.add(orderSummaryPage_orderId);
        orderDetailsExpectedList.add(orderSummaryPage_restuarantName);
        orderDetailsExpectedList.add(orderSummaryPage_amountPaid);

        System.out.println("VERIFY - Payment Method (Paid Via)");
        String orderSummaryPage_paymentMethod = orderSuccessPage.getPaymentMode();
        softAssert.assertEquals(orderSummaryPage_paymentMethod, "UPI");
        softAssert.assertAll();

        System.out.println("STEP - Click on track order");
        orderSuccessPage.clickOnTrackOrder();

        System.out.println("Switch to OrderTrackSummaryPage");
        OrderTrackSummaryPage orderTrackSummaryPage = new OrderTrackSummaryPage();
        orderTrackSummaryPage.switchToTrackOrderWindow();
        orderTrackSummaryPage.waitForPageLoad();

        System.out.println("STEP - get order summary details");
        List<String> orderDetailsActualList = orderTrackSummaryPage.getOrderDetails();
        Assert.assertEquals(orderDetailsActualList, orderDetailsExpectedList);

        System.out.println("VERIFY - food deliver status and respective message");
        boolean isOrderDeliveredFlag = orderTrackSummaryPage.isOrderDelivered();
<<<<<<< HEAD
        boolean isOrderDeliverTextFlag =  orderTrackSummaryPage.isEnjoyYourMeanTextPresent();
=======
        boolean isOrderDeliverTextFlag = orderTrackSummaryPage.isEnjoyYourMeanTextPresent();
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe
        System.out.println("Order delivered status present : " + isOrderDeliveredFlag);
        System.out.println("Order deliver text present : " + isOrderDeliverTextFlag);
        Assert.assertEquals(isOrderDeliveredFlag, isOrderDeliverTextFlag);

        System.out.println("STEP - wait for order to be delivered");
        orderTrackSummaryPage.waitForOrderToBeDelivered();

        System.out.println("VERIFY - food deliver status and respective message");
        isOrderDeliveredFlag = orderTrackSummaryPage.isOrderDelivered();
<<<<<<< HEAD
        isOrderDeliverTextFlag =  orderTrackSummaryPage.isEnjoyYourMeanTextPresent();
        System.out.println("Order delivered status present : " + isOrderDeliveredFlag);
        System.out.println("Order deliver text present : " + isOrderDeliverTextFlag);
        Assert.assertEquals(isOrderDeliveredFlag, isOrderDeliverTextFlag);


    }
=======
        isOrderDeliverTextFlag = orderTrackSummaryPage.isEnjoyYourMeanTextPresent();
        System.out.println("Order delivered status present : " + isOrderDeliveredFlag);
        System.out.println("Order deliver text present : " + isOrderDeliverTextFlag);
        Assert.assertEquals(isOrderDeliveredFlag, isOrderDeliverTextFlag);
    }

//    @AfterMethod
//    public void tearDown(ITestResult result) {
//        String methodName = result.getMethod().getMethodName();
//        System.out.println("Method Name : " + result.getMethod().getMethodName());
//        System.out.println("Test Execution Start : " + result.getStartMillis());
//
//        System.out.println("Test Execution End : " + result.getEndMillis());
//
//        if (result.getStatus() == ITestResult.FAILURE) {
//            System.out.println("Test case failed..!");
//            BrowserActions.takeScreenshot(methodName + "_failed_method");
//        }
//
////        if (result.isSuccess()) {
////            System.out.println("Test Execution Done Properly");
////        } else {
////            System.out.println("Test Execution Closed unexpectedly");
////        }
//
//        System.out.println("Execution Done...!");
//    }
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe
}
