//Automate the following scenario using Selenium WebDriver in Java:
//
//        Open the application: http://automationbykrishna.com/
//        Click on the “Registration” tab/button.
//        Check the below conditions:-
//
//        Condition 1:-
//        Enter values in:
//        User Name field
//        Password field (must provide less than 8 characters)
//        Click on the Submit button (Green Tick icon) to complete registration.
//        Alert message should pop-up "Failed! please enter strong password"
//
//        Condition 2:-
//        Enter values in:
//        User Name field
//        Password field (must provide greater than 8 characters)
//        Click on the Submit button (Green Tick icon) to complete registration.
//        Alert message should pop-up "Success!"
package rutujaWaje;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment2 {
    @Test
    public void Alertmessage() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();

        System.out.println("Click on registration option ");
        driver.findElement(By.id("registration2")).click();
        Thread.sleep(1000);

        System.out.println("Enter Username for login");
        WebElement username = driver.findElement(By.xpath("//input[@id=\"unameSignin\"]"));
        username.sendKeys("RutujaK12345");

        System.out.println("Enter Password for login");
        WebElement password = driver.findElement(By.xpath("//input[@id=\"pwdSignin\"]"));
        password.sendKeys("Rutu");

        System.out.println("Click on submit button");
        WebElement clickButton = driver.findElement(By.xpath("//button[@id=\"btnsubmitdetails\"]"));
        clickButton.click();

        System.out.println("Get the alert message and checking negative scenario");
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText,"Failed! please enter strong password");
        password.clear();
        password.sendKeys("Rutu@26111997");
        System.out.println("Click on submit button");
        clickButton.click();

        System.out.println("Get the alert message and checking positive scenario");
        Alert alertBox = driver.switchTo().alert();
        String alertMessage = alertBox.getText();
        Assert.assertEquals(alertMessage,"Success");
        alert.accept();
    }
}


