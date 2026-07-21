package smratiGarg.assignments;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Asgn05_JSConfirmation {

    @Test
    public void alert() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http:automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();

        WebElement alertBtn = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", alertBtn);
        alertBtn.click();

        Alert alert = driver.switchTo().alert();
        String actualAlertMsg = alert.getText();
        Thread.sleep(2000);
        alert.dismiss();

        String ActualTextAfterCancel = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
        String expectedAlertTest = "You pressed Cancel!";
        Assert.assertEquals(ActualTextAfterCancel,expectedAlertTest);
        driver.quit();
    }
}


