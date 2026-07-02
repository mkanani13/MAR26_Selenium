package adityaMukhedkar;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment_6 {

    @Test
    public void checkAlert() throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        String URL = "http://automationbykrishna.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        System.out.println("--------Ass6 -> click on  basic elements tab----");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();

        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Aditya");
        alert.accept();

        System.out.println("Check for OK button");
        String message = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
        String expMsg = "Hello Aditya! How are you today?";
        Assert.assertEquals(message,expMsg);
        System.out.println("Check for OK button passed.-------");

        System.out.println("Check for Cancel button -------");
        element.click();
        alert.dismiss();
        String message1 = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
        String expMsg1 = "User cancelled the prompt.";
        Assert.assertEquals(message1,expMsg1);
        System.out.println("Check for Cancel button passed.-------");

        driver.quit();

    }

}

