/*Selenium Assignment - 14: 13th June'2026
Using Selenium WebDriver in Java, automate the following scenario:

Open the website http://automationbykrishna.com/.
Click on the "Demo Tables" tab to navigate to the tables section.
Locate the "EMPLOYEE BASIC INFORMATION" table.
Read all the rows and columns present in the table.
Print the complete table data in the Console Output.*/

package rajashreePatil.DemoTable;

import rajashreePatil.Base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Assignment14 {
    WebDriver driver;
    void setup(){
        driver = BrowserActions.start();

    }
    int getNumberOfTotalEmployees(){
        System.out.println("Clicking on demo table");
        driver.findElement(By.linkText("Demo Tables")).click();
        System.out.println("capturing the totalEmpoyee rows count");
        int totalEmployees = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        return totalEmployees;
    }
    void printEmployeeDetails() {
        System.out.println("Clicking on demo table");
        driver.findElement(By.linkText("Demo Tables")).click();
        for (int rowIndex = 1; rowIndex <= 5; rowIndex++) {
            for (int colIndex = 1; colIndex <= 4; colIndex++) {
                String data = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[" + colIndex + "]")).getText();
                System.out.print(data + " ");
            }
            System.out.println();
        }
    }
    void printEmployeeDetails1(){
        System.out.println("Clicking on demo table");
        driver.findElement(By.linkText("Demo Tables")).click();
        System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody")).getText());

    }
    @Test
    public void verifyEmpDetails(){
        Assignment14 assign14 = new Assignment14();
        assign14.setup();
        /*int totalEmployeeCount = assign14.getNumberOfTotalEmployees();
        System.out.println("Total Number of employees in the Employee Basic Information table are ::"+totalEmployeeCount);*/
        //assign14.printEmployeeDetails();
        assign14.printEmployeeDetails1();

    }
}
