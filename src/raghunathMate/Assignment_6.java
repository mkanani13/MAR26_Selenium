package raghunathMate;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_6 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://automationbykrishna.com/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        Thread.sleep(1000);
        WebElement promptAlertButton = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",promptAlertButton);
        Thread.sleep(9000);
        promptAlertButton.click();
        Thread.sleep(1000);
        String name = "Raghunath";
        Alert alt = driver.switchTo().alert();
        alt.sendKeys(name);
        Thread.sleep(3000);
        alt.accept();
        String actualmsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
        if(actualmsg.contains(name)) {
            System.out.println("pass");
        } else {
            System.out.println("Fail");
        }
        Thread.sleep(3000);
        promptAlertButton.click();
        alt.sendKeys(name);
        Thread.sleep(3000);
        alt.dismiss();

        actualmsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
        if(actualmsg.contains(name)) {
            System.out.println("pass");
        } else {
            System.out.println("Fail");
            System.out.println(actualmsg);
        }
        Thread.sleep(1000);
        driver.quit();
    }
}
