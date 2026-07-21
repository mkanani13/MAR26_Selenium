package aartiKulkarni.Assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelAssignment2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.findElement(By.id("registration2")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Aarti");
        WebElement pwdInputElement=driver.findElement(By.id("pwdSignin"));
        pwdInputElement.sendKeys("Joshi@123");
        driver.findElement(By.id("btnsubmitdetails")).click();

        Alert alert=driver.switchTo().alert();
        String alertText=alert.getText();
        System.out.println("Alert Text = " + alertText);
        Thread.sleep(1000);
        if(alertText.equals("Success!"))
            System.out.println("test case passed-correct password ");
        else
            System.out.println("test case failed -incorrect password");
        alert.accept();

        driver.quit();



    }
}
