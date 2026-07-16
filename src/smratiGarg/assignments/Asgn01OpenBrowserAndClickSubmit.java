package smratiGarg.assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Asgn01OpenBrowserAndClickSubmit {


    @Test
    public void BrowserOpen () throws InterruptedException{

        System.out.println("STEP - Open Browser and hit URL");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http:automationbykrishna.com/");

        System.out.println("STEP - click on registration link");
        driver.findElement(By.id("registration2")).click();

        System.out.println("STEP enter user name");
        driver.findElement(By.id("unameSignin")).sendKeys("smrati");

        System.out.println("STEP enter password");
        driver.findElement(By.id("pwdSignin")).sendKeys("smrati123");

        System.out.println("STEP click submit button");
        driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(true);
        String expectedAlertStr = "Success!";
        String actualAlertText = alert.getText();
        alert.accept();

        System.out.println("VERIFY alter text : expected text - "+expectedAlertStr+" ,actual text - "+actualAlertText);
        Assert.assertEquals(actualAlertText, expectedAlertStr);

    }
}
