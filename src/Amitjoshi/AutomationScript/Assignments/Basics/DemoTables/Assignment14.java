/*
Using Selenium WebDriver in Java, automate the following scenario:

Open the website http://automationbykrishna.com/.
Click on the "Demo Tables" tab to navigate to the tables section.
Locate the "EMPLOYEE BASIC INFORMATION" table.
Read all the rows and columns present in the table.
Print the complete table data in the Console Output.
 */

package AutomationScript.DemoTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assignment14 {
     public static void main(String[] args) {
         WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.get("http://automationbykrishna.com/");
         System.out.println("step - get the required url");
         driver.findElement(By.linkText("Demo Tables")).click();


     }


}
