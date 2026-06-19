package jayeshSonawane;

import jayeshSonawane.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
Using Selenium WebDriver in Java, automate the following steps:

Launch the website http://automationbykrishna.com/.
Navigate to the "Demo Tables" section by clicking on the corresponding tab.
Locate the "EMPLOYEE BASIC INFORMATION" table.
Traverse through the table data and identify the row where the "First Name" column value is "Priya".
Retrieve the corresponding value from the "Username" column in the same row.
Print the extracted Username value in the Console.
 */

public class Assignment15 {
    public static void main(String[] args) {
        WebDriver driver = BrowserActions.start();

        System.out.println("STEP - Navigate to Demo Tables");
        driver.findElement(By.linkText("Demo Tables")).click();

        System.out.println("STEP - Navigate to EMPLOYEE BASIC INFORMATION TABLE");

        String xpath = "//table[@class='table' and @id='table1']/tbody/tr/td[2][text()='Priya']/following-sibling::td[2]";
        String elUserName = driver.findElement(By.xpath(xpath)).getText();
        System.out.println(elUserName);

        BrowserActions.close();
    }
}
