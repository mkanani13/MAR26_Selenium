// Selenium Assignment - 1: 8th June'2026
// Click on the Submit button (Green Tick icon) to complete registration.


package automationScritps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ass1_RegistrationSubmitButton {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.out.println("STEP - WebDriver Initializing and Browser Launched");
        driver = new ChromeDriver();
        System.out.println("STEP - URL Navigation");
        driver.get("http://automationbykrishna.com/");
    }

    @AfterTest
    public void setupEnd() {
        driver.quit();
        System.out.println("Browser closed");
    }

    @Test
    public void registration() throws InterruptedException {
        System.out.println("STEP - Registration link click");
        driver.findElement(By.id("registration2")).click();
        Thread.sleep(1000);
        System.out.println("STEP - Login details entered and login button click");
        driver.findElement(By.id("unameSignin")).sendKeys("Vipin23");
        driver.findElement(By.id("pwdSignin")).sendKeys("Vipin@1234");
        driver.findElement(By.id("btnsubmitdetails")).click();
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Login Signup Demo";
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Page title not match!");
    }
}