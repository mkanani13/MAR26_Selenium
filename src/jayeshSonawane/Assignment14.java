package jayeshSonawane;

import jayeshSonawane.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
Using Selenium WebDriver in Java, automate the following scenario:

Open the website http://automationbykrishna.com/.
Click on the "Demo Tables" tab to navigate to the tables section.
Locate the "EMPLOYEE BASIC INFORMATION" table.
Read all the rows and columns present in the table.
Print the complete table data in the Console Output.
 */
public class Assignment14 {
    public static void main(String[] args) {
        WebDriver driver = BrowserActions.start();

        System.out.println("STEP - Navigate to Demo Tables");
        driver.findElement(By.linkText("Demo Tables")).click();

        String xpath = "//table[@class='table' and @id='table1']/thead/tr";
        WebElement elColumns = driver.findElement(By.xpath(xpath));
        System.out.println(elColumns.getText());

        xpath = "//table[@class='table' and @id='table1']/tbody/tr";
        List<WebElement> elRowDetails = driver.findElements(By.xpath(xpath));

        for(WebElement e : elRowDetails){
            System.out.println(e.getText());
        }
    }
}
