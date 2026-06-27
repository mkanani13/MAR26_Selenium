//Using Selenium WebDriver in Java, automate the following scenario:
//
//Open the website http://automationbykrishna.com/.
//Click on the "Demo Tables" tab to navigate to the tables section.
//Locate the "EMPLOYEE BASIC INFORMATION" table.
//Read all the rows and columns present in the table.
//Print the complete table data in the Console Output.
package rutujaWaje;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Assignment14 {
    @Test
    public void empBasicInfo()  {
            System.out.println("Launch Browser");
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            System.out.println("Open the website");
            driver.get("http://automationbykrishna.com/");

            System.out.println("Click on Demo Tables tab");
            driver.findElement(By.id("demotable")).click();

            System.out.println("Locate all rows from EMPLOYEE BASIC INFORMATION table");
            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

            System.out.println("EMPLOYEE BASIC INFORMATION TABLE DATA");
            System.out.println("-------------------------------------");
            for (WebElement row : rows) {
                List<WebElement> columns = row.findElements(By.tagName("td"));
                for (WebElement column : columns) {
                    System.out.print(column.getText() + "\t");
                }
                System.out.println();
            }
            driver.quit();
        }
    }


