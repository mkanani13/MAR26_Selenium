// Selenium Assignment - 3: 9th June'2026
//Automate the following scenario using Selenium WebDriver in Java:
//Open the application: http://automationbykrishna.com/
//Click on the “Basic Elements” tab/button.
//Enter values in:
//FirstName field
//LastName field
//CompanyName field
//Click on the Submit button.
//Alert message should pop-up "FirstName and LastName and CompanyName"

package automationScritps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ass3_BasicElementsDetails {
    WebDriver driver;

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
        System.out.println("STEP - Basic Elements link click");
        driver.findElement(By.id("basicelements")).click();

    }

    @AfterTest
    public void setupEnd() {
        driver.quit();
        System.out.println("Browser closed");
    }

   @Test
    public void verifyAlertText() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("STEP - Login details fill and submit button click");
        driver.findElement(By.name("ufname")).sendKeys("Vipin");
        driver.findElement(By.name("ulname")).sendKeys("Sharma");
        driver.findElement(By.name("cmpname")).sendKeys("TechnoCredit");
        driver.findElement(By.xpath("(//*[text()='Submit'])[1]")).click();
        Thread.sleep(1000);
        System.out.println("STEP - Verification of alert message");
        Alert alert= driver.switchTo().alert();
        String actualAlertText = alert.getText();
        String expectedAlertText = "Vipin and Sharma and TechnoCredit";
       Assert.assertEquals(actualAlertText, expectedAlertText, "Alert message did not match!");
       System.out.println("STEP - Alert Ok button click");
       alert.accept();

    }
}