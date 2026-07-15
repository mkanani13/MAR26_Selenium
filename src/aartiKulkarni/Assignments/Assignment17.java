package aartiKulkarni.Assignments;

import aartiKulkarni.technoApp.base.BrowserActions;
import aartiKulkarni.technoApp.base.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

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
public class Assignment17 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup(){
         driver= BrowserActions.start("http://34.66.197.232/#/access");
         wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://34.66.197.232/#/access");
        LoginPage loginPage=new LoginPage();
        loginPage.doLogin();
    }

    @Test
    public void orderFlow(){
        System.out.println("Select the location In dropdown");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='locality-filter']")));
        WebElement locationDD=driver.findElement(By.xpath("//select[@id='locality-filter']"));
        Select select=new Select(locationDD);
        select.selectByVisibleText("Kothrud");

        System.out.println("Click on abhishek pure veg ");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Abhishek Pure Veg ']")));
        driver.findElement(By.xpath("//h3[text()='Abhishek Pure Veg ']/following::a[1]")).click();


        System.out.println("increase the quantity");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='proceed-checkout-btn']")));
        WebElement quantityloc=driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][not(text()='0')])[1]/following::input[1]"));
        quantityloc.click();
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ARROW_UP).perform();

        System.out.println("get sutotal");
        String subtotal=driver.findElement(By.xpath("//strong[@id='ot-subtotal']")).getText();
        subtotal=subtotal.substring(1);
        double subTotal=Double.parseDouble(subtotal);
        //SoftAssert softAssert=new SoftAssert();
        Assert.assertTrue(subTotal>0);

       driver.findElement(By.xpath("//button[@id='proceed-checkout-btn']")).click();

        System.out.println("enter address");
        driver.findElement(By.xpath("//textarea")).sendKeys("pimple gurav");
        driver.findElement(By.xpath("//input[@id='co-mobile']")).sendKeys("9309087270");
        driver.findElement(By.xpath("//button[@id='co-continue']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='pay-btn']")));
        driver.findElement(By.xpath("//input[@id='f-upi']")).sendKeys("aarti@icic");
        driver.findElement(By.xpath("//input[@id='pay-captcha']")).click();

        driver.findElement(By.xpath("//button[@id='pay-btn']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Order placed!']")));
        String pageTitle=driver.getTitle();
        System.out.println(pageTitle);

        String orderno=driver.findElement(By.xpath("//span[@data-testid='success-order-number']")).getText();

        System.out.println("click on my orders");
        driver.findElement(By.xpath("//a[@data-testid='success-view-orders']")).click();

        driver.findElement(By.xpath("//input[@id='filter-search']")).sendKeys(orderno);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@id='orders-tbody']/tr")));
        List<WebElement> row = driver.findElements(By.xpath("//table//tbody/tr[td[contains(text(),orderno)]]"));

        Assert.assertEquals(row,1);

        System.out.println("order varified successfully");
        System.out.println("Test case completed ");




    }


}
