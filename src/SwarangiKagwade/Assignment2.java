package SwarangiKagwade;
/*Automate the following scenario using Selenium WebDriver in Java:

Open the application: http://automationbykrishna.com/
Click on the “Registration” tab/button.
Check the below conditions:-

Condition 1:-
Enter values in:
User Name field
Password field (must provide less than 8 characters)
Click on the Submit button (Green Tick icon) to complete registration.
Alert message should pop-up "Failed! please enter strong password"

Condition 2:-
Enter values in:
User Name field
Password field (must provide greater than 8 characters)
Click on the Submit button (Green Tick icon) to complete registration.
Alert message should pop-up "Success!"*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='registration2']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("swarangi");
        driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("swarangi@1011");
        driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

        Alert alert= driver.switchTo().alert();
        String alertmessage=alert.getText();
        if(alertmessage.equals("Success!"))
            System.out.println("succeed !!!");
        else
            System.out.println("Failed! please enter strong password");

        alert.accept();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
        driver.findElement(By.xpath("//input[@id='pwdSignin']")).clear();
        driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Swarangi");
        driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Swarangi@1110");
        driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
        Thread.sleep(1000);
        alert.getText();
        if(alertmessage.equals("Success!"))
            System.out.println("succeed !!!");
        else
            System.out.println("Failed! please enter strong password");
        alert.accept();
    }
}
