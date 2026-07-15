package supriyaKanase.automationScript;

import supriyaKanase.Base.BrowserAction;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment6 {
    @Test
    public void alertAccept_Dismiss() {
        WebDriver driver = BrowserAction.start("http://automationbykrishna.com/");

        System.out.println("Click on Basic Elements");
        driver.findElement(By.id("basicelements")).click();

        System.out.println("Scroll to the element javascript prompt and click on it");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement jsPrompt = driver.findElement(By.id("javascriptPromp"));
        js.executeScript("arguments[0].scrollIntoView(true);",jsPrompt);
        jsPrompt.click();

        System.out.println("Switch to Alert");
        Alert alert = driver.switchTo().alert();

        System.out.println("passing name in textbox");
        alert.sendKeys("Supriya");
        alert.accept();
        String paragraphText = driver.findElement(By.id("pgraphdemo")).getText();

        Assert.assertTrue(paragraphText.contains("Supriya"));

        jsPrompt.click();
        Alert alert1 = driver.switchTo().alert();
        System.out.println("If click on Cancel button");
        alert1.dismiss();

        String actualCancelText = driver.findElement(By.id("pgraphdemo")).getText();
        String expectedText = "User cancelled the prompt.";

        Assert.assertEquals(actualCancelText,expectedText);
        driver.quit();
    }
}
