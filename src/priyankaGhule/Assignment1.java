package priyankaGhule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
    public static void main(String[] args)throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/");

        driver.findElement(By.xpath("//a[@id=\"registration2\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id=\"unameSignin\"]")).sendKeys("Priyanka");
        driver.findElement(By.xpath("//input[@id=\"pwdSignin\"]")).sendKeys("Priya@1234");
        driver.findElement(By.id("btnsubmitdetails")).click();

    }
}
