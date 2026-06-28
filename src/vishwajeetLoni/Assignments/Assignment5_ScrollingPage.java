package vishwajeetLoni.Assignments;

//Write a Selenium WebDriver automation script in Java to perform the following steps:
//
//
//1. Launch the application: http://automationbykrishna.com/
//2. Click on the “Basic Elements” tab.
//3. Under the section “DIFFERENT EXAMPLES OF ALERTS”, click on the “Javascript Confirmation” tab/button.
//4. Handle the JavaScript confirmation alert that appears.
//5. Read the alert message and accept it by clicking “OK”.
//6. Verify that the confirmation message displayed on the page is:
//
//       "You pressed OK!"

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import vishwajeetLoni.base.ActionOnBrowser;

import java.time.Duration;

public class Assignment5_ScrollingPage {
    WebDriver driver;

    @Test
    public  void alertnScroll(){
        driver = ActionOnBrowser.start();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        System.out.println("Step - Switch to Basic elements tab");
        driver.findElement(By.id("basicelements")).click();
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id = 'javascriptConfirmBox']")));

        System.out.println("Step - Scroll to see the Alert box");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",btn);

        System.out.println("Click on the alert btn");
        btn.click();
        System.out.println("Btn click");

        System.out.println("Switch to alert ");
        Alert alert = driver.switchTo().alert();
        String actualtxt = alert.getText();

        System.out.println("Test - Verify the text in Alert box");
        String expectedtxt = "Are you are doing your homework regularly, Press Okay else Cancel!!";
        Assert.assertEquals(actualtxt, expectedtxt);

        System.out.println("Click on OK");
        alert.accept();

        System.out.println("Test - Verify the message below the alert buttons");
        String tocheckfor = driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText();
        Assert.assertEquals(tocheckfor,"You pressed OK!");


    }

//    public static void main(String[] args) {
//
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://automationbykrishna.com/");
//        driver.manage().window().maximize();
//
//        driver.findElement(By.id("basicelements")).click();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        WebElement btn = driver.findElement(By.xpath("//button[@id = 'javascriptConfirmBox']"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);",btn);
//        btn.click();
//        System.out.println("Btn click");
//
//        Alert alert = driver.switchTo().alert();
//        String actualtxt = alert.getText();
//        String expectedtxt = "Are you are doing your homework regularly, Press Okay else Cancel!!";
//        if (actualtxt.equals(expectedtxt)){
//            System.out.println("Pass");
//        }else {
//            System.out.println("Fail");
//        }
//
//        alert.accept();
//        System.out.println("Clicked on OK");
//
//       String tocheckfor = driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText();
//       if (tocheckfor.equals("You pressed OK!"));
//       System.out.println("pass");
//
//
//
//
//
//
//    }
}
