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
Click on the "Basic Elements" tab to navigate to the Basic Elements section.
Scroll down until the Multi-Select dropdown is visible on the page.
Select the options '2' and '5' from the multi-select dropdown.
Retrieve and print all selected options in the Console.
Deselect the option '5' and print the updated selected options in the Console.
Deselect the option '2' and print the updated selected options in the Console again.
 */
public class Assignment13 {
    public static void main(String[] args) {
        WebDriver driver = BrowserActions.start();

        System.out.println("STEP - Navigate to Basic Elements");
        driver.findElement(By.linkText("Basic Elements")).click();

        System.out.println("STEP - Scroll till Multi Select dropdown");
        String xpath = "(//form[@class='form-horizontal adminex-form' and @method='get'])[2]/div[3]/div/select[2]";
        WebElement elMultiSelectDD = driver.findElement(By.xpath(xpath));
        ElementActions.scrollTo(driver, elMultiSelectDD);

        System.out.println("STEP - Select Options");
        Select options = new Select(elMultiSelectDD);

        options.selectByVisibleText("2");
        options.selectByVisibleText("5");

        List<WebElement> selectedOptions = options.getAllSelectedOptions();
        ElementActions.printElement(selectedOptions);

        System.out.println("STEP - Deselect Option");
        options.deselectByVisibleText("5");
        System.out.println("Option Deselected");

        selectedOptions = options.getAllSelectedOptions();
        ElementActions.printElement(selectedOptions);

        System.out.println("STEP - Deselect Option");
        options.deselectByVisibleText("2");
        System.out.println("Option Deselected");

        selectedOptions = options.getAllSelectedOptions();
        ElementActions.printElement(selectedOptions);

        BrowserActions.close();
    }
}
