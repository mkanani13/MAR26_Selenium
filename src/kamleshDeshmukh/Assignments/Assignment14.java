package kamleshDeshmukh.Assignments;

import kamleshDeshmukh.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

/*Open the website http://automationbykrishna.com/.
Click on the "DemoAnnotations Tables" tab to navigate to the tables section.
Locate the "EMPLOYEE BASIC INFORMATION" table.
Read all the rows and columns present in the table.
Print the complete table data in the Console Output.
*/
public class Assignment14 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserActions.start();
    }

    @Test
    public void printTable() {

        System.out.println("STEP- Click on  DemoAnnotations Table tab");
        driver.findElement(By.xpath("//a[@id='demotable']")).click();
        driver.findElement(By.xpath("//div[@id='empbasic']"));

        System.out.println("STEP- Print the whole table.");
        List<WebElement> totalRows = driver.findElements(By.xpath("//div[@id='empbasic']//table//tbody//tr"));
        for (WebElement row : totalRows) {
            System.out.println(row.getText());
        }

    }

    @AfterMethod
    public void tearDown() {
        System.out.println("STEP- Close the browser.");
        if (driver != null) {
            driver.quit();
        }
    }
}

