/*Selenium Assignment - 2: 9th June'2026
Automate the following scenario using Selenium WebDriver in Java:

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

package rajashreePatil.automationScript;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment2 {
    static void passwordCheck() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("STEP - Navigate to automationbykrishna");
        driver.get("http://automationbykrishna.com/");
        System.out.println("STEP - Click on Registration");
        driver.findElement(By.id("registration2")).click();

        System.out.println("STEP - Enter username");
        Thread.sleep(1000);
        driver.findElement(By.id("unameSignin")).sendKeys("Rajashree");

        System.out.println("STEP - Enter password");
        WebElement passwordElement = driver.findElement(By.id("pwdSignin"));
        passwordElement.sendKeys("Rajashree@123");

        System.out.println("STEP - Click on Submit");
        driver.findElement(By.id("btnsubmitdetails")).click();
        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        /*if(alertText.equals("Success!")){
            System.out.println("Passed");
        }
        else{
            System.out.println("Failed");
        }*/
        Assert.assertEquals(alertText,"Success!");
        alert.accept();
        Thread.sleep(2000);
        passwordElement.clear();
        passwordElement.sendKeys("Raj@123");

        driver.findElement(By.id("btnsubmitdetails")).click();
        Thread.sleep(1000);
        Alert alert2 = driver.switchTo().alert();
        Assert.assertEquals(alert2.getText(),"Failed! please enter strong password");
        /*if(alert.getText().equals("Failed! please enter strong password")){
            System.out.println("Passed");
        }
        else{
            System.out.println("Failed");
        }*/
        alert2.accept();
        driver.quit();

    }
    @Test
    public void verifyPassword() throws InterruptedException {
        Assignment2.passwordCheck();
    }

}
