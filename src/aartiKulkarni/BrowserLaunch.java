package aartiKulkarni;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch {

   public static void main(String[] args){
       WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();

       driver.get("http://34.173.201.53/#/access");
    driver.findElement(By.xpath("//input[@id='access-student-id']")).sendKeys("KZYEARPF53");
    driver.findElement(By.xpath("//input[@data-testid='access-code']")).sendKeys("2QATU9PW");
    driver.findElement(By.xpath("//button[@data-testid='access-submit-btn']")).click();


   }
}

