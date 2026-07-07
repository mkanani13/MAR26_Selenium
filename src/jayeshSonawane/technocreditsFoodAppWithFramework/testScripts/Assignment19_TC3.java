package jayeshSonawane.technocreditsFoodAppWithFramework.testScripts;

import jayeshSonawane.technocreditsFoodAppWithFramework.base.BrowserActions;
import jayeshSonawane.technocreditsFoodAppWithFramework.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Assignment19_TC3 {

    @BeforeMethod
    public void setup() {
        BrowserActions.start("http://34.66.197.232/#/access");

        AccessPage accessPage = new AccessPage();
        accessPage.waitForPageLoad();

        accessPage.continueToLogin("F248JK5SK6", "B6FVNRUZ");

        ChooseApplicationPage chooseApplicationPage = new ChooseApplicationPage();
        chooseApplicationPage.waitForPageLoad();
        chooseApplicationPage.clickOnSignIntoFoodApp();

        SignInPage signInPage = new SignInPage();
        signInPage.waitForPageLoad();
        signInPage.doSignIn("user@technocredits.com", "User@123");
    }

    @Test
    public void verifyOrderDelivered(){

        FindFoodPage findFoodPage = new FindFoodPage();
        findFoodPage.waitForPageLoad();

        System.out.println("STEP - Verify that the logged-in user's name is displayed in the top navigation bar.");
        MyProfilePage  myProfilePage = new MyProfilePage();
        myProfilePage.clickOnMyProfilePage();
        myProfilePage.waitforPageLoad();
        String expectedUserName = myProfilePage.getUserName();

        findFoodPage.clickOnFindFoodPage();
        findFoodPage.waitForPageLoad();
        String actualUserName = findFoodPage.getUserName();
        Assert.assertEquals(actualUserName, expectedUserName);

        String locality = "Baner";
        System.out.println("STEP - From the Locality dropdown, select " + locality);
        FindFoodBasedOnLocalityPage findFoodBasedOnLocalityPage = new FindFoodBasedOnLocalityPage();
        findFoodBasedOnLocalityPage.waitForPageLoad();
        findFoodBasedOnLocalityPage.selectLocalityFromDropdown(locality);
        System.out.println("STEP - Identify the first restaurant in the list that has at least one available dish (non-zero dish count) within " + locality + " and Click View & Order");
        String restaurantNameFindFoodBasedOnLocalityPage = findFoodBasedOnLocalityPage.selectFirstRestaurantWithAvailability();

        System.out.println("STEP - From the restaurant menu, locate the first food item whose Stock value is greater than 0 and increase its quantity by clicking the Qty Up Arrow by one(1) time.");
        FindFoodMenuPage findFoodMenuPage = new FindFoodMenuPage();
        findFoodMenuPage.waitForPageLoad();
        findFoodMenuPage.addInStockItemIntoCart(1);
        System.out.println("STEP - Select Coupon");
        String couponCode = "PUNE50";
        findFoodMenuPage.selectCoupon(couponCode);
        double subTotalFindFoodMenuPage = findFoodMenuPage.getSubTotal();
        double discountFindFoodMenuPage = findFoodMenuPage.getDiscount();
        double payableFindFoodMenuPage = findFoodMenuPage.getPayable();
        Assert.assertTrue(subTotalFindFoodMenuPage > 0, "Sub-Total value must be greater than 0");
        Assert.assertEquals(subTotalFindFoodMenuPage, findFoodMenuPage.expectedSubTotal(), "findFoodMenuPage - Verify SubTotal");
        Assert.assertEquals(discountFindFoodMenuPage, findFoodMenuPage.expectedDiscount(), "findFoodMenuPage - Verify Discount");
        Assert.assertEquals(payableFindFoodMenuPage, findFoodMenuPage.expectedPayable(), "findFoodMenuPage - Verify Payable");
        System.out.println("STEP - Click on Proceed to Checkout");
        findFoodMenuPage.clickOnProceedToCheckoutButton();

        FindFoodCheckoutPage findFoodCheckoutPage = new FindFoodCheckoutPage();
        findFoodCheckoutPage.waitForPageLoad();
        Assert.assertTrue(findFoodCheckoutPage.verifyRestaurant(restaurantNameFindFoodBasedOnLocalityPage));
        double subTotalFindFoodCheckoutPage = findFoodCheckoutPage.getSubTotal();
        double discountFindFoodCheckoutPage = findFoodCheckoutPage.getDiscount();
        double payableFindFoodCheckoutPage = findFoodCheckoutPage.getPayable();
        Assert.assertEquals(subTotalFindFoodCheckoutPage, subTotalFindFoodMenuPage,"findFoodCheckoutPage - Verify SubTotal");
        Assert.assertEquals(discountFindFoodCheckoutPage, discountFindFoodMenuPage,"findFoodCheckoutPage - Verify Discount");
        Assert.assertEquals(payableFindFoodCheckoutPage, payableFindFoodMenuPage, "findFoodCheckoutPage - Verify Payable");
        System.out.println("STEP - Enter Valid Delivery Address and Contact Mobile Number");
        findFoodCheckoutPage.enterDeliveryDetails("Wakad","9730287487");
        System.out.println("STEP - Click on Continue to Payment");
        findFoodCheckoutPage.clickOnContinueToPaymentButton();

        FindFoodPaymentPage findFoodPaymentPage = new FindFoodPaymentPage();
        findFoodPaymentPage.waitForPageLoad();
        Assert.assertEquals(findFoodPaymentPage.getRestaurant(), restaurantNameFindFoodBasedOnLocalityPage, "findFoodPaymentPage -  Verify Restaurant");
        System.out.println("STEP - Verify that the amount displayed in the Payable section of the Order Summary screen matches the amount displayed in the Total Payable section of the Bill screen");
        double subTotalFindFoodPaymentPage = findFoodPaymentPage.getSubTotal();
        double discountFindFoodPaymentPage = findFoodPaymentPage.getDiscount();
        double payableFindFoodPaymentPage = findFoodPaymentPage.getPayable();
        Assert.assertEquals(subTotalFindFoodPaymentPage, subTotalFindFoodCheckoutPage,"findFoodPaymentPage - Verify SubTotal");
        Assert.assertEquals(discountFindFoodPaymentPage, discountFindFoodCheckoutPage,"findFoodPaymentPage - Verify Discount");
        Assert.assertEquals(payableFindFoodPaymentPage, payableFindFoodCheckoutPage, "findFoodPaymentPage - Verify Payable");
        System.out.println("STEP - Verify that an Alert message pop-up is displayed showing 'Please confirm the captcha before paying' in red background text in the page.");
        findFoodPaymentPage.clickOnPlaceOrderButton();
        Assert.assertTrue(findFoodPaymentPage.isCaptchaErrorDisplayed(), "Verify Captcha Error");
        System.out.println("STEP - Select the I'm not a robot — confirm before paying checkbox.");
        findFoodPaymentPage.clickCaptcha();
        String paymentMethod = "UPI";
        String upiId = "jayesh@hdfc";
        String cardNumber = "1234567812345678";
        String expiry = "1234";
        String cvv = "123";
        String bankName = "HDFC Bank";
        String netBankongUserName = "hdfcadmin";
        String netBankongPassword = "technocredits";

        if (paymentMethod.equalsIgnoreCase("UPI")) {
            Assert.assertTrue(findFoodPaymentPage.isPaymentMethodUpiEnabled(), "UPI Payment Method Not Available");
            findFoodPaymentPage.clickOnPlaceOrderButton();
            Assert.assertTrue(findFoodPaymentPage.isUpiErrorDisplayed(),  "Verify Upi Error");
            System.out.println("STEP - Enter a valid UPI ID in the payment field.");
            findFoodPaymentPage.enterUpiId(upiId);
        }else if (paymentMethod.equalsIgnoreCase("Card")) {
            findFoodPaymentPage.clickPaymentMethodCard();
            Assert.assertTrue(findFoodPaymentPage.paymentMethodCardEnabled(), "Card Payment Method Not Available");
            // Write card steps
        }else if (paymentMethod.equalsIgnoreCase("Net Banking")) {
            findFoodPaymentPage.clickPaymentMethodNetBanking();
            Assert.assertTrue(findFoodPaymentPage.paymentMethodNetBankingEnabled(), "Net Banking Payment Method Not Available");
            // Write Net Banking Steps
        }
        findFoodPaymentPage.clickOnPlaceOrderButton();

        /*
        23.Verify that the Order Placed screen is displayed and contains the following details under the Track Order section/tab:
            -Restaurant Details
            -Amount Paid
            -Order Number
            -Payment Method (Paid Via)
        24.Click on "View my orders" section/tab.
        25.Verify that the Order number of the order placed in the "Track Order" tab/section is present in the Order# column of the "View my orders" tab/section.
        26.Verify that the Amount paid displayed in the "Track Order" tab/section is same as the price displayed under the Total column for the placed "Order number" in the "View my orders" tab/section.

         */

        System.out.println("STEP - Verify that the Order Placed screen is displayed");
        MyOrdersOrderPlacedPage myOrdersOrderPlacedPage = new MyOrdersOrderPlacedPage();
        myOrdersOrderPlacedPage.waitForPageLoad();
        Assert.assertTrue(myOrdersOrderPlacedPage.isOrderPlaced());
        Assert.assertEquals(myOrdersOrderPlacedPage.getRestaurantName(), restaurantNameFindFoodBasedOnLocalityPage);
        List<String> orderDetails = myOrdersOrderPlacedPage.getOrderDetails();
        System.out.println("Order Number = " + orderDetails.get(0));
        System.out.println("Amount Paid = " + orderDetails.get(1));
        System.out.println("Paid via = " + orderDetails.get(2));
    }

    @AfterMethod
    public void tearDown() {
//        BrowserActions.close();
    }

}
