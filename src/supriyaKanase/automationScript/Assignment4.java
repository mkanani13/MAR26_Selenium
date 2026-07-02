package supriyaKanase.automationScript;

import supriyaKanase.Base.BrowserAction;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment4 {
    @Test
    public  void alertExample() {

        WebDriver driver = BrowserAction.start("http://automationbykrishna.com/");

        System.out.println("Click on Basic Element Button");
        driver.findElement(By.id("basicelements")).click();

        System.out.println("Click on Alert Button");
        driver.findElement(By.id("javascriptAlert")).click();

        System.out.println("Switch To Alert");
        Alert alert = driver.switchTo().alert();

        String actualAlertMessage = alert.getText();
        String expectedAlertMessage = "You must be TechnoCredits student!!";

        Assert.assertEquals(actualAlertMessage,expectedAlertMessage);
        alert.accept();
        driver.quit();
    }
}
