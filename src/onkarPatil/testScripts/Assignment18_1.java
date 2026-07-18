package onkarPatil.testScripts;

import onkarPatil.base.BrowserActions;
import onkarPatil.constants.ConstantPath;
import onkarPatil.pages.*;
import onkarPatil.utility.PropFileOperations;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Assignment18_1 {

    @BeforeMethod
    public void setup(){
        PropFileOperations propFile = new PropFileOperations(ConstantPath.CREDENTIALS_FILE_PATH);
        BrowserActions.start(propFile.getValue("URL"));
    }

    @Test
    public void orderItemsAndVerifyOrder(){
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
        String currentRestaurant = findFoodPage.getFirstRestaurantWithAvailableDishes();
        findFoodPage.selectFirstRestaurantWithAvailbleDishes();

        System.out.println("STEP- Add any available (in-stock) dish to the shopping cart");
        RestarantMenuPage restarantMenuPage = new RestarantMenuPage();
        restarantMenuPage.waitForPageLoad();
        restarantMenuPage.addFirstAvailableDishInCart(3);

        System.out.println("VERIFY- Verify that the cart displays a subtotal greater than zero");
        int selectedQuantity = restarantMenuPage.getAvailbleQuantity();
        Assert.assertEquals(selectedQuantity, 3);

        double payableAmt = restarantMenuPage.getTotalPayableAmt();

        System.out.println("STEP- Checkout");
        restarantMenuPage.clickOnCheckoutBtn();
        OrderSummary_CheckoutPage orderSummary_checkoutPage = new OrderSummary_CheckoutPage();
        orderSummary_checkoutPage.waitForPageLoad();
        double payableAmtFinal = orderSummary_checkoutPage.getPayableAmt();

        System.out.println("VERIFY- Amount is shown correctly after checkout");
        Assert.assertEquals(payableAmtFinal, payableAmt);
        Assert.assertTrue(payableAmtFinal > 0);

        System.out.println("STEP- Enter a valid delivery address and mobile number");
        orderSummary_checkoutPage.enterDeliveryAddress("Wakad");
        orderSummary_checkoutPage.enterMobileNumber("9172523900");
        orderSummary_checkoutPage.clickOnContinueOutBtn();

        System.out.println("STEP- Add Payment details, select captcha checkbox and Select pay button");
        PaymentPage paymentPage = new PaymentPage();
        paymentPage.waitForPageLoad();
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
        Assert.assertTrue(amountPaid.contains(String.valueOf(payableAmt)));
        Assert.assertTrue(paidVia.equals("UPI"));

        System.out.println("VERIFY- Recent order is shown on My orders page");
        orderSuccessPage.clickOnViewOrders();
        MyOrdersPage myOrdersPage = new MyOrdersPage();
        myOrdersPage.waitForPageLoad();
        String finalOrderNum = myOrdersPage.getFirstOrderId();
        Assert.assertEquals(orderId, finalOrderNum);
    }

    @AfterMethod
    public void cleanup(){
        BrowserActions.quitBrowser();
    }
}
