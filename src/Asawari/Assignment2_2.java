package SeleniumAssignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2_2 {public static void main(String[]  args) throws InterruptedException {

    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    Thread.sleep(1000);

    driver.get("http://automationbykrishna.com/");
    driver.findElement(By.id("registration2")).click();

    Thread.sleep(1000);

    driver.findElement(By.id("unameSignin")).sendKeys("mkanani");
    driver.findElement(By.id("pwdSignin")).sendKeys("mkanani@123");
    driver.findElement(By.id("btnsubmitdetails")).click();

    String expectedAlertText = "Success!";
    Alert alert = driver.switchTo().alert();
    String actualAlertText = alert.getText();

    if(expectedAlertText.equals(actualAlertText)){
        System.out.println("Pass");
    }else{
        System.out.println("Fail");
    }


}
}
