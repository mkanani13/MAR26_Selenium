//Using Selenium WebDriver in Java, automate the following scenario:
//
//Launch the website http://automationbykrishna.com/.
//Navigate to the "Demo Tables" section by clicking on the corresponding tab.
//Locate the "EMPLOYEE BASIC INFORMATION" table.
//Traverse through the table data and identify the row where the "First Name" column value is "Priya".
//Retrieve the corresponding value from the "Username" column in the same row.
//Print the extracted Username value in the Console.

package rutujaWaje;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Assignment15 {
    @Test
    public  void getFirstNameColumnValue()  {
            System.out.println("Launch Browser");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            System.out.println("Launch the application");
            driver.get("http://automationbykrishna.com/");

            System.out.println("Click on Demo Tables tab");
            driver.findElement(By.id("demotable")).click();


            System.out.println("Get all rows from Employee Basic Information table");
            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

            for (WebElement row : rows) {
                List<WebElement> columns = row.findElements(By.tagName("td"));

                String firstName = columns.get(1).getText();
                if (firstName.equalsIgnoreCase("Priya")) {
                    System.out.println("Get the UserName");
                    String actualUsername = columns.get(3).getText();
                    System.out.println("Username of Priya is : " + actualUsername);
                    break;
                }
            }
            driver.quit();
        }
    }


