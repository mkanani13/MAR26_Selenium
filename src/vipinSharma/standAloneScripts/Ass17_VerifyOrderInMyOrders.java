package vipinSharma.standAloneScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ass17_VerifyOrderInMyOrders {
    WebDriver driver;

    @BeforeTest
    public void browserLaunch() {
        System.out.println("STEP - WebDriver Initializing and Browser Launched");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void setupEnd() {
        driver.quit();
        System.out.println("Browser closed");
    }

    public void navigationSteps() {
        System.out.println("STEP - URL Navigation");
        driver.get("http://34.66.197.232/#/access");
        System.out.println("STEP - Page Verification after redirect");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Access · Technocredits";
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Page title not match!");
    }

    public void accessSteps() {
        System.out.println("STEP - Access code details fill and login");
        driver.findElement(By.id("access-student-id")).sendKeys("BFSCSZXE23");
        driver.findElement(By.id("access-code")).sendKeys("AKE3CCSU");
        driver.findElement(By.xpath("//button[text()='Continue']")).click();
        System.out.println("STEP - Page Verification after access code entry");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actualPageHeading= driver.findElement(By.xpath("//h1[text()='Choose your application']")).getText();
        String expectedPageHeading = "Choose your application";
        Assert.assertEquals(actualPageHeading, expectedPageHeading, "Page heading not match!");

        //WebElement chooseApp = driver.findElement(By.xpath("//button[@data-testid='choose-food']//span"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement chooseApp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='choose-food']//span")));
        System.out.println("STEP - Choose your application");
        chooseApp.click();
        System.out.println("STEP - Page Verification after choose your application");
        String actualPgTitle = driver.getTitle();
        String expectedPgTitle = "Sign in · Technocredits";
        Assert.assertEquals(actualPgTitle, expectedPgTitle, "Page title not match!");

    }

    public void loginSteps(){
        System.out.println("STEP - Login details entry and click on login button");
        WebElement email= driver.findElement(By.xpath("//input[@data-testid='login-email']"));
        WebElement password= driver.findElement(By.id("login-password"));
        email.sendKeys("user@technocredits.com");
        password.sendKeys("User@123");
        driver.findElement(By.xpath("//button[@data-testid='login-submit-btn']")).click();
    }

    @Test
    public void verifyUsername(){
        navigationSteps();
        accessSteps();
        loginSteps();
        System.out.println("STEP - Verify UserName after login");
        WebElement userName= driver.findElement(By.xpath("//span[@class='whitespace-nowrap text-slate-100 text-xs']/span"));
        String actualUserName= userName.getText();
        String expectedUserName = "Customer";
        Assert.assertEquals(expectedUserName, actualUserName, "Username not match!");

    }

    @Test
    public void verifyOrderProcess(){
        navigationSteps();
        accessSteps();
        loginSteps();

        System.out.println("STEP - In locality dropdown select Kothrud");
        WebElement drp= driver.findElement(By.id("locality-filter"));
        Select selectDrp = new Select(drp) ;
        selectDrp.selectByVisibleText("Kothrud");
        WebElement selectValue = selectDrp.getFirstSelectedOption();
        System.out.println("STEP - Verify Dropdown value selected value and expected value");
        String actualSelectValueText= selectValue.getText();
        String expectedSelectValueText = "Kothrud";
        Assert.assertEquals(expectedSelectValueText, actualSelectValueText, "Selected value not match!");

        System.out.println("STEP - Click the View & Order button");
        WebElement viewOrderBTN= driver.findElement(By.xpath("(//div[@id='restaurants-grid']/div/div[1]//p[1][not(contains(text(),'0 dishes'))])/../../..//a[text()='View & order']"));
        viewOrderBTN.click();

        System.out.println("STEP - Add any available (in-stock) dish to the shopping cart");
        WebElement addDish= driver.findElement(By.xpath("(//tbody//tr//input[@max>0])[1]"));
        addDish.clear();
        addDish.sendKeys("2");

        System.out.println("STEP - Verify that the cart displays a subtotal greater than zero.");
        WebElement subTotal= driver.findElement(By.xpath("//strong[@id='ot-subtotal']"));
        String subTotalAmt = subTotal.getText().replaceAll("[^0-9]", "");
        int actualsubTotalAmt= Integer.parseInt(subTotalAmt);
        Assert.assertTrue(actualsubTotalAmt > 0 ,"Subtotal is not greater than zero!");


        System.out.println("STEP - Click on proceed to checkout button");
        driver.findElement(By.xpath("//button[@id='proceed-checkout-btn']")).click();

        System.out.println("STEP - Enter a valid delivery address and mobile number and click on continue button");
        driver.findElement(By.xpath("//textarea[@id='co-address']")).sendKeys("Manglam Garden city Jaipur");
        driver.findElement(By.xpath("//input[@id='co-mobile']")).sendKeys("9999260901");
        driver.findElement(By.xpath("//button[@id='co-continue']")).click();

        System.out.println("STEP - Enter UPI Id");
        driver.findElement(By.id("f-upi")).sendKeys("test@test");

        System.out.println("STEP - Select the checkbox - I am not a robot — confirm before placing order");
        driver.findElement(By.id("pay-captcha")).click();

        System.out.println("STEP - Click the Place Order button");
        driver.findElement(By.id("pay-btn")).click();

        System.out.println("STEP - Verify that the Order placed! page is displayed");

        String actualPageHeader = driver.findElement(By.xpath("//h1[text()='Order placed!']")).getText();
        String expectedPageHeader = "Order placed!";
        Assert.assertEquals(expectedPageHeader, actualPageHeader, "Page header not match!");
        String orderNumber= driver.findElement(By.xpath("//span[@data-testid='success-order-number']")).getText();

        System.out.println("STEP - Verify that the My Orders page is displayed");
        driver.findElement(By.xpath("//a[@data-testid='success-view-orders']")).click();
        driver.findElement(By.xpath("//input[@id='filter-search']")).sendKeys(orderNumber);
        WebElement seachOrderNumber = driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr/td[1][text()='" + orderNumber +"']"));
        String actualorderNumber= seachOrderNumber.getText();
        Assert.assertEquals(orderNumber, actualorderNumber, "Page header not match!");
    }

}
