package vishwajeetLoni.Assignments;

//Automate the following scenario using Selenium WebDriver in Java:
//
//Open the application: http://automationbykrishna.com/
//Click on the “Registration” tab/button.
//Enter valid values in:-
//→ User Name field
//→ Password field (must contain at least 8 characters)
//
//Click on the Submit button (Green Tick icon) to complete registration.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import vishwajeetLoni.base.ActionOnBrowser;

public class Assignment1_Login {
   WebDriver driver;

   @Test
    public void login(){
       driver = ActionOnBrowser.start();

       System.out.println("Step - Go to Registration tab");
       driver.findElement(By.xpath("//a[@id='registration2']")).click();

       System.out.println("Switched to registration tab");

       System.out.println("Step - Enter credentials");
       driver.findElement(By.id("unameSignin")).sendKeys("424224w332");
       driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Test@11");
       driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
       System.out.println("Credentials entered");

       driver.quit();
    }

//    public static void main(String[] args) {
////        WebDriver driver = new ChromeDriver();
////        driver.manage().window().maximize();
////
////        driver.get("http://automationbykrishna.com/");
//
////        try {
////            Thread.sleep(5000);
////        } catch (InterruptedException e) {
////            throw new RuntimeException(e);
////        }
//        driver.findElement(By.id("unameSignin")).sendKeys("424224w332");
//        driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Test@11");
//        driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//
//        driver.quit();
//
//
//
//
//    }

}
