package nishantBentur.assignments;

import nishantBentur.base.BrowserActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ass5 {
    WebDriver driver;

    @Test
    void aa_alertAcceptAndDismiss(){
        driver = BrowserActions.start();

        System.out.println("Navigate to Basic Elements tab");
        WebElement basicElementTab = driver.findElement(By.linkText("Basic Elements"));
        basicElementTab.click();

        System.out.println("Click on Javascript Confirmation in DIFFERENT EXAMPLES OF ALERT");
        driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();   //Click 'javascript Confirmation'
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String alertText_ok = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
        Assert.assertTrue("You pressed OK!".equals(alertText_ok));
        System.out.println("Alert Accept Checked");

        System.out.println("Click on Javascript Confirmation in DIFFERENT EXAMPLES OF ALERT again");
        driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();  //Click 'javascript Confirmation'
        alert.dismiss();
        String alertText_cancel = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
        Assert.assertTrue("You pressed Cancel!".equals(alertText_cancel));
        System.out.println("Alert Dismiss Checked");

        driver.quit();
    }
}
