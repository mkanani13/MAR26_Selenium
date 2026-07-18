package nishantBentur.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ass1 {

    public static void main(String args[]) throws InterruptedException {

        System.out.println("STEP- Launch ChromeDriver, maximize window and pass a URL");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/");

        System.out.println("STEP- Navigate to Registration tab");
        driver.findElement(By.id("registration2")).click(); //Click on "Registration" tab
        Thread.sleep(500);

        System.out.println("STEP- Enter user credentials & click on tick mark");
        driver.findElement(By.id("unameSignin")).sendKeys("nishanthb"); //Enter user name
        driver.findElement(By.id("pwdSignin")).sendKeys("nishant1234##"); //Enter password
        driver.findElement(By.id("btnsubmitdetails")).click(); //Click tick mark button

        driver.quit();
        System.out.println("End");
    }
}
