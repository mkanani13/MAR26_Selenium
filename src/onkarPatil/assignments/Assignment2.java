package onkarPatil.assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("registration2")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("unameSignin")).sendKeys("onkar");

        WebElement pwdInput = driver.findElement(By.id("pwdSignin"));
        pwdInput.sendKeys("123");
        WebElement submitBtn = driver.findElement(By.id("btnsubmitdetails"));
        submitBtn.click();

        Alert alert = driver.switchTo().alert();
        String textFailure = alert.getText();
        System.out.println(textFailure);
        if(textFailure.equals("Failed! please enter strong password")){
            System.out.println("Pass!!!");
        }else{
            System.out.println("Fail");
        }
        alert.accept();

        pwdInput.clear();
        pwdInput.sendKeys("123456789");
        submitBtn.click();

        Alert alert1 = driver.switchTo().alert();
        String textsuccess = alert1.getText();
        System.out.println(textsuccess);
        if(textsuccess.equals("Success!")){
            System.out.println("Pass!!!");
        }else{
            System.out.println("Fail");
        }
        alert.accept();

        driver.quit();
    }
}
