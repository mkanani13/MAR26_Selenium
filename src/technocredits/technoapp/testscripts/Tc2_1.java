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
        driver.findElement(By.xpath("(//div[@data-testid = 'restaurants-grid']//p[not(contains(text(),' 0 dishes'))]/following::a[1])[1]")).click();

        System.out.println("STEP - From the restaurant menu, locate the first food item whose Stock value is greater than 0 and increase its quantity by clicking the Qty Up Arrow.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='proceed-checkout-btn']")));
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


    }
}
