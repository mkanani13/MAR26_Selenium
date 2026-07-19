<<<<<<< HEAD
package SeleniumAssignment;
=======
package Asawari;
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        Thread.sleep(1000);

        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();

        Thread.sleep(1000);

        WebElement alertBtn = driver.findElement(By.xpath("//button[@onclick='callJavaScriptAlert()']"));
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",alertBtn);
        alertBtn.click();

        Thread.sleep(1000);
        String expectedAlertText = "You must be TechnoCredits student!!";
        Alert alert = driver.switchTo().alert();
        String actualAlertText = alert.getText();
        if(expectedAlertText.equals(actualAlertText)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        Thread.sleep(1000);

        alert.accept();
    }
}
