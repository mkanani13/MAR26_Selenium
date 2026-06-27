package smratiGarg.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public class Asgn17to19RestroStandAloneTest {

    //(//table[@data-testid='menu-table']/tbody/tr/td[4][text()!='0'])[1]/preceding-sibling::td[3]/div/div/div[1]
    // WebDriver driver = new ChromeDriver();
    @Test
    public void restaurant() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        // -------> BrowserAction and passing URL
        System.out.println("launch browser and navigate to site");
        driver.manage().window().maximize();
        driver.get("http://34.66.197.232/#/access");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // -------> LoginPage
        System.out.println("enter access id and password and click");
        driver.findElement(By.xpath("//input[@id='access-student-id']"))
                .sendKeys("39WJAEGT2P");
        driver.findElement(By.xpath("//input[@id='access-code']"))
                .sendKeys("ZJ9KCRZQ");
        driver.findElement(By.xpath("//form[@id='access-form']/button"))
                .click();

        // -------> AppSelectingPage
        System.out.println("enter food app");
        driver.findElement(By.xpath("//button[@data-testid='choose-food']"))
                .click();

        SoftAssert softAssert = new SoftAssert();

        // -------> FoodAppLoginPage
        System.out.println("customer id and password");
        driver.findElement((By.xpath("//input[@id='login-email']")))
                .sendKeys("smrati@technocredits.com");
        driver.findElement((By.xpath("//input[@id='login-password']")))
                .sendKeys("pass@123");
        driver.findElement(By.xpath("//button[@data-testid='login-submit-btn']"))
                .click();

        // -------> FindFoodPage
        System.out.println("to check customer name is present on top ");
        String expectedNameValue = "smrati garg";
        String actualText = driver.findElement(By.xpath("//header/div/div/span[2]")).getText();

        boolean userNameVerification = actualText.toUpperCase().contains(expectedNameValue.toUpperCase());

        softAssert.assertTrue(userNameVerification, "User name expected is: " + expectedNameValue + " which is not found in header: " + actualText);
        softAssert.assertAll();

        System.out.println("select location kothrud");
        WebElement dropdownelement = driver.findElement(By.xpath("//select[@id='locality-filter']"));
        Select location = new Select(dropdownelement);
        String locationToSelect = "Kothrud";
        location.selectByValue(locationToSelect);

        System.out.println("click view and order button");
        driver.findElement(By.xpath("(//h3[contains(text(),'Abhishek Pure Veg')]/following::a[text()='View & order'])[1]")).click();
        //------------- RestaurantMenuPage

        System.out.println("from the restraurent menu locate first food item whose stock value is greater than 0 and increase it to 1");
        String dish= driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][text()!='0'])[1]/preceding-sibling::td[3]/div/div/div[1]")).getText();
        WebElement qtyinputElement= driver.findElement(By.xpath("(//table[@data-testid='menu-table']/tbody/tr/td[4][text()!='0'])[1]/following-sibling::td[1]/input"));
        qtyinputElement.click();
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ARROW_UP).perform();

        System.out.println("VERIFY card total is greter than 0 ");
        String subTotalText = driver.findElement(By.xpath("//strong[@id='ot-subtotal']")).getText();
        subTotalText = subTotalText.substring(1);
        double subTotalPrice = Double.parseDouble(subTotalText);
        Assert.assertTrue(subTotalPrice>0);

        System.out.println("step click proceed checkout button");
        driver.findElement(By.xpath("//button[@id='proceed-checkout-btn']")).click();

        //-----------------order summery page
        System.out.println("step -In the delivery details section,enter address and phone number");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='co-continue']")));
        driver.findElement(By.xpath("//textarea[@id='co-address']")).sendKeys("wagholi");
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("9343767284");

        System.out.println("capture total payable amount in checkout order summery");
        String orderSummeryTotalPayableAmount = driver.findElement(By.xpath( "//span[@data-testid='checkout-payable']")).getText();

        System.out.println("step click the continue to payment button");
        driver.findElement(By.xpath("//button[@id='co-continue']")).click();

        System.out.println("capture total payable amount in payment summery");
        String paymentSummeryTotalPayableAmount = driver.findElement(By.xpath( " //span[@data-testid='payment-total']")).getText();

        System.out.println("verify order summery payment amount is equal tp total payment amount");
        Assert.assertEquals(paymentSummeryTotalPayableAmount,orderSummeryTotalPayableAmount);
        //------------------FoodPaymentPage
        System.out.println("step enter valid UPI");
        driver.findElement(By.xpath("//input[@id='f-upi']")).sendKeys("smratigarg@hdfcbank");

        System.out.println("step to click checkbox");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

        System.out.println("click on pay and place order");
        driver.findElement(By.xpath("//button[@id='pay-btn']")).click();
        //-----------------------------

        SoftAssert softAssert1 = new SoftAssert();
        System.out.println("verify that order placed screen is displayed and contains the following details under the track order section");
        boolean orderFlag=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='order placed!']"))).isDisplayed();

        System.out.println("verify order placed text is displayed");
        softAssert.assertTrue(orderFlag);
        System.out.println("verify restaurant details");

        //Thread.sleep(2000);
     //   driver.quit();

    }

}