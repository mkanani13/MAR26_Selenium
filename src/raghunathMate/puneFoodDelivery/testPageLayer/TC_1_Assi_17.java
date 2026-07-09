package raghunathMate.puneFoodDelivery.testPageLayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import puneFoodDelivery.pageLayer.*;
import puneFoodDelivery.testBase.BrowserAction;

public class TC_1_Assi_17 {

    @BeforeMethod
    public void launchBrowserAndLoadUrl(){
        System.out.println("Step - 1.Launch the browser and navigate to link");
        BrowserAction.start();

        System.out.println("Getting Access for application");
        StudentAccessPage stdaccesspage = new StudentAccessPage();
        stdaccesspage.waitForPageLoad();
        stdaccesspage.getStudentAccess("35EGM7D45W", "7MNT2R2F");

        System.out.println("Choosing the application");
        ChooseApplicationPage chooseapppage = new ChooseApplicationPage();
        chooseapppage.waitForPageLoad();
        chooseapppage.VerifyAccessGrantedOrNot();
        chooseapppage.chooseApplication();

        System.out.println("Step - 2_3_4.Open the Login page and Enter valid customer credentials and Click the Login button");
        LoginPage lopinpage = new LoginPage();
        lopinpage.waitForPageLoad();
        lopinpage.loginToApplication();
    }
    @Test
    public void Assignment_17() {

        System.out.println("Step - 5.Verify that the logged-in user's name is displayed in the top navigation bar.");
        FoodOrderPage foodorderpage = new FoodOrderPage();
        foodorderpage.waitPageLoad();
        boolean userNameFlage = foodorderpage.userNameVisibilityCheck();
        SoftAssert softassert = new SoftAssert();
        softassert.assertTrue(userNameFlage,"User name is not presented at expected place");

        System.out.println("step - 6.From the locality dropdown, select Kothrud ");
        foodorderpage.waitPageLoad();
        foodorderpage.selectLocationFromDropDown("Kothrud");
        foodorderpage.waitPageLoad();

        System.out.println("step - 7_8.Open the restaurant Abhishek Pure Veg and Click the View & Order button");
        foodorderpage.selectRestraurant("Abhishek Pure Veg");
        MenuCardPage menucardpage = new MenuCardPage();
        menucardpage.waitForPageLoad();

        System.out.println("Step - 9.Add any available (in-stock) dish to the shopping cart.");
        String dish = menucardpage.getDishNameWhichStockShouldBeNonZero();
        menucardpage.quantityForGivenDish(dish, 2);

        System.out.println("Step- 10.Verify that the cart displays a subtotal greater than zero.");
        String subTotal = menucardpage.getSubTotal();
        softassert.assertNotEquals(subTotal,"₹0.00","Subtotal is not grater than zero");
        menucardpage.clickOnProceedToCheckOutButton();

        System.out.println("Step - 11.Enter a valid delivery address and mobile number.");
        OrderSummaryPage ordersummarypage = new OrderSummaryPage();
        ordersummarypage.waitForPageLoad();
        ordersummarypage.enterDeliveryAddress("Vadgon Budruk");
        ordersummarypage.enterMobileNumber("9730857334");
        ordersummarypage.clickOnProceedToPaymentButton();

        System.out.println("Entering upi id");
        PaymentPage paymentpage = new PaymentPage();
        paymentpage.waitForPageLoad();
        paymentpage.enterUPIId("name@okhdfcbank");

        System.out.println("Step - 12.Select the checkbox I am not a robot — confirm before placing order");
        paymentpage.clickingCheckBoxOfIAmNotRobot();
        System.out.println("Step - 13.Click the Place Order button");
        paymentpage.clickOnPayAndPlaceOrderButton();

        System.out.println("Step - 14.Verify that the My Orders page is displayed.");
        OrderSuccessPage ordersuccesspage = new OrderSuccessPage();
        ordersuccesspage.waitForPageLoad();
        String orderId = ordersuccesspage.getOrderId();
        ordersuccesspage.clickOnViewMyOrderButton();

        System.out.println("Step - 14.Verify that the My Orders page is displayed.");
        MyOrdersPage myorderpage = new MyOrdersPage();
        myorderpage.waitForPageLoad();
        boolean pageTitle = myorderpage.getpageTitleFlage();
        softassert.assertTrue(pageTitle);

        System.out.println("Step - 15.Confirm that the newly placed order details are visible on the \"My Orders\" page");
        boolean idPresentFlag = myorderpage.checkOrderIdIsPresentOrNotInMyOrderPage(orderId);
        softassert.assertTrue(idPresentFlag,"Order id is not present in My Orders page");
        softassert.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        BrowserAction.closeBrowser();
    }

}
