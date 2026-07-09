package smratiGarg.assignments;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Asgn06_javascript {
@Test
    public void main() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http:automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        Thread.sleep(2000);

        WebElement alertBtn = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", alertBtn);
        Thread.sleep(3000);
        String name="smrati";
        alertBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(name);
        Thread.sleep(3000);
        alert.accept();
        String ActualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
        Assert.assertTrue(ActualText.contains(name));

    }
    }
