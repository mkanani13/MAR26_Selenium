package kamleshDeshmukh.Assignments;

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

public class Assignment9 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserActions.start();
    }

    @Test
    public void verifyFirstCheckBoxStatus()  {

        System.out.println("STEP- Click on Basic Elements tab");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();

        System.out.println("STEP- Scroll down to the Inline Checkboxes section");
        WebElement InlineCheckBoxSection = driver.findElement(By.xpath("(//div[@class='col-lg-10'])[5]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", InlineCheckBoxSection);

        System.out.println("STEP- Check if checkbox1 is selected");
        WebElement firstCheckBox = driver.findElement(By.xpath("//input[@id='inlineCheckbox1']"));
        boolean statusOfFirstCheckBox = firstCheckBox.isSelected();
        System.out.println("Before Click: "+ statusOfFirstCheckBox);

        if (!firstCheckBox.isSelected()) {
            firstCheckBox.click();
        }

        System.out.println("After Click : " + firstCheckBox.isSelected());
        Assert.assertTrue(firstCheckBox.isSelected());
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("STEP- Close the browser.");
        if (driver != null) {
            driver.quit();
        }
    }
}
