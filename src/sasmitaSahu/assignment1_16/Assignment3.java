package sasmitaSahu.assignment1_16;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        System.out.println("STEP1 - Maximize the window");
        driver.manage().window().maximize();

        System.out.println("STEP2 - Navigation to automationbykrishna");
        driver.get("http://automationbykrishna.com/");

        String firstName = "sasmita";
        String lastName = "sahu";
        String CompanyName = "Novac";

        String expectedAlertMessage = firstName + " and " + lastName + " and " + CompanyName;

        System.out.println("STEP3 - Click on basic element");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();

        Thread.sleep(1000);

        System.out.println("STEP4 - Enter username");
        driver.findElement(By.xpath("//input[@name='ufname']")).sendKeys(firstName);

        System.out.println("STEP5 - Enter password");
        driver.findElement(By.xpath("//input[@name='ulname']")).sendKeys(lastName);

        System.out.println("STEP6 - Enter companyname");
        driver.findElement(By.xpath("//input[@name='cmpname']")).sendKeys(CompanyName);

        System.out.println("STEP7- Click on submit button");
        driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();

        System.out.println("STEP8- Switch to alert message");
        Alert alert = driver.switchTo().alert();
        String actualAlertMessage = alert.getText();

        if (expectedAlertMessage.equals(actualAlertMessage)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }

        alert.accept();
        driver.quit();

    }
}
