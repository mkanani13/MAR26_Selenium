package technocredits.technoapp.testscripts;

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
import technocredits.technoapp.base.BrowserActions;
import technocredits.technoapp.pages.LoginPage;
import technocredits.technoapp.pages.RestaurantsPage;

import java.time.Duration;
import java.util.regex.Pattern;

public class Tc2_1 {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserActions.start("http://34.173.201.53/access#/login");
        LoginPage loginPage = new LoginPage();
        loginPage.doLogin();
    }

    @Test
    public void verifyPlaceOrderFeature(){
        System.out.println("STEP - Select location as Baner");
        RestaurantsPage restaurantsPage = new RestaurantsPage();
        restaurantsPage.waitForPageLoad();
        restaurantsPage.setLocationInDropdown("Baner");

        System.out.println("STEP - Click on View & Order of the restaurants having dishes");
        String restaurantName = driver.findElement(By.xpath("(//div[@data-testid = 'restaurants-grid']//p[not(contains(text(),' 0 dishes'))])[1]/preceding-sibling::h3")).getText().trim();
        driver.findElement(By.xpath("(//div[@data-testid = 'restaurants-grid']//p[not(contains(text(),' 0 dishes'))]/following::a[1])[1]")).click();

        System.out.println("STEP - From the restaurant menu, locate the first food item whose Stock value is greater than 0 and increase its quantity by clicking the Qty Up Arrow.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='proceed-checkout-btn']")));

        System.out.println("VERIFY - Navigated to Selected Restaurant Menu");
        String restaurantMenu_RestaurantName = driver.findElement(By.xpath("//h2[@data-testid='restaurant-name']")).getText();
        Assert.assertEquals(restaurantMenu_RestaurantName, restaurantName);

        String dish = driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][text()!='0'])[1]/preceding-sibling::td[3]/div/div/div[1]")).getText();
        WebElement qElement  = driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][text()!='0'])[1]/following-sibling::td[1]/input"));
        qElement.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_UP).perform();

        System.out.println("VERIFY - that the cart Subtotal is greater than 0.");
        String subTotalText = driver.findElement(By.xpath("//strong[@id='ot-subtotal']")).getText();
        subTotalText = subTotalText.substring(1); // "180.00"
        double subTotalPrice = Double.parseDouble(subTotalText); // 180.00
        Assert.assertTrue(subTotalPrice>0);

        System.out.println("STEP - Click the Proceed to Checkout → button.");
        driver.findElement(By.xpath("//button[@data-testid='proceed-checkout-btn']")).click();

        System.out.println("STEP - In the Delivery Details section, Enter a valid delivery address.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='checkout-continue']")));
        driver.findElement(By.xpath("//textarea[@id='co-address']")).sendKeys("Wakad");

        System.out.println("STEP - Enter a valid mobile number");
        driver.findElement(By.xpath("//input[@id='co-mobile']")).sendKeys("9765463742");

        System.out.println("Capture total payable amount in checkout order summary");
        String orderSummaryTotalPayableAmt = driver.findElement(By.xpath("//span[@data-testid='checkout-payable']")).getText();

        System.out.println("STEP - Click the Continue to Payment button.");
        driver.findElement(By.xpath("//button[@data-testid='checkout-continue']")).click();

        System.out.println("Capture total payable in the payment section");
        String paymentSummaryTotalPayableAmt = driver.findElement(By.xpath("//span[@data-testid='payment-total']")).getText();

        System.out.println("VERIFY - that the amount displayed in the Payable section of the Order Summary screen matches the amount displayed in the Total Payable section of the Bill screen.");
        Assert.assertEquals(paymentSummaryTotalPayableAmt, orderSummaryTotalPayableAmt);

        System.out.println("STEP - Click on Pay & Place Order");
        driver.findElement(By.xpath("//button[@id='pay-btn']")).click();

        System.out.println("VERIFY - Confirm the capta error notification displayed");
        boolean captaFlag = driver.findElement(By.xpath("//div[text()='Please confirm the captcha before paying']")).isDisplayed();
        Assert.assertTrue(captaFlag);

        System.out.println("STEP - Click on Capta checkbox");
        driver.findElement(By.xpath("//input[@id='pay-captcha']")).click();

        System.out.println("STEP - Click on Pay & Place Order");
        driver.findElement(By.xpath("//button[@id='pay-btn']")).click();

        System.out.println("VERIFY - Confirm the UPI ID error notification displayed");
        boolean upiFlag = driver.findElement(By.xpath("//div[text()='Enter a valid UPI ID (name@bank)']")).isDisplayed();
        Assert.assertTrue(upiFlag);

        System.out.println("STEP - Enter a valid UPI ID in the payment field.");
        driver.findElement(By.xpath("//input[@id='f-upi']")).sendKeys("mkanani@okhdfcbank");

        System.out.println("STEP - Click on Pay & Place Order");
        driver.findElement(By.xpath("//button[@id='pay-btn']")).click();

        SoftAssert softAssert = new SoftAssert();
        System.out.println("VERFIY - that the Order Placed screen is displayed and contains the following details under the Track Order section");
        boolean orderFlag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Order placed!']"))).isDisplayed();

        System.out.println("VERIFY - Order Placed text is displayed");
        softAssert.assertTrue(orderFlag);

        System.out.println("VERIFY - Restaurant Details");
        String orderSummaryPage_restuarantName = driver.findElement(By.xpath("//strong")).getText();
        softAssert.assertEquals(orderSummaryPage_restuarantName, restaurantName);

        System.out.println("VERFIY - Amount Paid");
        String orderSummaryPage_amountPaid = driver.findElement(By.xpath("//span[@data-testid='success-amount']")).getText();
        softAssert.assertEquals(orderSummaryPage_amountPaid,paymentSummaryTotalPayableAmt);

        System.out.println("VERIFY - Order id format is as expected");
        String orderSummaryPage_orderId = driver.findElement(By.xpath("//span[@data-testid='success-order-number']")).getText();
        softAssert.assertTrue(orderSummaryPage_orderId.startsWith("ORDER#"));

        System.out.println("VERIFY - Payment Method (Paid Via)");
        String orderSummaryPage_paymentMethod = driver.findElement(By.xpath("//span[text()='Paid via']/following-sibling::span")).getText();
        softAssert.assertEquals(orderSummaryPage_paymentMethod, "UPI");
        softAssert.assertAll();

        System.out.println("STEP - Click on View my orders");
        driver.findElement(By.xpath("//a[@data-testid='success-view-orders']")).click();

        System.out.println("VERIFY - Order is displayed in the list");
        
    }

}
