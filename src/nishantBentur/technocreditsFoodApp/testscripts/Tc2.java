package nishantBentur.technocreditsFoodApp.testscripts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Tc2 {

    @Test
    public void TestCase2(){
        System.out.println("STEP- Launch Browser & enter URL");
        WebDriver driver = new ChromeDriver();
        driver.get("http://34.173.201.53/#/access");
        driver.manage().window().maximize();

        System.out.println("STEP- Open Login Page");
        System.out.println("Enter student ID");
        driver.findElement(By.xpath("//input[@id='access-student-id']")).sendKeys("Z93GF63U37");
        System.out.println("Enter Access code");
        driver.findElement(By.xpath("//input[@id='access-code']")).sendKeys("S3WMAR4G");
        System.out.println("Click Continue");
        driver.findElement(By.xpath("//button[text()='Continue']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Food Ordering']/following-sibling::span"))).click();

        System.out.println("STEP- Enter email & password");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-email']"))).sendKeys("user@technocredits.com");
        driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("User@123");

        System.out.println("STEP- Click the Login button.");
        driver.findElement(By.xpath("//button[@data-testid='login-submit-btn']")).click();

        System.out.println("VERIFY- Logged in user from Top bar");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='restaurants-grid']")));

        System.out.println("STEP- From the Locality dropdown, select Baner");
        WebElement localityDDOption = driver.findElement(By.xpath("//select[@id='locality-filter']"));
        Select selectLocation = new Select(localityDDOption);
        selectLocation.selectByVisibleText("Baner");

        System.out.println("STEP- Identify first restaurant having atleast one dish & Click on View & Order");
        String restaurantName = driver.findElement(By.xpath("(//div[@data-testid = 'restaurants-grid']//p[not(contains(text(),' 0 dishes'))]/following::a[1])[1]/preceding-sibling::div//h3")).getText().trim();
        driver.findElement(By.xpath("(//div[@data-testid = 'restaurants-grid']//p[not(contains(text(),' 0 dishes'))]/following::a[1])[1]")).click();

        System.out.println("STEP- From the restaurant menu, locate the first food item whose Stock value is greater than 0 and increase its quantity by clicking the Qty Up Arrow.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='proceed-checkout-btn']")));
        WebElement dishQuantity = driver.findElement(By.xpath("(//div[@id='menu-host']//tbody/tr/td[4][text()!=0])[1]"));
        String dish = driver.findElement(By.xpath("(//div[@id='menu-host']//tbody/tr/td[4][text()!=0])[1]/preceding-sibling::td[3]//div/div/div[1]")).getText();
        dishQuantity.click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_UP);

        System.out.println("VERIFY- that the cart Subtotal is greater than 0.");
        String subTotalValue = driver.findElement(By.xpath("//strong[@id='ot-subtotal']")).getText().substring(1);
        Assert.assertEquals(subTotalValue,"180.00", "Subtotal calculation is Incorect");

        System.out.println("STEP- Click the Proceed to Checkout → button.");
        driver.findElement((By.xpath("//button[@id='proceed-checkout-btn']"))).click();

        System.out.println("STEP- Enter a valid delivery address.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='co-continue']")));
        driver.findElement(By.xpath("//textarea[@id='co-address']")).sendKeys("Wakad, Pune");

        System.out.println("STEP- Enter a valid phone number");
        driver.findElement(By.xpath("//input[@id='co-mobile']")).sendKeys("909090909090");
        String amountPayableAtCheckout = driver.findElement(By.xpath("//span[@data-testid='checkout-payable']")).getText();

        System.out.println("STEP- Click the Continue to Payment → button.");
        driver.findElement(By.xpath("//button[@id='co-continue']")).click();

        System.out.println("STEP- Verify that the amount displayed in the Payable section of the Order Summary screen matches the amount displayed in the Total Payable section of the Bill screen.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='pay-btn']")));
        String totalAmountPayableAtPayment = driver.findElement(By.xpath("//span[@data-testid='payment-total']")).getText();
        Assert.assertEquals(totalAmountPayableAtPayment, amountPayableAtCheckout, "Amount is not same as it was at the time of Checkout");

        System.out.println("STEP- Click on Pay & Order button & check the captcha notification");
        boolean captchaFlag = driver.findElement(By.xpath("")).isDisplayed();
        Assert.assertTrue(captchaFlag);

        System.out.println("STEP- Select the I'm not a robot — confirm before paying checkbox.");
        driver.findElement(By.xpath("//input[@id='pay-captcha']")).click();

        System.out.println("STEP- Click on Pay & Order button * check the enter valid upi notification");
        boolean upiCaptchaFlag = driver.findElement(By.xpath("//div[text()='Enter a valid UPI ID (name@bank)']")).isDisplayed();
        Assert.assertTrue(upiCaptchaFlag);

        System.out.println("STEP- Enter a valid UPI ID in the payment field.");
        driver.findElement(By.xpath("//input[@id='f-upi']")).sendKeys("ok@ok");

        System.out.println("STEP- Click on Pay & Place Order button.");
        driver.findElement(By.xpath("//button[@id='pay-btn']")).click();

        System.out.println("VERIFY- ORder details");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()]")));

        System.out.println("VERIFY-Restaurant Name in the Track Order page");
        SoftAssert softassert = new SoftAssert();
        String successPage_restaurantName = driver.findElement(By.xpath("//strong")).getText();
        softassert.assertTrue(successPage_restaurantName.contains(restaurantName));

        System.out.println("VERIFY- ORDER ID is starts with ORDER#");
        String successPage_OrderID = driver.findElement(By.xpath("//span[@data-testid='success-order-number']")).getText();
        softassert.assertTrue(successPage_OrderID.contains("ORDER#"));

        System.out.println("VERIFY - Amount paid in track order page");
        String successPage_amountPaid = driver.findElement(By.xpath("//span[@data-testid='success-amount']")).getText();
        softassert.assertEquals(successPage_amountPaid,totalAmountPayableAtPayment);

        System.out.println("VERIFY - Payment method in track order page");
        String successPage_paymentMethod = driver.findElement(By.xpath("//span[@data-testid='success-amount']/parent::div/following::div/span[2]")).getText();
        softassert.assertEquals(successPage_paymentMethod,"UPI");

        softassert.assertAll();

        System.out.println("STEP- Click on View my orders button");
        driver.findElement(By.xpath("//a[@data-testid='success-view-orders']")).click();

        System.out.println("VERIFY- Order ID is present in the My Order Page");
        WebElement searchInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='filter-search']")));
        searchInputField.click();
        searchInputField.sendKeys(successPage_OrderID);
        String orderID = driver.findElement(By.xpath("//tbody/tr/td[1]")).getText();
        Assert.assertEquals(orderID, successPage_OrderID);

    }
}
