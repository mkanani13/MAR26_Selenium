/*
Using Selenium WebDriver with Java, automate the following scenario:

Launch the website http://automationbykrishna.com/.
Navigate to the "Basic Elements" section by clicking on the corresponding tab.
Scroll down until the "Multi-Select" dropdown is visible.
From the multi-select dropdown, choose the options '2' and '5'.
Retrieve the selected values and display the Output in the Console.

 */

package AutomationScript.DropDown;

import base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Assignment11 {
    public static void main(String[] args)  {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.id("basicelements")).click();
        System.out.println("we find the element and clicked on it");
       WebElement DropDElement =  driver.findElement(By.xpath("//select[@class ='form-control']"));
       Select selectNumber = new Select(DropDElement);

        System.out.println("STEP - print all the options of the first dropdown");
       List<WebElement> multiSelectElement = selectNumber.getOptions();
        System.out.println("total options "+ multiSelectElement);
        Select multiSelect = new Select (DropDElement);
        System.out.println("Is Multi-Select dropdown: " + multiSelect.isMultiple());
        multiSelect.selectByIndex(2);
        multiSelect.selectByValue("4");
        System.out.println("selected valuewws are " );


        System.out.println("end");



    }
}