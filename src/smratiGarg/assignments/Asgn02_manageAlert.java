package smratiGarg.assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Asgn02_manageAlert {

    @Test
    public void BrowserOpen () throws InterruptedException{
    WebDriver driver = new ChromeDriver(); //launching chrome

        System.out.println("step -navigate tp automationbykrishna");
        driver.get("http://automationbykrishna.com");

        System.out.println("STEP click registration");
        driver.findElement(By.id("registration2")).click();

        System.out.println("STEP enter user name");
        driver.findElement(By.id("unameSignin")).sendKeys("smrati");

        System.out.println("STEP enter password");
        WebElement pwdInputElement = driver.findElement(By.id("pwdSignin"));
        pwdInputElement.sendKeys("smrati");

        System.out.println("step click on login button");

        WebElement btnsubmitdetails = driver.findElement(By.id("btnsubmitdetails"));
        btnsubmitdetails.click();
        System.out.println("step pointing to alert");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
         String alertText = alert.getText();
         String expMassage1 = "success";

        Assert.assertEquals(alertText,expMassage1);
        alert.accept();

        System.out.println("clear the txt of element");
        pwdInputElement.clear();
        pwdInputElement.sendKeys("smrati12");
        driver.findElement(By.id("btnsubmitdetails")).click();

        alert = driver.switchTo().alert();

        String alertText1 = alert.getText();
        String expMassage ="Failed! please enter strong password";
        Assert.assertEquals(expMassage,alertText1);
        alert.accept();
        driver.quit();
}
}

