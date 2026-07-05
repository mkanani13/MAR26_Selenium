package vishwajeetLoni.TCs.testscripts;

//1.Launch the browser and navigate to http://34.173.201.53/access#/login.
//        2.Open the Login page.
//        3.Enter valid customer credentials (email and password).
//        4.Click the Login button.
//        5.Verify that the logged-in user's name is displayed in the top navigation bar.
//        6.From the locality dropdown, select "Kothrud".
//        7.Open the restaurant "Abhishek Pure Veg".
//        8.Click the "View & Order" button.
//        9.Add any available (in-stock) dish to the shopping cart.
//        10.Verify that the cart displays a subtotal greater than zero.
//        11.Enter a valid delivery address and mobile number.
//        12.Select the checkbox "I am not a robot — confirm before placing order".
//        13.Click the "Place Order" button.
//        14.Verify that the "My Orders" page is displayed.
//        15.Confirm that the newly placed order details are visible on the "My Orders" page.
//
//        Expected Result:
//        The order should be placed successfully, and the "My Orders" page should display the details of the newly created order.


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vishwajeetLoni.TCs.pages.*;
import vishwajeetLoni.base.ActionOnBrowser;

public class Assignment17_TC1 {

    @BeforeMethod
    public void setup(){
        ActionOnBrowser.start("http://34.66.197.232/#/access");
        TechnoLoginPage login = new TechnoLoginPage();
        login.doLogin();
    }

    @Test
    public void Test1() {
        FindFoodPage findFoodPage = new FindFoodPage();
        findFoodPage.waitForPageLoad();


        System.out.println("Test - Verify username in top right corner");
        Assert.assertTrue(findFoodPage.uname().contains("vishwajeet.customer1"));

        String area = "Wakad";
        System.out.println("Test - Verify the location in dropdown is selected as " + area);
        System.out.println(findFoodPage.setSingleLocationinDD(area));

        System.out.println("Name of first restaurant with more than zero dishes");
        String restaurantname = findFoodPage.RestaurantHavingDishes();
        System.out.println(restaurantname);

        System.out.println("Click on View & Order");
        findFoodPage.clickOnViewandOrder(restaurantname);

        RestaurantMenuPage restaurantMenuPage = new RestaurantMenuPage();
        restaurantMenuPage.waitForPageLoad();

        System.out.println("Verify the name of selected restuarant and landing on its Menu");
        String RestaurantMenuName = restaurantMenuPage.getRestaurantName();
        Assert.assertEquals(RestaurantMenuName, restaurantname);

        System.out.println("Get first available dish");
        String dish = restaurantMenuPage.getFirstAvailableDish();

        System.out.println("Enter the quantity and give order");
        restaurantMenuPage.setOrderQty(dish, 1);

        System.out.println("Verify cart subtotal is greater than 0");
        Assert.assertNotEquals(restaurantMenuPage.subTotal(), "₹0.00");

        System.out.println("Proceed to checkout");
        restaurantMenuPage.clickOnProceedToCheckout();

        OrderCheckoutPage orderCheckoutPage = new OrderCheckoutPage();

        System.out.println("Wait for Order Checkout page load");
        orderCheckoutPage.waitForPageLoad();

        System.out.println("Enter Address");
        orderCheckoutPage.enterAddress("Test Address");

        System.out.println("Enter Phone number");
        orderCheckoutPage.enterPhNo("1234567890");

        System.out.println("Capture Payable Amt");
        String payable = orderCheckoutPage.payableAmt();

        System.out.println("Click on Continue to payment btn");
        orderCheckoutPage.clickOnContinueToPaymentBtn();

        PaymentPage paymentPage = new PaymentPage();
        System.out.println("Wait for Payment Page load");
        paymentPage.waitForPageLoad();

        System.out.println("Capture Payable Amt");
        String totalPayable = paymentPage.totalPayableAmt();

        System.out.println("Verify the Payable amt and Total payable amt are same");
        Assert.assertTrue(totalPayable.equals(payable));

        System.out.println("Select UPI payment method");
        paymentPage.UPIclick();

        System.out.println("Click on Place order");
        paymentPage.payAndPlaceorderBtnClick();

        System.out.println("Verify if captcha error displayed");
        paymentPage.isErrorCaptaDisplayed();

        System.out.println("Enter UPI id");
        paymentPage.enterUpiId("test@tttt");

        System.out.println("Click on Place order again");
        paymentPage.payAndPlaceorderBtnClick();

        System.out.println("Verify if captcha error displayed");
        paymentPage.isErrorCaptaDisplayed();

        System.out.println("Click on checkbox");
        paymentPage.selectCaptchaCheckbox();

        System.out.println("Clear UPI id");
        paymentPage.clearUpiId();

        System.out.println("Enter UPI id");
        paymentPage.enterUpiId(" ");

        System.out.println("Click on Place order again");
        paymentPage.payAndPlaceorderBtnClick();

        System.out.println("Verify UPI id required error displayed");
        paymentPage.isUPIIdRequiredErrorDisplayed();

        System.out.println("Enter UPI id");
        paymentPage.enterUpiId("test@name");

        System.out.println("Click on Place order again");
        paymentPage.payAndPlaceorderBtnClick();

        OrderPlacedPage orderPlacedPage = new OrderPlacedPage();
        System.out.println("Wait for Order success page to laod");
        orderPlacedPage.waitForPageLoad();

        System.out.println("Verify the Order placed header is displayed");
        SoftAssert softAssert = new SoftAssert();
        boolean orderFlag = orderPlacedPage.isOrderPlacedDisplayed();
        softAssert.assertTrue(orderFlag);

        System.out.println("Verify Restaurant name");
        softAssert.assertEquals(orderPlacedPage.getRestaurantName(), restaurantname);

        System.out.println("Verify Amount paid");

        softAssert.assertEquals(orderPlacedPage.getAmtPaid(), totalPayable);

        System.out.println("Verify Order number");
        String orderPlacedPageOrderNo = orderPlacedPage.getOrderNumber();
        softAssert.assertTrue(orderPlacedPageOrderNo.startsWith("ORDER#"));

        System.out.println("Verify Payment Method");
        softAssert.assertEquals(orderPlacedPage.getPaymentMode(), "UPI");

        softAssert.assertAll();

//        System.out.println("Click on View my orders");
//        orderPlacedPage.clickOnViewMyOrder();

    }

}
