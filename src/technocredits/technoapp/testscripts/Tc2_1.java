package technocredits.technoapp.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import technocredits.technoapp.base.BrowserActions;
import technocredits.technoapp.pages.*;

import java.time.Duration;

public class Tc2_1 {

    @BeforeMethod
    public void setup(){
        BrowserActions.start("http://34.66.197.232/#/access");
        LoginPage loginPage = new LoginPage();
        loginPage.doLogin();
    }

    @Test
    public void verifyPlaceOrderFeature(){
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
        restauarantMenuPage.setQuantityOfGivenDish(dish,2);

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

         System.out.println("VERIFY - Confirm the UPI ID error notification displayed");
         boolean upiFlag = paymentPage.isUPIIdErrorNotificationDisplayed();
         Assert.assertTrue(upiFlag);

        System.out.println("STEP - Enter a valid UPI ID in the payment field.");
        paymentPage.setUPIId("mkanani@okhdfcbank");

        System.out.println("STEP - Click on Pay & Place Order");
        paymentPage.clickOnPayPlaceOrderBtn();

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
        softAssert.assertEquals(orderSummaryPage_amountPaid,paymentSummaryTotalPayableAmt);

        System.out.println("VERIFY - Order id format is as expected");
        String orderSummaryPage_orderId = orderSuccessPage.getOrderNumber();
        softAssert.assertTrue(orderSummaryPage_orderId.startsWith("ORDER#"));

        System.out.println("VERIFY - Payment Method (Paid Via)");
        String orderSummaryPage_paymentMethod = orderSuccessPage.getPaymentMode();
        softAssert.assertEquals(orderSummaryPage_paymentMethod, "UPI");
        softAssert.assertAll();

        System.out.println("STEP - Click on View my orders");
        orderSuccessPage.clickOnViewMyOrder();
    }

}
