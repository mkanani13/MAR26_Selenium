package Asawari;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        Thread.sleep(1000);

        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Enter User Firstname']")).sendKeys("Asawari");
        driver.findElement(By.xpath("//input[@placeholder='Enter User Lastname']")).sendKeys("Bakshi");
        driver.findElement(By.xpath("//input[@placeholder='Enter User Companyname']")).sendKeys("Nusummit Tech pvt ltd");
        driver.findElement(By.xpath("//*[@id=\"firstRow\"]/div[1]/section/div/div[4]/button")).click();

        String expectedAlertText = "Asawari and Bakshi and Nusummit Tech pvt ltd";
        Alert alert = driver.switchTo().alert();
        String actualAlertText = alert.getText();

        if(expectedAlertText.equals(actualAlertText)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
    }
}
