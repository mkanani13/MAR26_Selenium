package SwarangiKagwade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        System.out.println("Step:Click on regisration");
        driver.findElement(By.xpath("//a[@id='registration2']")).click();
        Thread.sleep(2000);
        System.out.println("Enter user name");
        driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Swarangi");
        System.out.println("Enter password");
        driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Swarangi@1110");
        driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
    }

    }

