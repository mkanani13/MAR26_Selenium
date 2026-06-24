//Using Selenium WebDriver in Java, automate the following scenario:
//        Open the website http://automationbykrishna.com/.
//        Click on the "Demo Tables" tab to navigate to the tables section.
//        Locate the "EMPLOYEE BASIC INFORMATION" table.
//        Read all the rows and columns present in the table.
//        Print the complete table data in the Console Output.


package raghunathMate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import raghunathMate.testBase.BrowserAction;


public class Assignment_14 {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.out.println("Step_1 - Launching browser and loading link");
        driver = BrowserAction.start();
    }

    @Test
    public void readAllTableData(){
        System.out.println("Step_2 - Navigating to table");
        driver.findElement(By.xpath("//a[@id='demotable']")).click();

        System.out.println("Step_3 - Reading and printing Employee table row count");
        int rowCount =driver.findElements(By.xpath("//table[@class='table']/tbody/tr")).size();
        System.out.println(rowCount);

        System.out.println("Step_4 - verifying row count");
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(rowCount,5,"Expected row count should be 5 but it is "+rowCount);

        System.out.println("Step_5 - Reading and printing Employee table column count");
        int columnCount =driver.findElements(By.xpath("//table[@class='table']/tbody/tr[1]/td")).size();
        System.out.println(columnCount);

        System.out.println("Step_6 - verifying column count");
        softassert.assertEquals(columnCount,4,"Expected column count should be 4 but it is "+columnCount);

        System.out.println("Step_7 - Reading and printing Employee table data");
        String tableData = driver.findElement(By.xpath("//table[@class='table']/tbody")).getText();
        System.out.println(tableData);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
