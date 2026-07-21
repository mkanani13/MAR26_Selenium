//Automate the following scenario using Selenium WebDriver in Java:
//
//Open the application: http://automationbykrishna.com/
//Click on the “Basic Elements” tab/button.
//
//Click on the “Alert” tab/button present under DIFFERENT EXAMPLES OF ALERTS.
//
//Alert message should pop-up "You must be TechnoCredits student!!"


package adityaMukhedkar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignement_4 {

    @Test
    public void aa_Scenario() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        String URL = "http://automationbykrishna.com/";
        driver.get(URL);
        driver.manage().window().maximize();
        System.out.println("--------Ass4 -> click on  basic elements tab----");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();

        Thread.sleep(1000);
        // Scroll down slightly so the footer doesn't overlap it
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();

        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        String Expected = "You must be TechnoCredits student!!";
        String actual = alert.getText();
        Assert.assertEquals(actual,Expected);
        alert.accept();
        System.out.println("----------------> Alert test passed <----------");
        driver.quit();

    }

}
