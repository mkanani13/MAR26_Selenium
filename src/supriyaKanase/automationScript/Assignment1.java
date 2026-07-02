package supriyaKanase.automationScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assignment1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("STEP- Launch ChromeDriver, maximize window and Hit URL");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Redirect to automationbyrishna.com");
        driver.get("http://automationbykrishna.com/");

        System.out.println("Click on registration Button");
        driver.findElement(By.id("registration2")).click();
        Thread.sleep(1000);

        System.out.println("Enter User Name");
        driver.findElement(By.id("unameSignin")).sendKeys("skanase");

        System.out.println("Enter Password");
        driver.findElement(By.id("pwdSignin")).sendKeys("skanase1234");

        System.out.println("Click on button");
        driver.findElement(By.id("btnsubmitdetails")).click();
        driver.quit();
    }
}
