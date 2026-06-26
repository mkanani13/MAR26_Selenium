package Amitjoshi.Assignments.Basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(" http://automationbykrishna.com/");
        driver.manage().window().maximize();
        System.out.println("step1- window is maximized now clicking on registration ");
        driver.findElement(By.id("registration2")).click();
        Thread.sleep(2000);
        System.out.println("step2- imputing user and password = maulik, password= kanani@12  ");
        driver.findElement(By.id("unameSignin")).sendKeys("Maulik");
        System.out.println("the user name is done");

        WebElement PasswordInput = driver.findElement(By.id("pwdSignin"));
        PasswordInput.sendKeys("kanani@12ad");
        System.out.println("clicking the checkbox for not a robot");
        driver.findElement(By.id("rememberme")).click();
        System.out.println("click on submit button");
       WebElement submitele1 = driver.findElement(By.id("btnsubmitdetails"));
       submitele1.click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
         if(alertText.equals("Success!")){
            System.out.println("the password is valid ");
        }else{
            System.out.println("please enter valid password");
        }
        Thread.sleep(1000);
        alert.accept();

        PasswordInput.clear();
        PasswordInput.sendKeys("Am@12");
        submitele1.click();

        Alert alert1 = driver.switchTo().alert();
        String alertText1 = alert1.getText();
        if(alertText1.equals("Failed! please enter strong password")){
            System.out.println("suceess");
        }else{
            System.out.println("fail");
        }
        Thread.sleep(1000);
        alert.accept();



     driver.quit();
    }
}
