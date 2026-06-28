/*Automate the following scenario using Selenium WebDriver in Java:

 Open the application: http://automationbykrishna.com/
        Click on the “Registration” tab/button.
        Enter valid values in:-
        → User Name field
        → Password field (must contain at least 8 characters)

        Click on the Submit button (Green Tick icon) to complete registration.*/
package rajashreePatil.automationScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("STEP - Navigate to automationbykrishna");
        driver.get("http://automationbykrishna.com/");
        System.out.println("STEP - Click on Registration");
        driver.findElement(By.id("registration2")).click();
        System.out.println("STEP - Enter username");
        driver.findElement(By.id("unameSignin")).sendKeys("Rajashree");
        System.out.println("STEP - Enter password");
        driver.findElement(By.id("pwdSignin")).sendKeys("Rajashree@123");
        System.out.println("STEP - Click on Submit");
        driver.findElement(By.id("btnsubmitdetails")).click();
        
        driver.quit();
    }
}
