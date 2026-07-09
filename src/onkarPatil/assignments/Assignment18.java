package onkarPatil.assignments;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment18 {

    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("http://34.66.197.232/#/access");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test
    public void orderItemsAndVerifyOrder() throws InterruptedException {
        System.out.println("STEP- Login to the application");
        driver.findElement(By.id("access-student-id")).sendKeys("TS5FU2Z2ND");
        driver.findElement(By.id("access-code")).sendKeys("P4VY95MB");
        driver.findElement(By.xpath("//button[@data-testid='access-submit-btn']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='choose-food']")));
        driver.findElement(By.xpath("//button[@data-testid='choose-food']")).click();
        WebElement emailInput = driver.findElement(By.id("login-email"));
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys("patilonkar18@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("Devansh@1");
        driver.findElement(By.xpath("//button[@data-testid='login-submit-btn']")).click();

        System.out.println("VERIFY- Logged in user's name is displayed in top navigation bar");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("locality-filter")));
        String userName = driver.findElement(By.xpath("//span[contains(text(),'onkarpatil')]")).getText();
        Assert.assertTrue(userName.contains("onkarpatil"));

        System.out.println("STEP- Select Baner from locality filter");
        WebElement localityFilter = driver.findElement(By.id("locality-filter"));
        Select select = new Select(localityFilter);
        select.selectByVisibleText("Baner");

        System.out.println("STEP- Select the restaurant which has atleast one dish available and click 'View & Order button'");
        WebElement firstRestaurant = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[@class='text-xs text-slate-500'][not(contains(text(),' 0 dishes'))])[1]/following::a[1]")));
        String restaurantNameRaw = driver.findElement(By.xpath("(//p[@class='text-xs text-slate-500'][not(contains(text(),' 0 dishes'))])[1]/preceding::h3")).getText();
        String currentRestaurant = restaurantNameRaw.replaceAll("Veg", "").trim();
        firstRestaurant.click();

        System.out.println("STEP- Add any available (in-stock) dish to the shopping cart");
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//tr[contains(@data-testid,'menu-row-dish')]/td[4][text()!='0'])[1]/following-sibling::td/input")));
        Actions action = new Actions(driver);
        addToCart.click();
        action.sendKeys(Keys.ARROW_UP).perform();

        System.out.println("VERIFY- Verify that the cart displays a subtotal greater than zero");
        String value = addToCart.getAttribute("value");
        Assert.assertEquals(value, "1");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.id("proceed-checkout-btn")));
        String payableAmtText = driver.findElement(By.id("ot-total")).getText().substring(1);
        double payableAmt = Double.parseDouble(payableAmtText);

        System.out.println("STEP- Checkout");
        driver.findElement(By.id("proceed-checkout-btn")).click();
        WebElement payableAmtCheckout = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@data-testid='checkout-payable']"))));
        String payableAmtTextCheckout = payableAmtCheckout.getText().substring(1);
        double payableAmtFinal = Double.parseDouble(payableAmtTextCheckout);

        System.out.println("VERIFY- Amount is shown correctly after checkout");
        Assert.assertEquals(payableAmtFinal, payableAmt);
        Assert.assertTrue(payableAmtFinal > 0);

        System.out.println("STEP- Enter a valid delivery address and mobile number");
        driver.findElement(By.id("co-address")).sendKeys("Wakad");
        driver.findElement(By.id("co-mobile")).sendKeys("1234567890");
        driver.findElement(By.id("co-continue")).click();

        System.out.println("STEP- Add Payment details, select captcha checkbox and Select pay button");
        WebElement captcha = wait.until(ExpectedConditions.elementToBeClickable(By.id("pay-captcha")));
        driver.findElement(By.id("f-upi")).sendKeys("onkar@sbi");
        captcha.click();
        driver.findElement(By.id("pay-btn")).click();

        System.out.println("STEP- Capture details for newly placed order");
        WebElement viewMyOrdersBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-testid='success-view-orders']")));
        String orderConfirmation = driver.findElement(By.xpath("//p[@class='text-slate-500']")).getText();
        String orderId = driver.findElement(By.xpath("//span[@data-testid='success-order-number']")).getText();
        String amountPaid = driver.findElement(By.xpath("(//span[@class='text-slate-500'])[2]/following-sibling::span")).getText();
        String paidVia = driver.findElement(By.xpath("(//span[@class='text-slate-500'])[3]/following-sibling::span")).getText();

        System.out.println("VERIFY- Verify details on the Order Placed page");
        Assert.assertTrue(orderConfirmation.contains(currentRestaurant));
        Assert.assertTrue(amountPaid.contains(payableAmtText));
        Assert.assertTrue(paidVia.equals("UPI"));

        System.out.println("VERIFY- Recent order is shown on My orders page");
        viewMyOrdersBtn.click();
        WebElement finalOrderPageElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[contains(@data-testid,'order-number')])[1]")));
        String finalOrderNum = finalOrderPageElement.getText();
        Assert.assertEquals(orderId, finalOrderNum);
    }

    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }
}
