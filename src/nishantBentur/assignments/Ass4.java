package nishantBentur.assignments;

import nishantBentur.base.BrowserActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ass4 {
    WebDriver driver;

    @Test
    void aa_alertAccept(){
        driver = BrowserActions.start();

        System.out.println("Navigate to Basic Elements tab");
        WebElement basicElementTab = driver.findElement(By.linkText("Basic Elements"));
        basicElementTab.click();

        System.out.println("Click on Alert in DIFFERENT EXAMPLES OF ALERT");
        driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();

        Alert alert = driver.switchTo().alert();
        String actualAlertMessage = alert.getText();
        Assert.assertEquals("You must be TechnoCredits student!!", actualAlertMessage);
        alert.accept();
        driver.quit();
    }
}
