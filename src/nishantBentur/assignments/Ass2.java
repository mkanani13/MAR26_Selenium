package nishantBentur.assignments;

import nishantBentur.base.BrowserActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Ass2 {
    WebDriver driver;

    @Test
    void aa_invalidPasswordCheck() {
        driver = BrowserActions.start();

        System.out.println("STEP- Navigate to Registration tab");
        driver.findElement(By.id("registration2")).click(); //Click on "Registration" tab

        System.out.println("STEP- Enter user credentials");
        driver.findElement(By.id("unameSignin")).sendKeys("nishant");
        WebElement password = driver.findElement(By.id("pwdSignin"));
        password.sendKeys("abcd123");
        driver.findElement(By.id("btnsubmitdetails")).click();
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        String expectedMessage = "Failed! please enter strong password";

        Assert.assertTrue(alertMessage.trim().equals(expectedMessage));
        alert.accept();
    }

    @Test
    void ab_validPasswordCheck(){
        System.out.println("STEP- Enter user credentials again");
        WebElement password = driver.findElement(By.id("pwdSignin"));
        password.clear();
        password.sendKeys("abcdef123456");
        driver.findElement(By.id("btnsubmitdetails")).click();
        Alert alert1 = driver.switchTo().alert();
        String alertMessage1 = alert1.getText();

        Assert.assertTrue("Success!".equals(alertMessage1.trim()));
        alert1.accept();
        driver.quit();
    }
}