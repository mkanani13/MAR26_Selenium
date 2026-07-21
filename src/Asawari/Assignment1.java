package Asawari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Assignment1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.id("registration2")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("unameSignin")).sendKeys("mkanani");
        driver.findElement(By.id("pwdSignin")).sendKeys("mkanani@123");
        driver.findElement(By.id("btnsubmitdetails")).click();
    }
}
