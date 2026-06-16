package raghunathMate;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment_4 {
    @Test
    void main() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://automationbykrishna.com/");
        Thread.sleep(1000);
        driver.findElement(By.id("basicelements")).click();
        Thread.sleep(1000);
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        WebElement altButton = driver.findElement(By.id("javascriptAlert"));
        js.executeScript("arguments[0].scrollIntoView(true);",altButton);
        altButton.click();
        String expMsg = "You must be TechnoCredits student!!";
        Alert alt = driver.switchTo().alert();
        String actualMsg = alt.getText();
        Assert.assertEquals(expMsg,actualMsg);
        alt.accept();
        driver.quit();
    }
}
