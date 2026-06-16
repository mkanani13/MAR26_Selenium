package raghunathMate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        System.out.println("Step-Navigate to link");
        driver.get("http://automationbykrishna.com/");
        System.out.println("Step-clicking of registration module");
        driver.findElement(By.id("registration2")).click();
        Thread.sleep(1000);
        System.out.println("Step-entering user name");
        driver.findElement(By.id("unameSignin")).sendKeys("RaghuMate");
        System.out.println("Step-entering password");
        driver.findElement(By.id("pwdSignin")).sendKeys("Raghu12345");
        System.out.println("Step-clicking on submit button");
        driver.findElement(By.id("btnsubmitdetails")).click();
    }
}
