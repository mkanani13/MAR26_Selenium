package onkarPatil.testScripts;

import onkarPatil.base.BrowserActions;
import onkarPatil.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Assignment19_1 {

    @BeforeMethod
    public void setup(){
        BrowserActions.start("http://34.66.197.232/#/access");
    }

    @Test
    public void verifyPlaceOrderFeature(){
        System.out.println("STEP- Login to the application");
        LoginPage loginPage = new LoginPage();
        loginPage.doLogin();

        System.out.println("VERIFY- Logged in user's name is displayed in top navigation bar");
        FindFoodPage findFoodPage = new FindFoodPage();
        findFoodPage.waitForPageLoad();
        String currentUser = findFoodPage.getCurrentLoggedInUser();
        Assert.assertTrue(currentUser.contains("onkarpatil"));

        System.out.println("STEP- Select Baner from locality filter");
        findFoodPage.selectLocationFromDropdown("Baner");

        System.out.println("STEP- Select the restaurant which has atleast one dish available and click 'View & Order button'");
        String currentRestaurant = findFoodPage.getFirstRestaurantWithAvailbleDishes();
        findFoodPage.selectFirstRestaurantWithAvailbleDishes();

        System.out.println("VERIFY- Entered correct Restaurant");
        RestarantMenuPage restarantMenuPage = new RestarantMenuPage();
        restarantMenuPage.waitForPageLoad();
        String restaurantNameOnRestaurantMenuPage = restarantMenuPage.getRestaurantName();
        Assert.assertEquals(restaurantNameOnRestaurantMenuPage, currentRestaurant);

        System.out.println("STEP- Add any available (in-stock) dish to the shopping cart");
        restarantMenuPage.addFirstAvailableDishInCart(2);

        System.out.println("VERIFY- Verify that the cart displays a subtotal greater than zero");
        int selectedQuantity = restarantMenuPage.getAvailbleQuantity();
        Assert.assertEquals(selectedQuantity, 2);

        System.out.println("Step- Select the 'PUNE50 - 10% off.68 uses left.10% off, upto 100 uses' dropdown option");
        restarantMenuPage.selectCoupanFromDropdown();

        System.out.println("STEP- Capture the amounts");
        double subTotalAmt = restarantMenuPage.getSubTotalAmount();
        double expectedPayableAmt = subTotalAmt*0.9;
        double expectedDiscount = subTotalAmt-expectedPayableAmt;

        double discountAmt = restarantMenuPage.getDiscountAmt();
        double payableAmt = restarantMenuPage.getTotalPayableAmt();

        System.out.println("VERIFY- Verify that the Discount provided is 10% of the Subtotal value");
        Assert.assertEquals(discountAmt, expectedDiscount);

        System.out.println("VERIFY- Verify that the Payable amount is equal to the difference of Subtotal and Discount");
        Assert.assertEquals(payableAmt, expectedPayableAmt);

        System.out.println("STEP- Checkout");
        restarantMenuPage.clickOnCheckoutBtn();
        OrderSummary_CheckoutPage orderSummary_checkoutPage = new OrderSummary_CheckoutPage();
        orderSummary_checkoutPage.waitForPageLoad();
        double payableAmtFinal = orderSummary_checkoutPage.getPayableAmt();

        System.out.println("VERIFY- Amount is shown correctly after checkout");
        Assert.assertEquals(payableAmtFinal, expectedPayableAmt);
        Assert.assertTrue(payableAmtFinal > 0);

        System.out.println("STEP- Enter a valid delivery address and mobile number");
        orderSummary_checkoutPage.enterDeliveryAddress("Wakad");
        orderSummary_checkoutPage.enterMobileNumber("9172523900");
        orderSummary_checkoutPage.clickOnContinueOutBtn();

        System.out.println("VERIFY-Verify that the amount displayed in the Payable section of the Order Summary screen matches the amount displayed in the Total Payable section of the Bill screen");
        PaymentPage paymentPage = new PaymentPage();
        paymentPage.waitForPageLoad();
        double finalPayableAmt = paymentPage.getPayableAmt();
        Assert.assertEquals(finalPayableAmt, expectedPayableAmt);

        System.out.println("VERIFY- Verify that an Alert message pop-up is displayed showing 'Please confirm the captcha before paying' in red");
        paymentPage.clickOnPayBtn();
        String errorMessage = paymentPage.getErrorMsg();
        Assert.assertEquals(errorMessage, "Please confirm the captcha before paying");

        System.out.println("STEP- Add Payment details, select captcha checkbox and Select pay button");
        paymentPage.addUpiId("onkar@sbi");
        paymentPage.selectCheckboxForCaptcha();
        paymentPage.clickOnPayBtn();

        System.out.println("STEP- Capture details for newly placed order");
        OrderSuccessPage orderSuccessPage = new OrderSuccessPage();
        orderSuccessPage.waitForPageLoad();
        String orderConfirmation = orderSuccessPage.getConfirmationMessage();
        String orderId = orderSuccessPage.getOrderId();
        String amountPaid = orderSuccessPage.getAmountPaid();
        String paidVia = orderSuccessPage.getPaymentMode();

        System.out.println("VERIFY- Verify details on the Order Placed page");
        Assert.assertTrue(orderConfirmation.contains(currentRestaurant));
        Assert.assertTrue(amountPaid.contains(String.valueOf(expectedPayableAmt)));
        Assert.assertTrue(paidVia.equals("UPI"));

        System.out.println("VERIFY- Recent order is shown on My orders page");
        orderSuccessPage.clickOnViewOrders();
        MyOrdersPage myOrdersPage = new MyOrdersPage();
        myOrdersPage.waitForPageLoad();
        String finalOrderNum = myOrdersPage.getFirstOrderId();
        Assert.assertEquals(orderId, finalOrderNum);

        System.out.println("VERIFY- Verify that the Amount paid displayed in the Track Order tab/section is same as the price displayed under the Total column for the placed Order number in the View my orders tab/section");
        double amtDisplayedOnMyOrdersPage = myOrdersPage.getAmtDisplayedForFirstOrder();
        Assert.assertEquals(amtDisplayedOnMyOrdersPage, expectedPayableAmt);
    }

    @AfterMethod
    public void cleanup(){
        BrowserActions.quitBrowser();
    }
}
