package Amitjoshi.Assignments.Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment1 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://automationbykrishna.com/#");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyLogin() {
        driver.findElement(By.id("registration2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unameSignin")));

        driver.findElement(By.id("unameSignin")).sendKeys("Maulik");
        driver.findElement(By.id("pwdSignin")).sendKeys("kanani@12");
        driver.findElement(By.id("rememberme")).click();
        driver.findElement(By.id("btnsubmitdetails")).click();

        String actualAlertMessage =
                wait.until(ExpectedConditions.alertIsPresent()).getText();

        Assert.assertEquals(actualAlertMessage,
                "Success!");

        driver.switchTo().alert().accept();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}