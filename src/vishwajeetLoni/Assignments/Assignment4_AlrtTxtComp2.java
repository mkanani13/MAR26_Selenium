package vishwajeetLoni.Assignments;

//Automate the following scenario using Selenium WebDriver in Java:
//
//Open the application: http://automationbykrishna.com/
//Click on the “Basic Elements” tab/button.
//
//Click on the “Alert” tab/button present under DIFFERENT EXAMPLES OF ALERTS.
//
//Alert message should pop-up "You must be TechnoCredits student!!"

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import vishwajeetLoni.base.ActionOnBrowser;

import java.time.Duration;

public class Assignment4_AlrtTxtComp2 {
    WebDriver driver;

    @Test
    public void alertExample1(){
        driver = ActionOnBrowser.start();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("Switch to Basic Elements Tab");
        driver.findElement(By.id("basicelements")).click();     // Click on BAsic Elements tab
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("javascriptAlert")));

        System.out.println("Click on 'Alert' button");
        driver.findElement(By.id("javascriptAlert")).click();

        System.out.println("Switch to alert box and get text");
        Alert alert = driver.switchTo().alert();
        String actualtxt = alert.getText();

        System.out.println("Test - Verify the text with expected ");
        String exptext = "You must be TechnoCredits student!!";
        Assert.assertEquals(actualtxt, exptext);

        alert.accept();
        driver.quit();
    }


//    public static void main(String[] args) {
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
//        driver.findElement(By.id("javascriptAlert")).click();
//
//        Alert alert = driver.switchTo().alert();
//        String actualtxt = alert.getText();
//        String exptext = "You must be TechnoCredits student!!";
//        if (actualtxt.equals(exptext)){
//            System.out.println("Pass");
//        }else {
//            System.out.println("Fail");
//        }
//
//
//
//
//    }
}
