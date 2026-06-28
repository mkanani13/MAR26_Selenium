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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment8 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserActions.start();
    }

    @Test
    public void verifyRadioBoxStatus()  {

        System.out.println("STEP- Click on Basic Elements tab");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();

        System.out.println("STEP- Scroll down to the Checkbox and radios section");
        WebElement checkBoxAndRadioButtonSection = driver.findElement(By.xpath("(//div[@class='panel-body'])[7]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", checkBoxAndRadioButtonSection);

        System.out.println("Check if the second radio button " + "(Option two can be something else and selecting it will deselect option one)" + " is selected");
        WebElement secondRadioBox = driver.findElement(By.xpath("(//input[@value='option2'])[1]"));
        boolean checkRadioBtnStatus = secondRadioBox.isSelected();
        System.out.println("Before click: " + checkRadioBtnStatus);

        if (!secondRadioBox.isSelected()) {
            secondRadioBox.click();
        }

        System.out.println("After Click : " + secondRadioBox.isSelected());
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("STEP- Close the browser.");
        if (driver != null) {
            driver.quit();
        }
    }
}
