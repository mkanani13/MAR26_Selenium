package jayeshSonawane.technocreditsFoodAppWithoutFramework.testScripts;

import jayeshSonawane.technocreditsFoodAppWithoutFramework.pages.FindFood;
import jayeshSonawane.technocreditsFoodAppWithoutFramework.pages.Login;
import jayeshSonawane.technocreditsFoodAppWithoutFramework.pages.MyOrders;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/*
Using Selenium WebDriver with Java, automate the following end-to-end food ordering scenario (Use Explicit Wait instead of Implicit Wait) with a Standalone Script:

1.Launch the browser and navigate to http://34.173.201.53/access#/login.
2.Open the Login page.
3.Enter valid customer credentials (email and password).
4.Click the Login button.
5.Verify that the logged-in user's name is displayed in the top navigation bar.
6.From the locality dropdown, select "Kothrud".
7.Open the restaurant "Abhishek Pure Veg".
8.Click the "View & Order" button.
9.Add any available (in-stock) dish to the shopping cart.
10.Verify that the cart displays a subtotal greater than zero.
11.Enter a valid delivery address and mobile number.
12.Select the checkbox "I am not a robot — confirm before placing order".
13.Click the "Place Order" button.
14.Verify that the "My Orders" page is displayed.
15.Confirm that the newly placed order details are visible on the "My Orders" page.

Expected Result:
The order should be placed successfully, and the "My Orders" page should display the details of the newly created order.
 */
public class Assignment17_TC1 {
    Login login = new Login();
    FindFood findFood = new FindFood();
    MyOrders myOrders = new MyOrders();

    @Test
    void tc1(){
        login.login();
        findFood.verifyLoggedInUserName();
        findFood.findRestaurantByLocality("Kothrud", "Abhishek Pure Veg");
        findFood.addInStockDishToCart();
        findFood.addDeliveryDetails();
        findFood.placeOrderUsingUpi();
        myOrders.verifyOrderPlaced();
        myOrders.orderDetails();
    }

    @AfterMethod
    void browserClose(){
       // BrowserActions.close();
    }
}
