package Amitjoshi.Assignments.Basics;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment2 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.id("registration2")).click();
    }

    @Test
    public void verifyStrongAndWeakPasswordMessages() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unameSignin"))).sendKeys("Maulik");
        WebElement password = driver.findElement(By.id("pwdSignin"));
        driver.findElement(By.id("rememberme")).click();

        password.sendKeys("kanani@12ad");
        driver.findElement(By.id("btnsubmitdetails")).click();
        Alert successAlert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(successAlert.getText(), "Success!", "A strong password should be accepted.");
        successAlert.accept();

        password.clear();
        password.sendKeys("Am@12");
        driver.findElement(By.id("btnsubmitdetails")).click();
        Alert failureAlert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(failureAlert.getText(), "Failed! please enter strong password",
                "A weak password should show the validation message.");
        failureAlert.accept();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}