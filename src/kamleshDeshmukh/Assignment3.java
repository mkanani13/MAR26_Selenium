//Alert Pop-up

package kamleshDeshmukh;

import technocredits.base.BrowserActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment3 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserActions.start();
    }

    @Test
    public void verifyAlertMessageOnBasicElementsPage() {

        String firstName = "Kamlesh";
        String lastName = "Deshmukh";
        String companyName = "HireCorrecto";


        System.out.println("STEP = Click Basic Elements tab");
        driver.findElement(By.xpath("//a[@id=\"basicelements\"]")).click();


        System.out.println("STEP = Enter First Name, Last Name and Company Name");
        driver.findElement(By.xpath("//input[@name=\"ufname\"]")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@name=\"ulname\"]")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@name=\"cmpname\"]")).sendKeys(companyName);

        System.out.println("STEP = Click Submit button");
        driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]")).click();

        System.out.println("STEP = Switch to Alert pop-up");
        Alert alt = driver.switchTo().alert();
        String alertMessage = alt.getText();
        String expectedMessage = firstName + " and " + lastName + " and " + companyName;

        System.out.println("STEP = Check Alert Message");
        Assert.assertEquals(alertMessage, expectedMessage);


    }

    @AfterMethod
    public void tearDown() {
        System.out.println("STEP- Close the browser.");
        if (driver != null) {
            driver.quit();
        }
    }

}
