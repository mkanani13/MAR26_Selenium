package kamleshDeshmukh.Assignments;

import kamleshDeshmukh.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Assignment15 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserActions.start();
    }


    @Test
    public void retrieveUsernameByProvidingFirstName() {

        System.out.println("STEP- Click on  DemoAnnotations Table tab");
        driver.findElement(By.xpath("//a[@id='demotable']")).click();
        driver.findElement(By.xpath("//div[@id='empbasic']"));

        System.out.println("STEP-Traverse through the table data and identify the row where the \"First Name\" column value is \"Priya\".");
        List<WebElement> allRows = driver.findElements(By.xpath("//div[@id='empbasic']//tbody//tr"));
        System.out.println("STEP-Print the extracted Username value in the Console.");
        for (WebElement currentRow : allRows) {
            String firstName = currentRow.findElement(By.xpath("./td[2]")).getText();

            if (firstName.equals("Priya")) {
                String userName = currentRow.findElement(By.xpath("./td[4]")).getText();
                System.out.println("Username is : " + userName);
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
