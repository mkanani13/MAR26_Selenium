package seleniumAssignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Write a Selenium WebDriver automation script in Java to perform the following steps:


1. Launch the application: http://automationbykrishna.com/
2. Click on the “Basic Elements” tab.
3. Under the section “DIFFERENT EXAMPLES OF ALERTS”, click on the “Javascript Confirmation” tab/button.
4. Handle the JavaScript confirmation alert that appears.
5. Read the alert message and accept it by clicking “OK”.
6. Verify that the confirmation message displayed on the page is:

       "You pressed OK!"
 */
public class Assignment5_63 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationbykrishna.com/");

        if(driver.getCurrentUrl().equals("http://automationbykrishna.com/")){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        WebElement elementBasicElements = driver.findElement(By.xpath("//a[@id='basicelements']"));
        elementBasicElements.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement elementButtonJavaScriptConfirmation = driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
        elementButtonJavaScriptConfirmation.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        WebElement elementTextPgraphDemo = driver.findElement(By.xpath("//p[@id='pgraphdemo']"));
        System.out.println(elementTextPgraphDemo.getText());

        elementButtonJavaScriptConfirmation.click();
        alert = driver.switchTo().alert();
        alert.dismiss();

        System.out.println(elementTextPgraphDemo.getText());
    }
}
