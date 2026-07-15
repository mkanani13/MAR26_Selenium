//Write a Selenium WebDriver automation script in Java to perform the following steps:
//
//
//1. Launch the application: http://automationbykrishna.com/
//2. Click on the “Basic Elements” tab.
//3. Under the section “DIFFERENT EXAMPLES OF ALERTS”, click on the “Javascript Confirmation” tab/button.
//4. Handle the JavaScript confirmation alert that appears.
//5. Read the alert message and accept it by clicking “OK”.
//6. Verify that the confirmation message displayed on the page is:
//
//       "You pressed OK!"

package adityaMukhedkar;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment_5 {

    @Test
    public void checkAlert() throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        String URL = "http://automationbykrishna.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        System.out.println("--------Ass5 -> click on  basic elements tab----");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();

        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        System.out.println("Check for OK button");
        String message = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
        String expMsg = "You pressed OK!";
        Assert.assertEquals(message,expMsg);
        System.out.println("Check for OK button passed.-------");

        System.out.println("Check for Cancel button -------");
        element.click();
        alert.dismiss();
        String message1 = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
        String expMsg1 = "You pressed Cancel!";
        Assert.assertEquals(message1,expMsg1);
        System.out.println("Check for Cancel button passed.-------");

        driver.quit();

    }

}
