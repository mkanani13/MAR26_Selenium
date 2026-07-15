//Using Selenium WebDriver in Java, automate the following scenario:
//Launch the website http://automationbykrishna.com/.
//Navigate to the "Demo Tables" section by clicking on the corresponding tab.
//Locate the "EMPLOYEE BASIC INFORMATION" table.
//Traverse through the table data and identify the row where the "First Name" column value is "Priya".
//Retrieve the corresponding value from the "Username" column in the same row.
//Print the extracted Username value in the Console.


package raghunathMate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import raghunathMate.testBase.BrowserAction;


public class Assignment_15_And_16 {
    WebDriver driver;
    SoftAssert softassert = new SoftAssert();
    @BeforeClass
    public void setup() {
        System.out.println("Step_1 - Launching browser and loading link");
        driver = BrowserAction.start();
        System.out.println("Step_2 - Navigating to table");
        driver.findElement(By.xpath("//a[@id='demotable']")).click();
    }
    //Assignment_15.
    @Test
    public void gettingUsernameFromName(){
    String name = "Priya";
    String expUserName = "ppatro";
    System.out.println("Step_3 - Getting username and verifying it");
    String userName = driver.findElement(By.xpath("//table[@class='table']/tbody/tr/td[2][text()='"+name+"']/following-sibling::td[2]")).getText();
    softassert.assertEquals(userName,expUserName, "Expected username should be "+expUserName+" but it is "+userName);
    softassert.assertAll();
    }

    //Assignment_16.
    @Test (priority=1)
    public void gettingNameFromUserName(){
        String Username = "asharma";
        String expName = "Abhishek";
        System.out.println("Step_4 - Getting username and verifying it");
        String Name = driver.findElement(By.xpath("//table[@class='table']/tbody/tr/td[4][text()='"+Username+"']/preceding-sibling::td[2]")).getText();
        softassert.assertEquals(Name,expName, "Expected name should be "+expName+" but it is "+Name);
        softassert.assertAll();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
