package Asawari;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        Thread.sleep(1000);

        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();

        Thread.sleep(1000);

        WebElement alertBtn = driver.findElement(By.xpath("//button[@onclick='callJavaScriptConfirmBox()']"));
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", alertBtn);
        alertBtn.click();

        Thread.sleep(1000);

        String expectedAlertText = "Are you are doing your homework regularly, Press Okay else Cancel!!";
        Alert alert = driver.switchTo().alert();
        String actualAlertText = alert.getText();
        if(expectedAlertText.equals(actualAlertText)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        Thread.sleep(1000);

       // alert.accept();
        alert.dismiss();

        //boolean isVisible = driver.findElement(By.xpath("//p[text()='You pressed OK!']")).isDisplayed();
        //if(isVisible){
         //   System.out.println("Alert Text 'You pressed OK!' is displayed on the screen");
        //}else{
        //    System.out.println("Alert is not displayed");
        //}

        boolean isVisible = driver.findElement(By.xpath("//p[text()='You pressed Cancel!']")).isDisplayed();
        if(isVisible){
            System.out.println("Alert Text 'You pressed Cancel!' is displayed on the screen");
        }else {
            System.out.println("Alert is not displayed");
        }
    }
}
