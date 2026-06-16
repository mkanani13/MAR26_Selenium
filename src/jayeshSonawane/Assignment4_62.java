package seleniumAssignments;

/*
Automate the following scenario using Selenium WebDriver in Java:

Open the application: http://automationbykrishna.com/
Click on the “Basic Elements” tab/button.

Click on the “Alert” tab/button present under DIFFERENT EXAMPLES OF ALERTS.

Alert message should pop-up "You must be TechnoCredits student!!"
 */

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4_62 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationbykrishna.com/");

        if(driver.getCurrentUrl().equals("http://automationbykrishna.com/")){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        WebElement elementBasicElements = driver.findElement(By.xpath("//a[@id='basicelements']"));
        elementBasicElements.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement elementButtonJavascriptAlert = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
        elementButtonJavascriptAlert.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        alert.accept();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
