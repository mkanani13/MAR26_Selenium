//Using Selenium WebDriver in Java, automate the following scenario:
//
//Open the website http://automationbykrishna.com/.
//Click on the "Demo Tables" tab to navigate to the tables section.
//Locate the "EMPLOYEE BASIC INFORMATION" table.
//Read and iterate through all the rows of the table.
//Find the row where the "Username" column contains the value "asharma".
//From the same row, retrieve the corresponding value from the "First Name" column.
//Print the extracted First Name value in the Console.
package rutujaWaje;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Assignment16 {
    @Test
    public void getEmployeeBasicInfo() {
            System.out.println("Launch browser");
            WebDriver driver = new ChromeDriver();

            driver.get("http://automationbykrishna.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            System.out.println("Click on the Demo Tables");
            driver.findElement(By.xpath("//a[text()='Demo Tables']")).click();

            System.out.println("get the Employee basic information");
            List<WebElement> empBasicInfo = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
            String actualFirstName = "";
            boolean isUserFound = false;

            for (WebElement e : empBasicInfo) {
                List<WebElement> columns = e.findElements(By.tagName("td"));
                String username = columns.get(3).getText();

                if (username.equalsIgnoreCase("asharma")) {
                    String firstName = columns.get(1).getText();
                    isUserFound = true;
                    System.out.println("asharma username contain the First Name: " + firstName);
                    break;

                }

            }
             Assert.assertTrue(isUserFound, "Username 'asharma' is not present in the table.");
            Assert.assertEquals(actualFirstName, "Abhishek", "First Name for username 'asharma' is incorrect.");
            driver.quit();
        }

    }


