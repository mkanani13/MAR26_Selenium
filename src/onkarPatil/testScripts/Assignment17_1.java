package onkarPatil.testScripts;

import onkarPatil.base.BrowserActions;
import onkarPatil.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment17_1 {

    @BeforeMethod
    public void setup(){
        BrowserActions.start("http://34.66.197.232/#/access");
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

        System.out.println("STEP- Select Kothrud from locality filter");
        findFoodPage.selectLocationFromDropdown("Kothrud");

        System.out.println("STEP- Select Abhishek Pure Veg and click 'View & Order button'");
        findFoodPage.selectGivenRestaurant("Abhishek Pure Veg");

        System.out.println("STEP- Add any available (in-stock) dish to the shopping cart");
        RestarantMenuPage restarantMenuPage = new RestarantMenuPage();
        restarantMenuPage.waitForPageLoad();
        restarantMenuPage.addFirstAvailableDishInCart(1);

        System.out.println("VERIFY- Verify that the cart displays a subtotal greater than zero");
        int selectedQuantity = restarantMenuPage.getAvailbleQuantity();
        Assert.assertEquals(selectedQuantity, 1);

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
        orderSummary_checkoutPage.enterDeliveryAddress("Hinjewadi");
        orderSummary_checkoutPage.enterMobileNumber("1234567890");
        orderSummary_checkoutPage.clickOnContinueOutBtn();

        System.out.println("STEP- Add Payment details, select captcha checkbox and Select pay button");
        PaymentPage paymentPage = new PaymentPage();
        paymentPage.waitForPageLoad();
        paymentPage.addUpiId("onkar@sbi");
        paymentPage.selectCheckboxForCaptcha();
        paymentPage.clickOnPayBtn();

        System.out.println("STEP- Capture orderID for newly placed order");
        OrderSuccessPage orderSuccessPage = new OrderSuccessPage();
        orderSuccessPage.waitForPageLoad();
        String orderId = orderSuccessPage.getOrderId();

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
