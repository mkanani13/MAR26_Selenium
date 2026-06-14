package kamleshDeshmukh;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import technocredits.base.BrowserActions;

public class Assignment2  {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.out.println("STEP - Browser Launch");
        driver = BrowserActions.start();
    }

    @Test
    public void verifyAlertTextWithInvalidPassword() {

        System.out.println("Scenario1 = Verify invalid password scenario");

        System.out.println("STEP = Click Registration tab");
        driver.findElement(By.xpath("//a[@id=\"registration2\"]")).click();


        System.out.println("STEP = Enter Username");
        driver.findElement(By.xpath("//input[@id=\"unameSignin\"]")).sendKeys("kamleshD1");

        System.out.println("STEP = Enter invalid Password");
        WebElement password = driver.findElement(By.xpath("//input[@id=\"pwdSignin\"]"));
        password.sendKeys("kamles");

        System.out.println("STEP = Click the Submit button");
        WebElement submitButton = driver.findElement(By.id("btnsubmitdetails"));
        submitButton.click();

        System.out.println("STEP = Switch to alert pop-up.");
        Alert alt = driver.switchTo().alert();
        String alrertMessage = alt.getText();
        Assert.assertEquals(alrertMessage, "Failed! please enter strong password");
        alt.accept();
        System.out.println("STEP = Registration unsuccessful!");

    }

    @Test
    public void verifyAlertTextWithValidPassword() {
        System.out.println("Scenario2 = Verify invalid password scenario");
        System.out.println("STEP = Click Registration tab");
        driver.findElement(By.xpath("//a[@id=\"registration2\"]")).click();


        System.out.println("STEP = Enter Username");
        driver.findElement(By.xpath("//input[@id=\"unameSignin\"]")).sendKeys("kamleshD1");

        System.out.println("STEP = Enter invalid Password");
        WebElement password = driver.findElement(By.xpath("//input[@id=\"pwdSignin\"]"));
        password.sendKeys("kamles123");

        System.out.println("STEP = Click the Submit button");
        WebElement submitButton = driver.findElement(By.id("btnsubmitdetails"));
        submitButton.click();

        Alert alt = driver.switchTo().alert();
        String successMessage = alt.getText();
        Assert.assertEquals(successMessage, "Success!");
        alt.accept();
        System.out.println("STEP- Registration successful.");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("STEP- Close the browser.");
        if (driver != null) {
            driver.quit();
        }
    }


}



