package smratiGarg.assignments;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Asgn04_ScrollDown {
    @Test
    public void scroll(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get ("http:automationbykrishna.com/");

        driver.findElement(By.id("basicelements")).click();

        WebElement alertBtn = driver.findElement(By.id("javascriptAlert"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",alertBtn);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        alertBtn.click();

        String expectedAlertMsg="You must be TechnoCredits student!!";
        Alert alert = driver.switchTo().alert();
        String actualAlertMsg = alert.getText();
        Assert.assertEquals(expectedAlertMsg,actualAlertMsg);
        alert.accept();
    }
}