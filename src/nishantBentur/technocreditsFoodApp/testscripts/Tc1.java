package nishantBentur.technocreditsFoodApp.testscripts;

import nishantBentur.base.BrowserActions;
import nishantBentur.technocreditsFoodApp.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tc1 {

    @BeforeTest
    public void setup(){
        System.out.println("STEP-Launch TechnoCredits Pune Food Delivery");
        BrowserActions.start("http://34.66.197.232/#/access");
        LoginPage loginPage = new LoginPage();
        loginPage.doLogin();
    }

    @Test
    public void verifyPlaceOrder(){
        FindFoodPage findFoodPage = new FindFoodPage();
        findFoodPage.waitForPageLoad();

        System.out.println("STEP- Select location as Kothrud");
        findFoodPage.setLocality("Kothrud");

        System.out.println("STEP- Open the restaurant Abhishek Pure Veg");
        String restaurantName = findFoodPage.getFirstRestaurantNameHavingDishes();
        System.out.println(restaurantName);

        System.out.println("STEP- click on View and ORder.");
        findFoodPage.clickOnViewAndOrder(restaurantName);

        System.out.println("STEP- SElect first available dish in stock");
        RestaurantMenuPage restaurantMenuPage = new RestaurantMenuPage();
        restaurantMenuPage.waitForPageLoad();
        String dishName = restaurantMenuPage.getFirstAvailableDish();
        System.out.println(dishName);

        System.out.println("STEP- Set the quantity of dish to 1");
        restaurantMenuPage.setQuantityOfGivenDish(dishName,1);

        System.out.println("VERIFY- subtotal is greater than 0");
        String restuarantMenuSubTotal = restaurantMenuPage.getSubTotal();
        Assert.assertNotEquals(restuarantMenuSubTotal,"₹0.00");

        System.out.println("STEP- Click on Prceed to Checkout button");
        restaurantMenuPage.clickOnProceedToCheckoutBtn();

        System.out.println("STEP- Enter delivery address");
        OrderSummary_CheckoutPage orderSummaryCheckoutPage = new OrderSummary_CheckoutPage();
        orderSummaryCheckoutPage.waitForPageLoad();
        orderSummaryCheckoutPage.setDeliveryAddress("Wakad, Pune");

        System.out.println("STEP- Enter Contact number");
        orderSummaryCheckoutPage.setContactNumber("9090909090");

        System.out.println("STEP- Click on Continue to Payment button");
        orderSummaryCheckoutPage.clickContinueToPaymentBtn();

        System.out.println("STEP- Enter UPI ID");
        PaymentPage paymentPage = new PaymentPage();
        paymentPage.waitForPageLoad();
        paymentPage.setUPIid("ok@okbank");

        System.out.println("STEP- Select the captcha checkbox");
        paymentPage.selectCaptchaCheckbox();

        System.out.println("STEP- Click on Pay and Place Order Button");
        paymentPage.clickPayAndPlaceOrderBtn();

        System.out.println("VERIFY - that My Order page is displayed");
        OrderSuccessPage orderSuccessPage = new OrderSuccessPage();
        orderSuccessPage.waitForPageLoad();
        orderSuccessPage.isOrderPlacedDisplayed();
    }

    @AfterTest
    public void tearDown(){
        BrowserActions.closeBrowser();
    }
}
