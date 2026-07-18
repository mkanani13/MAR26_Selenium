//Using Selenium WebDriver in Java, automate the following scenario:
//
//Open the website http://automationbykrishna.com/.
//Click on the "Demo Tables" tab to navigate to the tables section.
//Locate the "EMPLOYEE BASIC INFORMATION" table.
//Read and iterate through all the rows of the table.
//Find the row where the "Username" column contains the value "asharma".
//From the same row, retrieve the corresponding value from the "First Name" column.
//Print the extracted First Name value in the Console.

package vipinSharma.standAloneScripts;
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

public class Ass16_TableDataFatct {
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

    List<String> getFirstname(String firstName) {
        List<String> listOfUsername = new ArrayList<String>();
        int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

        for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
            String Uname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[4]")).getText();
            if (Uname.equals(firstName)) {
                listOfUsername.add(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[2]")).getText());
            }
        }
        return listOfUsername;
    }

    @Test
    public void verifyFNameByUN () throws InterruptedException {
        List<String> userNameList = getFirstname("asharma");
        System.out.println(userNameList);
    }

}

