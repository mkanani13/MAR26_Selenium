package kamleshDeshmukh.Assignments;
/*Open the application: http://automationbykrishna.com/
Click on the “Basic Elements” tab/button.

Scroll down the page and in the "Checkbox and radios" section perform the following activities:-

Select the checkbox "Option one is this and that—be sure to include why it's great option one" and check the status.
*/

import kamleshDeshmukh.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment7 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserActions.start();
    }

    @Test
    public void verifyCheckBOxStatus() {

        System.out.println("STEP- Click on Basic Elements tab");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();

        System.out.println("STEP- Scroll down to the Checkbox and radios section");
        WebElement checkBoxAndRadioButtonSection = driver.findElement(By.xpath("(//div[@class='panel-body'])[7]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", checkBoxAndRadioButtonSection);

        System.out.println("Check if the second checkbox " + "(Option one is this and that—be sure to include why it's great option one)" + " is selected");
        WebElement secondCheckBox = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[7]"));
        boolean checkBoxStatus = secondCheckBox.isSelected();
        System.out.println("Before click: " + checkBoxStatus);

        if (!secondCheckBox.isSelected()) {
            secondCheckBox.click();
        }

        Assert.assertTrue(secondCheckBox.isSelected());
        System.out.println("After Click : " + secondCheckBox.isSelected());

    }

    @AfterMethod
    public void tearDown() {
        System.out.println("STEP- Close the browser.");
        if (driver != null) {
            driver.quit();
        }
    }
}
