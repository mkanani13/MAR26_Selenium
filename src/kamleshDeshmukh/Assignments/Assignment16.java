package kamleshDeshmukh.Assignments;
/*Open the website http://automationbykrishna.com/.
Click on the "Demo Tables" tab to navigate to the tables section.
Locate the "EMPLOYEE BASIC INFORMATION" table.
Read and iterate through all the rows of the table.
Find the row where the "Username" column contains the value "asharma".
From the same row, retrieve the corresponding value from the "First Name" column.
Print the extracted First Name value in the Console.
*/

import kamleshDeshmukh.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Assignment16 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserActions.start();
    }


    @Test
    public void retrieveFirstNameByProvidingUserName() {

        System.out.println("STEP- Click on  DemoAnnotations Table tab");
        driver.findElement(By.xpath("//a[@id='demotable']")).click();
        driver.findElement(By.xpath("//div[@id='empbasic']"));


        List<WebElement> allRows = driver.findElements(By.xpath("//div[@id='empbasic']//tbody//tr"));

        System.out.println("STEP- Print the extracted First Name value in the Console.");
        for (WebElement currentRow : allRows) {
            String userName = currentRow.findElement(By.xpath("./td[4]")).getText();

            if (userName.equals("asharma")) {
                String firstName = currentRow.findElement(By.xpath("./td[2]")).getText();
                System.out.println("FirstName is : " + firstName);
                break;


            }

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
