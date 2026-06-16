package seleniumAssignments;
/*
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
Alert message should pop-up "Success!"
 */

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2_60 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationbykrishna.com/");

        WebElement elementRegister2 = driver.findElement(By.xpath("//*[@id='registration2']"));
        elementRegister2.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // TC 1
        System.out.println("Executing TC 1");
        WebElement elementUnameSignin = driver.findElement(By.xpath("//*[@id='unameSignin']"));
        elementUnameSignin.sendKeys("Jayesh");

        WebElement elementPwdSignin = driver.findElement(By.xpath("//*[@id='pwdSignin']"));
        elementPwdSignin.sendKeys("abcd123");

        WebElement elementBtnsubmitdetails = driver.findElement(By.xpath("//*[@id='btnsubmitdetails']"));
        elementBtnsubmitdetails.click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String expectedAlertText = "Failed! please enter strong password";

        if(alertText.equals(expectedAlertText)){
            System.out.println("TC 1 Passed");
        }else{
            System.out.println("TC 1 Failed");
        }

        alert.accept();

        // TC 2
        System.out.println("Executing TC 2");
        elementUnameSignin.sendKeys("Jayesh");
        elementPwdSignin.sendKeys("abcd12345");
        elementBtnsubmitdetails.click();

        alert = driver.switchTo().alert();
        alertText = alert.getText();
        expectedAlertText = "Success!";

        if(alertText.equals(expectedAlertText)){
            System.out.println("TC 2 Passed");
        }else{
            System.out.println("TC 2 Failed");
        }

        alert.accept();
    }
}
