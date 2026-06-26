package jayeshSonawane.assignments;
/*
Using Selenium WebDriver with Java, automate the following scenario:

Launch the website http://automationbykrishna.com/.
Navigate to the "Basic Elements" section by clicking on the corresponding tab.
Scroll down until the "Multi-Select" dropdown is visible.
From the multi-select dropdown, choose the options '2' and '5'.
Retrieve the selected values and display the Output in the Console.
 */
import jayeshSonawane.base.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import jayeshSonawane.base.BrowserActions;

import java.util.List;

public class Assignment11 {
    public static void main(String[] args) {
        WebDriver driver = BrowserActions.start();

        System.out.println("STEP - Navigate to Basic Elements");
        driver.findElement(By.linkText("Basic Elements")).click();

        System.out.println("STEP - Scroll till Multi Select Dropdown");
        WebElement elMultiSelectDD = driver.findElement(By.xpath("(//form[@class='form-horizontal adminex-form'])[2]/div[3]/div/select[2]"));
        ElementActions.scrollTo(driver, elMultiSelectDD);

        System.out.println("Select Options");
        Select ddOptions = new Select(elMultiSelectDD);
        ddOptions.selectByVisibleText("2");
        ddOptions.selectByVisibleText("5");

        List<WebElement> selectedOptions = ddOptions.getAllSelectedOptions();

        for(WebElement e : selectedOptions){
            System.out.println("Selected Option : " + e.getText());
        }

        BrowserActions.close();
    }
}
