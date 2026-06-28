package onkarPatil.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("registration2")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("unameSignin")).sendKeys("Onkar");
        driver.findElement(By.id("pwdSignin")).sendKeys("12345678");
        driver.findElement(By.id("btnsubmitdetails")).click();

        driver.quit();
    }

    @Test
    public void clickTest(){

    }
}
