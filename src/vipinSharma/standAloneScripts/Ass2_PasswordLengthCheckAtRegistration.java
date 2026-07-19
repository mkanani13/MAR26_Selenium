// Selenium Assignment - 2: 9th June'2026

// Condition 1:-
//Enter values in:
//User Name field
//Password field (must provide less than 8 characters)
//Click on the Submit button (Green Tick icon) to complete registration.
//Alert message should pop-up "Failed! please enter strong password"

//Condition 2:-
// Enter values in:
// User Name field
// Password field (must provide greater than 8 characters)
// Click on the Submit button (Green Tick icon) to complete registration.
// Alert message should pop-up "Success!"

package vipinSharma.standAloneScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Ass2_PasswordLengthCheckAtRegistration {
    WebDriver driver;

    // Declare variables at class level
    WebElement userName;
    WebElement password;
    WebElement submitBtn;

    @BeforeTest
    public void setUp() {
        System.out.println("STEP - WebDriver Initializing and Browser Launched");
        driver = new ChromeDriver();
        System.out.println("STEP - URL Navigation");
        driver.get("http://automationbykrishna.com/");
        System.out.println("STEP - Page Verification after redirect");
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Login Signup Demo";
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Page title not match!");
        System.out.println("STEP - Registration link click");
        driver.findElement(By.id("registration2")).click();

    }

    @AfterTest
    public void setupEnd() {
        driver.quit();
        System.out.println("Browser closed");
    }

     public void loginDetailsPageElements() throws InterruptedException{
        Thread.sleep(1000);
        userName = driver.findElement(By.id("unameSignin"));
        password = driver.findElement(By.id("pwdSignin"));
        submitBtn = driver.findElement(By.id("btnsubmitdetails"));

    }

    @Test
    public void InvalidLoginCheck() throws InterruptedException {
        loginDetailsPageElements();
        System.out.println("STEP - Login details fill and login button click");
        userName.sendKeys("Vipin23");
        password.sendKeys("Vipin@12");
        submitBtn.click();
        System.out.println("STEP - Verify login Fail message with less then 8 characters");
        Alert alert = driver.switchTo().alert();
        String expectedAlertTxt = "Failed! please enter strong password";
        String actualAlertTxt = alert.getText();
        Assert.assertEquals(actualAlertTxt, expectedAlertTxt, "Login message did not match!");
        alert.accept();
        System.out.println("Alert Ok button click");
    }
        @Test
        public void validLoginCheck() throws InterruptedException {
        loginDetailsPageElements();
        System.out.println("STEP - STEP - Verify login success message with more then 8 characters");
        Thread.sleep(1000);
            System.out.println("Login details fill and login button click");
            userName.sendKeys("Vipin23");
            password.sendKeys("Vipin@12345");
            submitBtn.click();
            System.out.println("STEP - Verify login Fail message with less then 8 characters");
            Alert alert = driver.switchTo().alert();
            String expectedAlertTxt = "Success!";
            String actualAlertText = alert.getText();
            Assert.assertEquals(expectedAlertTxt, actualAlertText, "Login message did not match!");
            System.out.println("STEP - Alert Ok button click");
            alert.accept();
    }
}