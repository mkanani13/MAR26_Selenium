package nishantBentur.assignments;

import nishantBentur.base.BrowserActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ass6 {
    WebDriver driver;

    @Test
    public void aa_alertWithPromptAccept(){
        driver = BrowserActions.start();

        System.out.println("Navigate to Basic Elements tab");
        WebElement basicElementTab = driver.findElement(By.linkText("Basic Elements"));
        basicElementTab.click();

        System.out.println("Click on Javascript Prompt in DIFFERENT EXAMPLES OF ALERT");
        driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();   //Click 'javascript Prompt'

        Alert alert = driver.switchTo().alert();
        String name = "Bobby";
        alert.sendKeys(name);
        alert.accept();
        String ok_message = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
        Assert.assertEquals(ok_message,"Hello " + name +"! How are you today?");
        System.out.println("Accept message checked");
    }

    @Test
    public void ab_alertWithPromptDismiss(){
        System.out.println("Click on Javascript Prompt in DIFFERENT EXAMPLES OF ALERT again");
        driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();   //Click 'javascript Prompt'
        Alert alert = driver.switchTo().alert();
        String name = "Bobby";
        alert.sendKeys(name);
        alert.dismiss();
        String cancelMessage = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
        Assert.assertEquals(cancelMessage,"User cancelled the prompt.");
        System.out.println("Dismiss message checked");
        driver.quit();
    }
}
