package raghunathMate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assignment_9 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        WebElement checkBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[7]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", checkBox);
        WebElement checkbox_1 = driver.findElement(By.xpath("//input[@id ='inlineCheckbox1']"));
        checkbox_1.click();
        Thread.sleep(2000);
        if (checkbox_1.isSelected()) {
            System.out.println("Given check box with value 1 has been clicked");
        } else {
            System.out.println("Given check box has not clicked");
        }
        driver.quit();
    }
}
