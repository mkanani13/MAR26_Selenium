package aartiKulkarni.Assignments;

import aartiKulkarni.technoApp.base.BrowserActions;
import aartiKulkarni.technoApp.base.LoginPage;
import io.opentelemetry.api.trace.Span;
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

import java.security.cert.X509Certificate;
import java.time.Duration;

/*
Using Selenium WebDriver with Java, automate the following end-to-end food ordering scenario(Use Explicit Wait instead of Implicit Wait) with a Standalone Script:

1.Launch the browser and navigate to:
http://34.173.201.53/access#/login
2.Open the Login page.
3.Enter valid customer credentials (Email and Password).
4.Click the Login button.
5.Verify that the logged-in user's name is displayed in the top navigation bar.
6.From the Locality dropdown, select "Baner".
7.Identify the first restaurant in the list that has at least one available dish (non-zero dish count) within the selected locality (Balance Brew Cafe).
8.Click the "View & Order" button for the selected restaurant.
9.From the restaurant menu, locate the first food item whose Stock value is greater than 0 and increase its quantity by clicking the Qty Up Arrow.
10.Verify that the cart Subtotal is greater than 0.
11.Click the "Proceed to Checkout →" button.
12.In the Delivery Details section:
-Enter a valid delivery address.
-Enter a valid mobile number.
13.Click the "Continue to Payment →" button.
14.Verify that the amount displayed in the Payable section of the Order Summary screen matches the amount displayed in the Total Payable section of the Bill screen.
15.Enter a valid UPI ID in the payment field.
16.Select the "I'm not a robot — confirm before paying" checkbox.
17.Click the "Pay  & Place Order" button.
18.Verify that the Order Placed screen is displayed and contains the following details under the Track Order section:
-Restaurant Details
-Amount Paid
-Order Number
-Payment Method (Paid Via)
m
Expected Result

The order should be successfully placed, and the Order Placed screen should display the following under the Track Order section:

-Restaurant Details
-Amount Paid
-Order Number
-Payment Method (Paid Via)

 */
public class Assignment18 {
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
    public void foodOrderFlow(){
       String LOCALITYFILTER="//select[@id='locality-filter']";

        System.out.println("wait for page load ");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOCALITYFILTER)));
       WebElement locationDD= driver.findElement(By.xpath(LOCALITYFILTER));
       Select select=new Select(locationDD);
       select.selectByVisibleText("Baner");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@data-testid = 'restaurants-grid']//p[1][not(contains(text(),' 0 dishes'))]/following::a)[1]")));
        System.out.println("waited for grid ");

        System.out.println("Capture restaurant name ");
        String restaurantName=driver.findElement(By.xpath("(//div[@id='restaurants-grid']//div/p[not(contains(text(),'0 dishes'))]/preceding-sibling::h3)[1]")).getText();

        System.out.println("Click on view and order");
        driver.findElement(By.xpath("(//div[@data-testid = 'restaurants-grid']//p[1][not(contains(text(),' 0 dishes'))]/following::a)[1]")).click();

        System.out.println("locate the first item whose Stock value is greater than 0 and increase its quantity by clicking the Qty Up Arrow.");
        String PROCEEDTOCHECKOUTBTN="//button[@id='proceed-checkout-btn']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PROCEEDTOCHECKOUTBTN)));
        Actions actions=new Actions(driver);
        WebElement quantityElement= driver.findElement(By.xpath("//table[@data-testid='menu-table']/tbody/tr/td[4][not(contains(text(),0))]/following-sibling::td/input"));
        quantityElement.click();
        System.out.println("quantity element clicked");
        actions.sendKeys(Keys.ARROW_UP).perform();

        String quantity=quantityElement.getAttribute("value");
        Assert.assertEquals(quantity,"1");
        System.out.println("Increased quantity");

        System.out.println("Capture subtotal ");
        String subTotalMenuPage=driver.findElement(By.xpath("//strong[@id='ot-subtotal']")).getText();
        subTotalMenuPage=subTotalMenuPage.substring(1,6);
        int subTotal=Integer.parseInt(subTotalMenuPage);
        Assert.assertTrue(subTotal>0);
        System.out.println("Payable amount greater than 0");

        System.out.println("Click on proceed to checkout");
        driver.findElement(By.xpath(PROCEEDTOCHECKOUTBTN)).click();

        String payableAmtOrderSummeryPage=driver.findElement(By.xpath("//span[@data-testid='checkout-payable']")).getText();
        payableAmtOrderSummeryPage=payableAmtOrderSummeryPage.substring(1,5);
        double payableAmt=Double.parseDouble(payableAmtOrderSummeryPage);
        Assert.assertEquals(payableAmt,subTotal);
        System.out.println("Amount varified");
        driver.findElement(By.xpath("//textarea[@id='co-address']")).sendKeys("wakad");
        driver.findElement(By.xpath("//input[@id='co-mobile']")).sendKeys("9309098280");

        driver.findElement(By.xpath("//button[@id='co-continue']")).click();

        driver.findElement(By.xpath("//input[@id='f-upi']")).sendKeys("aarti@icic");
        driver.findElement(By.xpath("//input[@id='pay-captcha']")).click();
        driver.findElement(By.xpath("//button[@id='pay-btn']")).click();

        System.out.println("wait for oredr placed page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Order placed!']")));

        String restNameOrderSuccessPage=driver.findElement(By.xpath("//strong")).getText();
        String orderID=driver.findElement(By.xpath("//span[text()='Order number']/following-sibling::span")).getText();
        String amount=driver.findElement(By.xpath("//span[text()='Amount paid']/following-sibling::span")).getText();
        String paymentMode=driver.findElement(By.xpath("//span[text()='Paid via']/following-sibling::span")).getText();
        amount=amount.substring(1,6);
        int amt=Integer.parseInt(amount);

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(restNameOrderSuccessPage,restaurantName);
        softAssert.assertEquals(subTotal,amt);
        softAssert.assertEquals(paymentMode,"UPI");
        softAssert.assertTrue(orderID.startsWith("ORDER#"));

        softAssert.assertAll();
        System.out.println("Test case completed ");

    }

}
