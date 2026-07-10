package aartiKulkarni.Assignments;

import aartiKulkarni.technoApp.base.BrowserActions;
import aartiKulkarni.technoApp.base.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

/*
sing Selenium WebDriver with Java, automate the following end-to-end food ordering scenario
(Use Explicit Wait instead of Implicit Wait) with a Standalone Script:
1.Launch the browser and navigate to:
http://34.173.201.53/access#/login
2.Open the Login page.
3.Enter valid customer credentials (Email and Password).
4.Click the Login button.
5.Verify that the logged-in user's name is displayed in the top navigation bar.
6.From the Locality dropdown, select "Baner".
7.Identify the first restaurant in the list that has at least one available dish (non-zero dish count) within the selected locality (Balance Brew Cafe).
8.Click the "View & Order" button for the selected restaurant.
9.From the restaurant menu, locate the first food item whose Stock value is greater than 0 and increase its quantity by clicking the Qty Up Arrow by one(1) time.
10.Select the "PUNE50 - 10% off.68 uses left.10% off, upto 100 uses" dropdown option.
11.Verify that the cart Subtotal is greater than 0 equaling to the (QtyPrice) of the Selected Dish.
12.Verify that the Discount provided is 10% of the Subtotal value.
13.Verify that the Payable amount is equal to the difference of Subtotal and Discount. (i.e Payable = Subtotal - Discount)
14.Click the "Proceed to Checkout →" button.
15.In the Delivery Details section:
-Enter a valid delivery address.
-Enter a valid mobile number.
16.Click the "Continue to Payment →" button.
17.Click the "Pay  & Place Order" button.
18.Verify that the amount displayed in the Payable section of the Order Summary screen matches the amount displayed in the Total Payable section of the Bill screen.
19.Verify that an Alert message pop-up is displayed showing "Please confirm the captcha before paying" in red background text in the page.
20.Enter a valid UPI ID in the payment field.
21.Select the "I'm not a robot — confirm before paying" checkbox.
22.Click the "Pay * & Place Order" button.
23.Verify that the Order Placed screen is displayed and contains the following details under the Track Order section/tab:
-Restaurant Details
-Amount Paid
-Order Number
-Payment Method (Paid Via)
24.Click on "View my orders" section/tab.
25.Verify that the Order number of the order placed in the "Track Order" tab/section is present in the Order# column of the "View my orders" tab/section.
26.Verify that the Amount paid displayed in the "Track Order" tab/section is same as the price displayed under the Total column for the placed "Order number" in the "View my orders" tab/section. */



public class Assignment19 {

    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setup(){
        driver= BrowserActions.start("http://34.66.197.232/#/access");
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        LoginPage loginPage=new LoginPage();
        loginPage.doLogin();
    }
    @Test
    public void orderFoodFlow(){
        String LOCALITYFILTERDROPDOWN="//select[@id='locality-filter']";
        System.out.println("From the Locality dropdown, select Baner.");
        //get location of dropdown
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOCALITYFILTERDROPDOWN)));
        WebElement locationDD=driver.findElement(By.xpath(LOCALITYFILTERDROPDOWN));
        Select select=new Select(locationDD);
        select.selectByVisibleText("Baner");

        System.out.println("Identify the first restaurant in the list that has at least one available dish (non-zero dish count) within the selected locality (Balance Brew Cafe).");
        //wait for restaurants to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='restaurants-grid']/div")));
        System.out.println("waited for grid");
        //restaurant having non zero dishes
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid = 'restaurants-grid']//p[1][not(contains(text(),' 0 dishes'))]/preceding-sibling::h3")));
        String restaurantName=driver.findElement(By.xpath("//div[@data-testid = 'restaurants-grid']//p[1][not(contains(text(),' 0 dishes'))]/preceding-sibling::h3")).getText().trim();
        System.out.println(restaurantName);

        System.out.println("Click the View & Order button for the selected restaurant.");
        driver.findElement(By.xpath("(//div[@data-testid = 'restaurants-grid']//p[1][not(contains(text(),' 0 dishes'))]/following::a)[1]")).click();
        System.out.println("View and order clicked ");

        System.out.println("select first dish having more than 0 stock and increase its value by 1 ");
        String PROCEEDTOCHECKOUTBTN="//button[@id='proceed-checkout-btn']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PROCEEDTOCHECKOUTBTN)));
        Actions actions=new Actions(driver);
        WebElement quantityElement=driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][not(text()='0')])[1]/following-sibling::td/input"));
        quantityElement.click();
        actions.sendKeys(Keys.ARROW_UP).perform();
        String quantity = quantityElement.getAttribute("value");
        Assert.assertEquals(quantity,"1");
        System.out.println("Quantity increased by 1");

        System.out.println("Select coupon code field");
        driver.findElement(By.xpath("//select[@id='coupon-code']")).click();

        System.out.println("Click on 50 % coupon");
        driver.findElement(By.xpath("//option[contains(text(),'PUNE50')]")).click();

        System.out.println("Click on proceed to checkout");
        driver.findElement(By.xpath(PROCEEDTOCHECKOUTBTN)).click();

        System.out.println("wait for checkoutPage to get load to enter address and no");
        String CONTINUETOPAYMENTBTN="//button[@id='co-continue']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CONTINUETOPAYMENTBTN)));

        System.out.println("Get the Order summery payment amount to compare with final payment ");
        String orderSummeryPayment=driver.findElement(By.xpath("//span[@data-testid='checkout-payable']")).getText();

        System.out.println("Enter address and mobile no");
        driver.findElement(By.xpath("//textarea[@id='co-address']")).sendKeys("Pimple Gurav");
        driver.findElement(By.xpath("//input[@id='co-mobile']")).sendKeys("9309087270");

        System.out.println("Click on payment continue");
        driver.findElement(By.xpath(CONTINUETOPAYMENTBTN)).click();

        System.out.println("wait for payment page to load ");
        String PLACEORDERBTN="//button[@id='pay-btn']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PLACEORDERBTN)));

        System.out.println("Capture Total payable from :Payment page ");
        String paymentTotalPay=driver.findElement(By.xpath("//span[@data-testid='payment-total']")).getText();

        System.out.println("Varify : payable amount at orderSummeryPage and total payment ");
        Assert.assertEquals(paymentTotalPay,orderSummeryPayment);
        System.out.println("Payment from both pages varified ");

        System.out.println("Click on place order ");
        driver.findElement(By.xpath(PLACEORDERBTN)).click();

        System.out.println("Varify: is -Please confirm the captcha before paying- notification displayed ");
        WebElement captaNotification=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Please confirm the captcha before paying']")));
        boolean captaNotificationFlag=captaNotification.isDisplayed();
        Assert.assertTrue(captaNotificationFlag);

        System.out.println("Varify : UPI ID is required notification displayed after clickling checkbox");

        System.out.println("Click on checkbox ");
        driver.findElement(By.xpath("//input[@id='pay-captcha']")).click();

        System.out.println("Click on place order button ");
        driver.findElement(By.xpath(PLACEORDERBTN)).click();

        System.out.println("Varify : UPI ID notification displayed ");
        WebElement upiErrorNotification  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='UPI ID is required']")));
        boolean upiIdNotificationFlag=upiErrorNotification.isDisplayed();
        Assert.assertTrue(upiIdNotificationFlag);

        System.out.println("Enter UPI ID and click checkbox  ");
        driver.findElement(By.xpath("//input[@id='f-upi']")).sendKeys("kulkarniaarti1110@icic");

        System.out.println("click checkbox - already selected");
       // driver.findElement(By.xpath("//input[@id='pay-captcha']")).click();

        System.out.println("click order button");
        driver.findElement(By.xpath(PLACEORDERBTN)).click();

        System.out.println("wait for orderSuccessPage load  ");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Order placed!']")));

        System.out.println("Varify: order placed displayed ");

        SoftAssert softAssert=new SoftAssert();

        WebElement orderPlaces=driver.findElement(By.xpath("//h1[text()='Order placed!']"));
        boolean orderPlacedFlag=orderPlaces.isDisplayed();
        softAssert.assertTrue(orderPlacedFlag);

        System.out.println("Varify : restaurant name ");
        String restaurantNameOrderSuccessPage=driver.findElement(By.xpath("//strong")).getText();
        softAssert.assertEquals(restaurantNameOrderSuccessPage, restaurantName);

        System.out.println("Get order ID ");
        String orderIDOrderSuccessPage=driver.findElement(By.xpath("//span[text()='Order number']/following-sibling::span")).getText();

        System.out.println("Varify : Amount");
        String paymentAmountOrderSuccessPage=driver.findElement(By.xpath("//span[@data-testid='success-amount']")).getText();
        System.out.println(paymentAmountOrderSuccessPage);
        System.out.println("PaymentTotalPay :"+paymentTotalPay);
        softAssert.assertEquals(paymentAmountOrderSuccessPage,paymentTotalPay);
        System.out.println("Amount varified ");

        System.out.println("Varify : payment mode");
        String paymentMode=driver.findElement(By.xpath("//span[text()='Paid via']/following-sibling::span")).getText();
        softAssert.assertEquals(paymentMode,"UPI");

        System.out.println("Check if order format is correct ");
        String orderIdOrderSuccessPage=driver.findElement(By.xpath("//span[@data-testid='success-order-number']")).getText();
        softAssert.assertTrue(orderIdOrderSuccessPage.startsWith("ORDER#"));

        System.out.println("Click on view my orders ");
        driver.findElement(By.xpath("//a[@data-testid='success-view-orders']")).click();


        //---------------------------------------------------------------------
        System.out.println("wait for my order page to load  ");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@data-testid='orders-count']")));

        System.out.println("get order details  ");
        Map<String,String> mapOfOrderedItem=new LinkedHashMap<>();

        String orderIdMyOrderPage=driver.findElement(By.xpath("//table[@data-testid='orders-table']/tbody/tr[1]/td[2]")).getText();
        String dateMyOrderPage=driver.findElement(By.xpath("//table[@data-testid='orders-table']/tbody/tr[1]/td[3]")).getText();
        String restaurantNameMyOrderPage=driver.findElement(By.xpath("//table[@data-testid='orders-table']/tbody/tr[1]/td[4]")).getText();
        String total=driver.findElement(By.xpath("//table[@data-testid='orders-table']/tbody/tr[1]/td[6]")).getText();
        String statusMyOrderPage=driver.findElement(By.xpath("//table[@data-testid='orders-table']/tbody/tr[1]/td[7]")).getText();

        mapOfOrderedItem.put("Order #",orderIdMyOrderPage );
        mapOfOrderedItem.put("Date",dateMyOrderPage);
        mapOfOrderedItem.put("Restaurant",restaurantNameMyOrderPage);
        mapOfOrderedItem.put("Total",total);
        mapOfOrderedItem.put("Status",statusMyOrderPage);

        System.out.println("Check order no is correct ");
        softAssert.assertEquals(orderIdMyOrderPage,orderIDOrderSuccessPage);

        System.out.println("varify amount paid");
        softAssert.assertEquals(total,paymentAmountOrderSuccessPage);

        System.out.println("Test case Completed ");
    }
}









