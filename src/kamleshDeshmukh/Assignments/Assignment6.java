package kamleshDeshmukh.Assignments;
/*1. Launch the application: http://automationbykrishna.com/
2. Click on the “Basic Elements” tab.
3. Under the section “DIFFERENT EXAMPLES OF ALERTS”, click on the “Javascript Prompt” tab/button.
4. Enter the NAME in the JavaScript Prompt that appears and click on "OK" button.
5. Read the text message that appears.
6. Verify that the confirmation message displayed on the page is:

        "Hello NAME! How are you today?"
*/

import kamleshDeshmukh.base.BrowserActions;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment6 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserActions.start();
    }

    @Test
    public  void verifyConfirmationMsg()  {

        String name= "Kamlesh";
        System.out.println("STEP- Click on Basic Elements");
        driver.findElement(By.xpath("//a[@id=\"basicelements\"]")).click();

        System.out.println("STEP- Click on the “Javascript Prompt” tab/button.");
        WebElement jsPromptButton = driver.findElement(By.xpath("//button[@id=\"javascriptPromp\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", jsPromptButton);
        jsPromptButton.click();

        System.out.println("STEP- Enter name and click on OK button.");
        Alert alt = driver.switchTo().alert();
        String actAltMessage = alt.getText();
        alt.sendKeys(name);
        alt.accept();
        Assert.assertEquals(actAltMessage, "Please enter your name :");

        System.out.println("STEP-Verify that the confirmation message");
        WebElement confirmationMsg = driver.findElement(By.xpath("//p[@id=\"pgraphdemo\"]"));
        String actualConfirtmationMsg = confirmationMsg.getText();
        Assert.assertEquals(actualConfirtmationMsg, "Hello " + name + "! How are you today?");
        System.out.println(actualConfirtmationMsg);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("STEP- Close the browser.");
        if (driver != null) {
            driver.quit();
        }
    }
}
