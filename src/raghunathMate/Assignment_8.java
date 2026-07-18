package raghunathMate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment_8 {

    @Test
    void main()  {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        WebElement checkBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[7]"));
        WebElement redioButt_1 = driver.findElement(By.xpath("//input[@id='optionsRadios1']"));
        WebElement redioButt_2 = driver.findElement(By.xpath("//input[@id='optionsRadios2']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", checkBox);
        redioButt_2.click();
        redioButt_1.click();
        Assert.assertTrue(redioButt_1.isSelected());
        Assert.assertTrue(!redioButt_2.isSelected());
        driver.quit();
    }

}
