package nishantBentur.assignments;

import nishantBentur.base.BrowserActions;
import nishantBentur.technocreditsFoodApp.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Ass17 {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        System.out.println("STEP-Launch TechnoCredits Pune Food Delivery");
<<<<<<< HEAD
        driver = BrowserActions.start("http://34.66.197.232/#/access");
=======
        driver = BrowserActions.start("http://34.173.201.53/#/access");
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe
        LoginPage loginPage = new LoginPage();
        loginPage.doLogin();

        System.out.println("STEP- Verify the logged in User");
        String loginName = driver.findElement(By.xpath("//header[@id='fd-header']/div/div/span[2]")).getText();
        System.out.println(loginName);
<<<<<<< HEAD
        //if(loginName.contains("Nishant Bentur"))
          //  System.out.println("User verified");
=======
        if(loginName.contains("Nishant Bentur"))
            System.out.println("User verified");
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe
    }

    @Test
    public void orderFood(){
        System.out.println("STEP- Select Kothrud locality");
        WebElement localityDDElement = driver.findElement(By.xpath("//select[@id='locality-filter']"));
        Select location = new Select(localityDDElement);
        location.selectByVisibleText("Kothrud");

        System.out.println("STEP- Select Abhishek Pure Veg --> View & Order");
        driver.findElement(By.xpath("//div[@data-testid = 'restaurants-grid']//h3[text()='Abhishek Pure Veg ']/following::a")).click();

        System.out.println("STEP- Add one quantity of Paneer tikka");
<<<<<<< HEAD
        WebElement paneerTikkaQtyElement = driver.findElement(By.xpath("//table[@data-testid='menu-table']/tbody/tr/td[5]/input[@data-name='Plain Roti']"));
=======
        WebElement paneerTikkaQtyElement = driver.findElement(By.xpath("//table[@data-testid='menu-table']/tbody/tr/td[5]/input[@data-name='Paneer Tikka']"));
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe
        paneerTikkaQtyElement.click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_UP).perform();

        System.out.println("STEP- Check Cart subtotal value");
        String subTotalValue = driver.findElement(By.xpath("//div[@id='order-totals']//strong[@id='ot-subtotal']")).getText().substring(1);
        Assert.assertNotEquals(subTotalValue,"0.00", "Subtotal is incorrect");

        System.out.println("STEP- Click on Proceed to Checkout button");
        driver.findElement(By.xpath("//button[@id='proceed-checkout-btn']")).click();

        System.out.println("STEP- Enter delivery details & click 'Continue to payment' button");
        WebElement addressField = driver.findElement(By.xpath("//textarea[@id='co-address']"));
        addressField.click();
        addressField.sendKeys("#1, A-wing, Wakad, Pune, 411057");
        WebElement contactNumberField = driver.findElement(By.xpath("//input[@id='co-mobile']"));
        contactNumberField.click();
        contactNumberField.sendKeys("+3409120912");
        driver.findElement(By.xpath("//button[@id='co-continue']")).click();

        System.out.println("STEP- Click on Iam not a robot captcha");
        WebElement iamNotRobotCheckbox = driver.findElement(By.xpath("//input[@id='pay-captcha']"));
        iamNotRobotCheckbox.click();
        Assert.assertTrue(iamNotRobotCheckbox.isDisplayed(), "Captcha not selected");

        System.out.println("STEP- Click on 'Pay and place order button' ");
        driver.findElement(By.xpath("//input[@id='f-upi']")).sendKeys("payFrom@anyBank");
        driver.findElement(By.xpath("//button[@id='pay-btn']")).click();

        System.out.println("VERIFY- ORder placed");
        String orderConfirmationText = driver.findElement(By.xpath("//h1[text()='Order placed!']")).getText();
        Assert.assertEquals(orderConfirmationText,"Order placed!");
    }

<<<<<<< HEAD
//    @AfterTest
//    public void tearDown(){
//        System.out.println("STEP- Closing the browser");
//        BrowserActions.closeBrowser();
//    }
=======
    @AfterTest
    public void tearDown(){
        System.out.println("STEP- Closing the browser");
        BrowserActions.closeBrowser();
    }
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe
}
