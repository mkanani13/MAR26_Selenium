package priyankaGhule.automationScript;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
    public static void main(String[] args)throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.id("registration2")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("unameSignin")).sendKeys("Priyanka");
        driver.findElement(By.id("pwdSignin")).sendKeys("Priyanka1234");
        driver.findElement(By.id("btnsubmitdetails")).click();

        Alert aleart= driver.switchTo().alert();
        String aleartText = aleart.getText();
        if(aleartText.equals("Success!")){
            System.out.println("pass");
        }else {
            System.out.println("Failed");
        }
        aleart.accept();
        driver.quit();


    }
}
