package vishwajeetLoni;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_Assignment1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='registration2']")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("unameSignin")).sendKeys("424224w332");
        driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Test@11");
        driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        driver.quit();




    }

}
