/*Selenium Assignment - 15: 13th June'2026
        Using Selenium WebDriver in Java, automate the following steps:

        Launch the website http://automationbykrishna.com/.
        Navigate to the "Demo Tables" section by clicking on the corresponding tab.
        Locate the "EMPLOYEE BASIC INFORMATION" table.
        Traverse through the table data and identify the row where the "First Name" column value is "Priya".
        Retrieve the corresponding value from the "Username" column in the same row.
        Print the extracted Username value in the Console.*/

package rajashreePatil.DemoTable;

import rajashreePatil.Base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Assignment15 {
    WebDriver driver;
    void setUp(){
        driver = BrowserActions.start();
        driver.findElement(By.linkText("Demo Tables")).click();
    }
    String getUsername(String firstName){
        int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        for(int rowIndex= 1; rowIndex<=totalRows; rowIndex++){
            String fname= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td[2]")).getText();
            if(fname.equals(firstName)){
                return driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td[4]")).getText();
            }
        }
        return null;
    }
    @Test
    public void printExtractedUnameValue(){
        Assignment15 assign15 = new Assignment15();
        assign15.setUp();
        String username = assign15.getUsername("Priya");
        System.out.println(username);
    }
}
