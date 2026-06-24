package raghunathMate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment_7 {
    @Test
    void main()  {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        WebElement checkBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[7]"));
        JavascriptExecutor js  = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",checkBox);
        checkBox.click();
        Assert.assertTrue(checkBox.isSelected());
        driver.quit();
    }
}
