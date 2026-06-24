package onkarPatil.assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("basicelements")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("javascriptAlert")).click();

        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        System.out.println(actualMessage);
        if(actualMessage.equals("You must be TechnoCredits student!!")){
            System.out.println("Pass!!!");
        }else{
            System.out.println("Fail");
        }

        driver.quit();
    }
}
