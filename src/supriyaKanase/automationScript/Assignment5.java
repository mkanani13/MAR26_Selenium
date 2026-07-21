package supriyaKanase.automationScript;

import supriyaKanase.Base.BrowserAction;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment5 {

    @Test
    public void main() {
        WebDriver driver = BrowserAction.start("http://automationbykrishna.com/");

        System.out.println("Click on Basic Element Button");
        driver.findElement(By.id("basicelements")).click();

        System.out.println("Scroll to the element javascriptConfirmBox");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement jsConfirmBox = driver.findElement(By.id("javascriptConfirmBox"));
        js.executeScript("arguments[0].scrollIntoView(true);",jsConfirmBox);
        jsConfirmBox.click();

        System.out.println("Switch to alert");
        Alert alert = driver.switchTo().alert();
        String actualAlertMsg = alert.getText();

        String expectedAlertMessage = "Are you are doing your homework regularly, Press Okay else Cancel!!";
        Assert.assertEquals(actualAlertMsg,expectedAlertMessage);
        alert.accept();

        System.out.println("Finding element and taking its text message after clicking OK on alert pop up");
        String confirmMsg = driver.findElement(By.xpath("//p[@id = 'pgraphdemo']")).getText();
        String expectedMsg = "You pressed OK!";
        Assert.assertEquals(confirmMsg,expectedMsg);
        driver.quit();
    }
}
