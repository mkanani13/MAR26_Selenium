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
package Amitjoshi.Assignments.Basics.DropDown;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class Assignment13 {
    public static void main(String[] args) throws InterruptedException {

        // Step 1: Launch the website
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/");
        System.out.println("✔ Opened: http://automationbykrishna.com/");

        // Step 2: Click on "Basic Elements" tab
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Basic Elements")
        )).click();
        System.out.println("✔ Clicked on 'Basic Elements' tab");

        // Step 3: Find the Multi-Select dropdown
        WebElement multiSelectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//select[@multiple]")
        ));
        System.out.println("✔ Found the Multi-Select dropdown");

        // Step 4: Scroll down to the Multi-Select dropdown
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", multiSelectElement);
        System.out.println("✔ Scrolled to Multi-Select section");
        Thread.sleep(1000);

        // Step 5: Create Select object and verify it supports multiple selection
        Select multiSelect = new Select(multiSelectElement);
        System.out.println("✔ Is Multi-Select dropdown: " + multiSelect.isMultiple());

        // Step 6: Select options '2' and '5'
        multiSelect.selectByVisibleText("2");
        System.out.println("✔ Selected option: 2");

        multiSelect.selectByVisibleText("5");
        System.out.println("✔ Selected option: 5");

        // Step 7: Retrieve all selected options and display in console
        List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();

        System.out.println("\n=============================");
        System.out.println("  SELECTED OPTIONS OUTPUT");
        System.out.println("=============================");
        System.out.println("Total options selected : " + selectedOptions.size());
        System.out.println("-----------------------------");
        for (WebElement option : selectedOptions) {
            System.out.println("  ➡ Selected Value     : " + option.getText());
            System.out.println("     isSelected()      : " + option.isSelected());
        }
        System.out.println("=============================");

        driver.close();
    }
}