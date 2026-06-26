package kamleshDeshmukh.Assignments;

//Alert Pop-up

import kamleshDeshmukh.base.BrowserActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment4 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserActions.start();
    }

    @Test
    public void verifyAlertMessage()  {
        System.out.println("STEP = Click Basic Elements tab");
        driver.findElement(By.xpath("//a[@id=\"basicelements\"]")).click();

        System.out.println("STEP = Click the Alert Button");
        driver.findElement(By.xpath("(//button[@type=\"submit\"])[3]")).click();

        System.out.println("STEP = Switch to Alert pop-up");
        Alert alt = driver.switchTo().alert();
        String alertMessage = alt.getText();
        alt.accept();

        System.out.println("STEP = Verify Alert Message");
        Assert.assertEquals(alertMessage, "You must be TechnoCredits student!!");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("STEP- Close the browser.");
        if (driver != null) {
            driver.quit();
        }
    }
}

