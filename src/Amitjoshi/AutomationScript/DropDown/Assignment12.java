/*
Using Selenium WebDriver in Java, automate the following scenario:

Open the website http://automationbykrishna.com/.
Click on the "Basic Elements" tab to navigate to the corresponding section.
Scroll down to the Multi-Select dropdown.
Select the options '2' and '5' from the dropdown.
Fetch and print all currently selected options in the Console.
Deselect the option '5' from the dropdown.
Fetch and print the updated list of selected options in the Console after deselection.

 */

package AutomationScript.DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Assignment12 {
    public static void main(String[] args)  {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.id("basicelements")).click();
        System.out.println("we find the element and clicked on it");
        WebElement DropDElement =  driver.findElement(By.xpath("//select[@class ='form-control m-bot15']"));
        Select selectNumber = new Select(DropDElement);

        System.out.println("STEP - print all the options of the first dropdown");
        List<WebElement> listOfElement = selectNumber.getOptions();

        for (WebElement e : listOfElement){
            System.out.println(e.getText());

        }
    }
}
