package jayeshSonawane;

import jayeshSonawane.base.BrowserActions;
import jayeshSonawane.base.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

public class Assignment12 {
    public static void main(String[] args) {
        WebDriver driver = BrowserActions.start();

        System.out.println("STEP - Navigate to Basic Elements");
        driver.findElement(By.linkText("Basic Elements")).click();

        System.out.println("STEP - Scroll till Multi Select dropdown");
        WebElement elMultiSelectDD = driver.findElement(By.xpath("(//form[@class='form-horizontal adminex-form' and @method='get'])[2]/div[3]/div/select[2]"));
        ElementActions.scrollTo(driver, elMultiSelectDD);

        System.out.println("STEP - Select Options");
        Select options = new Select(elMultiSelectDD);

        options.selectByVisibleText("2");
        options.selectByVisibleText("5");

        List<WebElement> selectedOptions = options.getAllSelectedOptions();

        for (WebElement e : selectedOptions){
            System.out.println("Selected Option is : " + e.getText());
        }

        System.out.println("STEP - Deselect Option");
        options.deselectByVisibleText("5");
        System.out.println("Option Deselected");

        selectedOptions = options.getAllSelectedOptions();
        for (WebElement e : selectedOptions){
            System.out.println("Selected Option is : " + e.getText());
        }

        BrowserActions.close();
    }
}
