package jayeshSonawane.assignments;

import jayeshSonawane.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
Using Selenium WebDriver in Java, automate the following scenario:

Open the website http://automationbykrishna.com/.
Click on the "Demo Tables" tab to navigate to the tables section.
Locate the "EMPLOYEE BASIC INFORMATION" table.
Read and iterate through all the rows of the table.
Find the row where the "Username" column contains the value "asharma".
From the same row, retrieve the corresponding value from the "First Name" column.
Print the extracted First Name value in the Console.
 */

public class Assignment16 {
    public static void main(String[] args) {
        WebDriver driver = BrowserActions.start();

        System.out.println("STEP - Navigate to Demo Tables");
        driver.findElement(By.linkText("Demo Tables")).click();

        System.out.println("STEP - Navigate to EMPLOYEE BASIC INFORMATION TABLE");

        String xpath = "//table[@class='table' and @id='table1']/tbody/tr/td[4][text()='asharma']/preceding-sibling::td[2]";
        String elFirstName = driver.findElement(By.xpath(xpath)).getText();
        System.out.println(elFirstName);

        BrowserActions.close();
    }
}
