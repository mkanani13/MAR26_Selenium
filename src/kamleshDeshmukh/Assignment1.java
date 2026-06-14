package kamleshDeshmukh;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import technocredits.base.BrowserActions;

public class Assignment1 extends BrowserActions {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserActions.start();
    }

    @Test
    public void verifySuccessfulRegistration() {

        System.out.println("STEP = Click Registration");
        driver.findElement(By.xpath("//a[@id='registration2']")).click();

        System.out.println("STEP = Enter Username");
        driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("kamleshD1");

        System.out.println("STEP = Enter Password");
        driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("kamlesh123");

        System.out.println("STEP = Click the Submit button");
        driver.findElement(By.id("btnsubmitdetails")).click();

        System.out.println("STEP- Verify Success message on Alert.");
        Alert alt = driver.switchTo().alert();
        String successMessage = alt.getText();
        Assert.assertEquals(successMessage, "Success!");

        alt.accept();
        System.out.println("STEP = Registration Successful!");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("STEP- Close the browser.");
        if (driver != null) {
            driver.quit();
        }
    }

}
