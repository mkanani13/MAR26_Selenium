//Automate the following scenario using Selenium WebDriver in Java:
//
//        Open the application: http://automationbykrishna.com/
//        Click on the “Registration” tab/button.
//        Enter valid values in:-
//        → User Name field
//        → Password field (must contain at least 8 characters)
//
//        Click on the Submit button (Green Tick icon) to complete registration.
package rutujaWaje;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment1 {
    @Test
    public void registrationtab(){
       WebDriver driver = new ChromeDriver();
       driver.get("http://automationbykrishna.com/");
       driver.manage().window().maximize();
        System.out.println("Click on registration option ");
       driver.findElement(By.id("registration2")).click();
        System.out.println("Enter Username for login");
      WebElement username = driver.findElement(By.xpath("//input[@id=\"unameSignin\"]"));
      username.sendKeys("RutujaK12345");
        System.out.println("Enter Password for login");
        WebElement password = driver.findElement(By.xpath("//input[@id=\"pwdSignin\"]"));
        password.sendKeys("Rutuja@26111997");
        System.out.println("Click on submit button");
        WebElement clickButton= driver.findElement(By.xpath("//button[@id=\"btnsubmitdetails\"]"));
        clickButton.click();
    }
}





