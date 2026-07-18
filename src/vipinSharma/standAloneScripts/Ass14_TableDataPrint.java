//Using Selenium WebDriver in Java, automate the following scenario:
//
//Open the website http://automationbykrishna.com/.
//Click on the "Demo Tables" tab to navigate to the tables section.
//Locate the "EMPLOYEE BASIC INFORMATION" table.
//Read all the rows and columns present in the table.
//Print the complete table data in the Console Output.

package vipinSharma.standAloneScripts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Ass14_TableDataPrint {
    WebDriver driver;
    Alert alert;

    @BeforeTest
    public void setUp() {
        System.out.println("STEP - WebDriver Initializing and Browser Launched");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("STEP - URL Navigation");
        driver.get("http://automationbykrishna.com/");
        System.out.println("STEP - Page Verification after redirect");
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Login Signup Demo";
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Page title not match!");
        System.out.println("STEP - Demo tables link click");
        driver.findElement(By.xpath("//a[@id='demotable']")).click();
    }

    @AfterTest
    public void setupEnd() {
        driver.quit();
        System.out.println("Browser closed");
    }

    @Test
    public void test() throws InterruptedException {
        List<WebElement> empTable = driver.findElements(By.xpath("//table[@id='table1']//tbody"));
        for(WebElement tabledata: empTable) {
            System.out.println("STEP - Employee table data print");
            System.out.println(tabledata.getText());
        }
    }
}
