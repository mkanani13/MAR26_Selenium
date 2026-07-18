package kamleshDeshmukh.Assignments;

import kamleshDeshmukh.base.BrowserActions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
1. Launch the application: http://automationbykrishna.com/
2. Click on the “Basic Elements” tab.
3. Under the section “DIFFERENT EXAMPLES OF ALERTS”, click on the “Javascript Confirmation” tab/button.
4. Handle the JavaScript confirmation alert that appears.
5. Read the alert message and accept it by clicking “OK”.
6. Verify that the confirmation message displayed on the page is:
       "You pressed OK!"
 */
public class Assignment5 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserActions.start();
    }

    @Test
    public void verifyConfirmationMsg() {

        System.out.println("STEP- Click on Basic Elements");
        driver.findElement(By.xpath("//a[@id=\"basicelements\"]")).click();

        System.out.println("STEP- Click on “Javascript Confirmation” tab/button.");
        WebElement jsButton = driver.findElement(By.xpath("//button[@id=\"javascriptConfirmBox\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", jsButton);
        jsButton.click();

        System.out.println("STEP- Handle the JavaScript confirmation alert.");
        Alert alt = driver.switchTo().alert();

        System.out.println("STEP- Read the alert message and accept it by clicking “OK”.");
        String actualAlertMessage = alt.getText();
        alt.accept();
        Assert.assertEquals(actualAlertMessage, "Are you are doing your homework regularly, Press Okay else Cancel!!");

        System.out.println("STEP- Verify confirmation message.");
        WebElement p = driver.findElement(By.xpath("//p[@id=\"pgraphdemo\"]"));
        String actualConfirmationMessage = p.getText();
        Assert.assertEquals(actualConfirmationMessage, "You pressed OK!");

    }

    @AfterMethod
    public void tearDown() {
        System.out.println("STEP- Close the browser.");
        if (driver != null) {
            driver.quit();
        }
    }

}
