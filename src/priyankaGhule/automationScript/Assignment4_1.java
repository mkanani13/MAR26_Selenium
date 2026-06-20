package priyankaGhule.automationScript;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4_1 {
    public static void main(String[] args)throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.id("basicelements")).click();
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,1000)");

        String ExpectedAlertMessage = "Are you are doing your homework regularly, Press Okay else Cancel!!";
        driver.findElement(By.id("javascriptConfirmBox")).click();
        Alert alert = driver.switchTo().alert();
        String actualAlertText = alert.getText();
        if(ExpectedAlertMessage.equals(actualAlertText)){
            System.out.println("Pass");
        }else{
            System.out.println("Failed");
        }
        alert.accept();
        driver.quit();


    }
}
