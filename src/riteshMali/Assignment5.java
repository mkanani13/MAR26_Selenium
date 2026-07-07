package automationScript;

//1. Launch the application: http://automationbykrishna.com/
//        2. Click on the “Basic Elements” tab.
//3. Under the section “DIFFERENT EXAMPLES OF ALERTS”, click on the “Javascript Confirmation” tab/button.
//4. Handle the JavaScript confirmation alert that appears.
//5. Read the alert message and accept it by clicking “OK”.
//        6. Verify that the confirmation message displayed on the page is:
//
//        "You pressed OK!"


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class Assignment5 {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        Thread.sleep(1000);
        WebElement alertBtn = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
        alertBtn.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement paragText = driver.findElement(By.xpath("//p[@id ='pgraphdemo']"));
        paragText.getText();
        if (paragText.getText().contains("OK")) {
            System.out.println("Pass");
        } else {
            System.out.println("failed");
        }
        alertBtn.click();

        Thread.sleep(3000);
        //Alert alert = driver.switchTo().alert();
        alert.dismiss();
        paragText.getText();
        if (paragText.getText().contains("Cancel")) {
            System.out.println("Pass");
        } else {
            System.out.println("Failed");
        }
        driver.quit();

    }

}
