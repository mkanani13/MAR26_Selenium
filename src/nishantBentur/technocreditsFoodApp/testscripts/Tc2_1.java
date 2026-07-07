package nishantBentur.technocreditsFoodApp.testscripts;

import nishantBentur.base.BrowserActions;
import nishantBentur.technocreditsFoodApp.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Tc2_1 {

    @BeforeTest
    public void setup(){
        System.out.println("STEP-Launch TechnoCredits Pune Food Delivery");
        BrowserActions.start("http://34.66.197.232/#/access");
        LoginPage loginPage = new LoginPage();
        loginPage.doLogin();
    }

    @Test
    public void placeOrderFlow(){
        FindFoodPage findFoodPage = new FindFoodPage();
        findFoodPage.waitForPageLoad();

        System.out.println("STEP- Select location as Baner");
        findFoodPage.setLocality("Baner");

        System.out.println("STEP- Identify first restaurant having atleast one dish & Click on View & Order");
        String restaurantName = findFoodPage.getFirstRestaurantNameHavingDishes();
        findFoodPage.clickOnViewAndOrder(restaurantName);

        System.out.println("STEP- From the restaurant menu, locate the first food item whose Stock value is greater than 0 and increase its quantity by clicking the Qty Up Arrow.");
        RestaurantMenuPage restaurantMenuPage = new RestaurantMenuPage();
        restaurantMenuPage.waitForPageLoad();
        String dish = restaurantMenuPage.getFirstAvailableDish();
        restaurantMenuPage.setQuantityOfGivenDish(dish, 2);

        System.out.println("VERIFY- that the cart Subtotal is greater than 0.");
        String cartSubTotal = restaurantMenuPage.getSubTotal();
        Assert.assertNotEquals(cartSubTotal,"₹0.00");

        System.out.println("STEP- Click the Proceed to Checkout → button.");
        restaurantMenuPage.clickOnProceedToCheckoutBtn();

        System.out.println("STEP- Enter a valid delivery address.");
        OrderSummary_CheckoutPage orderSummaryCheckoutPage = new OrderSummary_CheckoutPage();
        orderSummaryCheckoutPage.waitForPageLoad();
        orderSummaryCheckoutPage.setDeliveryAddress("Wakad");

        System.out.println("STEP- Enter a valid phone number");
        orderSummaryCheckoutPage.setContactNumber("909090909090");

        System.out.println("STEP- Click the Continue to Payment → button.");
        String orderSummary_TotalPayableAmount= orderSummaryCheckoutPage.getTotalPayableAmount();
        orderSummaryCheckoutPage.clickContinueToPaymentBtn();

        System.out.println("STEP- Verify that the amount displayed in the Payable section of the Order Summary screen matches the amount displayed in the Total Payable section of the Bill screen.");
        PaymentPage paymentPage = new PaymentPage();
        String paymentPage_TotalPayableAmount = paymentPage.getTotalPayable();
        Assert.assertEquals(paymentPage_TotalPayableAmount,orderSummary_TotalPayableAmount);

        System.out.println("STEP- Click on Pay & Order button & check the captcha notification");
        paymentPage.clickPayAndPlaceOrderBtn();
        boolean captcha_flag = paymentPage.isErrorCaptaDisplayed();
        Assert.assertTrue(captcha_flag);

        System.out.println("STEP- Select the I'm not a robot — confirm before paying checkbox.");
        paymentPage.selectCaptchaCheckbox();

        System.out.println("STEP- Click on Pay & Order button * check the enter valid upi notification");
        paymentPage.clickPayAndPlaceOrderBtn();
        boolean upi_flag = paymentPage.isUPIIdErrorNotificationDisplayed();
        Assert.assertTrue(upi_flag);

        System.out.println("STEP- Enter a valid UPI ID in the payment field.");
        paymentPage.setUPIid("OK@okbank");

        System.out.println("STEP- Click on Pay & Place Order button.");
        paymentPage.clickPayAndPlaceOrderBtn();

        System.out.println("VERIFY- ORder details");
        OrderSuccessPage orderSuccessPage = new OrderSuccessPage();
        orderSuccessPage.waitForPageLoad();;

        System.out.println("VERIFY-Restaurant Name in the Track Order page");
        SoftAssert softAssert = new SoftAssert();
        String orderSuccess_restaurantName = orderSuccessPage.getRestaurantName();
        softAssert.assertEquals(orderSuccess_restaurantName, restaurantName);

        System.out.println("VERIFY- ORDER ID is starts with ORDER#");
        String orderID = orderSuccessPage.getOrderID();
        boolean orderID_flag = orderID.startsWith("ORDER#");
        softAssert.assertTrue(orderID_flag);

        System.out.println("VERIFY - Amount paid in track order page");
        String orderSuccess_AmountPaid = orderSuccessPage.getAmountPaid();
        softAssert.assertEquals(paymentPage_TotalPayableAmount, orderSuccess_AmountPaid);

        System.out.println("VERIFY - Payment method in track order page");
        String payMethod = orderSuccessPage.getPaymentMethod();
        softAssert.assertEquals(payMethod, "UPI");
        softAssert.assertAll();

        System.out.println("STEP- Click on View my orders button");
        orderSuccessPage.clickViewMyOrdersBtn();

        System.out.println("VERIFY- Order ID is present in the My Order Page");
        MyOrders myOrders = new MyOrders();
        myOrders.waitForPageLoad();
        boolean order_Flag = myOrders.searchOrder(orderID);
        Assert.assertTrue(order_Flag);
    }

    @AfterTest
    public void tearDown(){
        BrowserActions.closeBrowser();
    }
}
