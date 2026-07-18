/*Selenium Assignment - 16: 13th June'2026
        Using Selenium WebDriver in Java, automate the following scenario:

        Open the website http://automationbykrishna.com/.
        Click on the "Demo Tables" tab to navigate to the tables section.
        Locate the "EMPLOYEE BASIC INFORMATION" table.
        Read and iterate through all the rows of the table.
        Find the row where the "Username" column contains the value "asharma".
        From the same row, retrieve the corresponding value from the "First Name" column.
        Print the extracted First Name value in the Console.*/

package rajashreePatil.DemoTable;

import rajashreePatil.Base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Assignment16 {
    WebDriver driver;
    void setUp(){
        driver = BrowserActions.start();
        driver.findElement(By.linkText("Demo Tables")).click();
    }
    String getUsername(String userName){
        int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        for(int rowIndex= 1; rowIndex<=totalRows; rowIndex++){
            String uname= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td[4]")).getText();
            if(uname.equals(userName)){
                return driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td[2]")).getText();
            }
        }
        return null;
    }
    @Test
    public void printExtractedFnameValue(){
        Assignment16 assign15 = new Assignment16();
        assign15.setUp();
        String firstName = assign15.getUsername("asharma");
        System.out.println(firstName);
    }
}
