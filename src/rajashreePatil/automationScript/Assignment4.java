/*Selenium Assignment - 4: 9th June'2026
Automate the following scenario using Selenium WebDriver in Java:

Open the application: http://automationbykrishna.com/
Click on the “Basic Elements” tab/button.

Click on the “Alert” tab/button present under DIFFERENT EXAMPLES OF ALERTS.

Alert message should pop-up "You must be TechnoCredits student!!"*/

package rajashreePatil.automationScript;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment4 {
    static void alertOnBasicElementsPage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationbykrishna.com/");

        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        Thread.sleep(1000);

        WebElement alertBtn = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",alertBtn);
        alertBtn.click();

        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();

        String expectedAlertText = "You must be TechnoCredits student!!";
        Assert.assertEquals(alert.getText(),expectedAlertText);

        driver.quit();
    }
    @Test
    public void verifyAlertMsg() throws InterruptedException {
        Assignment4 assignment4= new Assignment4();
        assignment4.alertOnBasicElementsPage();
    }
}
