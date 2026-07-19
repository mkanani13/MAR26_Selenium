/*
Using Selenium WebDriver in Java, automate the following scenario:

Launch the website http://automationbykrishna.com/.
Navigate to the "Demo Tables" section by clicking on the corresponding tab.
Locate the "EMPLOYEE BASIC INFORMATION" table.
Traverse through the table data and identify the row where the "First Name" column value is "Priya".
Retrieve the corresponding value from the "Username" column in the same row.
Print the extracted Username value in the Console.

 */

package Amitjoshi.Assignments.Basics.DemoTables;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Assignment15 {
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

    List<String> getUsername(String firstName) {
        List<String> listOfUsername = new ArrayList<String>();
        int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

        for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
            String fname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[2]")).getText();
            if (fname.equals(firstName)) {
                listOfUsername.add(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[4]")).getText());
            }
        }
        return listOfUsername;
    }

    @Test
    public void verifyUNameByFname () throws InterruptedException {
        System.out.println("STEP - Finding UserName by FirstName");
        List<String> userNameList = getUsername("Priya");
        System.out.println(userNameList);
    }
}