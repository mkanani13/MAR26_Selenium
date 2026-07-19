<<<<<<< HEAD
package SeleniumAssignment;
=======
package Asawari;
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        Thread.sleep(1000);

        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();

        Thread.sleep(1000);

        WebElement promptButton = driver.findElement(By.xpath("//button[@onclick='callJavaScriptPrompt()']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", promptButton);
        promptButton.click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        alert.sendKeys("Asawari");
        Thread.sleep(1000);
        alert.accept();
        driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();

    }
}
