package automationScript;
//Automate the following scenario using Selenium WebDriver in Java:
//Open the application: http://automationbykrishna.com/
//Click on the “Registration” tab/button.
//Check the below conditions:-
//Condition 1:-
//Enter values in:
//User Name field
//Password field (must provide less than 8 characters)
//Click on the Submit button (Green Tick icon) to complete registration.
//Alert message should pop-up "Failed! please enter strong password"
//Condition 2:-
//Enter values in:
//User Name field
//Password field (must provide greater than 8 characters)
//Click on the Submit button (Green Tick icon) to complete registration.
//Alert message should pop-up "Success!"

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class Assignment2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        System.out.println("Step - Navigate to automationbykrishna ");
        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();
        if (driver.getTitle().equals("Login Signup Demo")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        System.out.println("Step - Click on Registration");
        driver.findElement(By.id("registration2")).click();
        Thread.sleep(1000);

        System.out.println("Step - Enter username");
        driver.findElement(By.id("unameSignin")).sendKeys("Rmali");

        System.out.println("Step - Enter Password");
        WebElement pwd = driver.findElement(By.id("pwdSignin"));
        pwd.sendKeys("Mali@123456");

        System.out.println("Step - Click on Green tick");
        driver.findElement(By.id("btnsubmitdetails")).click();
        Thread.sleep(1000);
        String expectedTextMessage = "Success!";
        Alert alert = driver.switchTo().alert();
        String actualTextMessage = alert.getText();
        if (actualTextMessage.equals(expectedTextMessage)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        alert.accept();

        System.out.println("Step - Clear password field");
        pwd.clear();
        Thread.sleep(1000);
        System.out.println("Step - Enter Password");
        pwd.sendKeys("rmali");

        System.out.println("Click on green button");
        driver.findElement(By.id("btnsubmitdetails")).click();
        Thread.sleep(1000);
        Alert alert1 = driver.switchTo().alert();
        String expectedTextMessage1 = "Failed! please enter strong password";
        String actualTextMessage1= alert1.getText();
        if(expectedTextMessage1.equals(actualTextMessage1)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
        alert1.accept();
             driver.quit();
    }
}
