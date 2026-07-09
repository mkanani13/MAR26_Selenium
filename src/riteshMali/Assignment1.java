package automationScript;
//Automate the following scenario using Selenium WebDriver in Java:
//Open the application: http://automationbykrishna.com/
//Click on the “Registration” tab/button.
//Enter valid values in:-
//        → User Name field
//→ Password field (must contain at least 8 characters)
//Click on the Submit button (Green Tick icon) to complete registration.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class Assignment1 {

    public static void main(String[] args) throws InterruptedException  {
        WebDriver driver = new ChromeDriver();
        System.out.println("Step - Navigate to automationbykrishna ");
        driver.get("http://automationbykrishna.com/");
        if(driver.getTitle().equals("Login Signup Demo")){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }
        System.out.println("Step - Click on Registration");
        driver.findElement(By.id("registration2")).click();
        Thread.sleep(1000);
        System.out.println("Step - Enter username");
        driver.findElement(By.id("unameSignin")).sendKeys("Rmali");
        System.out.println("Step - Enter Password");
        driver.findElement(By.id("pwdSignin")).sendKeys("Mali@123456");
        System.out.println("Step - Click on Green tick");
        driver.findElement(By.id("btnsubmitdetails")).click();

        driver.quit();

    }
}
