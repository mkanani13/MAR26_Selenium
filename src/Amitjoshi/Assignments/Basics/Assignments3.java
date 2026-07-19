/*
Automate the following scenario using Selenium WebDriver in Java:

Open the application: http://automationbykrishna.com/
Click on the “Basic Elements” tab/button.

Enter values in:
FirstName field
LastName field
CompanyName field

Click on the Submit button.
Alert message should pop-up "FirstName and LastName and CompanyName"

 */
package Amitjoshi.Assignments.Basics;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignments3 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/");
    }

    @Test
    public void verifyBasicFormAlert() {
        String firstName = "Amit";
        String lastName = "Joshi";
        String companyName = "Amoha Recruitment Services";

        driver.findElement(By.id("basicelements")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("UserFirstName"))).sendKeys(firstName);
        driver.findElement(By.id("UserLastName")).sendKeys(lastName);
        driver.findElement(By.id("UserCompanyName")).sendKeys(companyName);
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[1]")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), firstName + " and " + lastName + " and " + companyName);
        alert.accept();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}