/*
Automate the following scenario using Selenium WebDriver in Java:

Open the application: http://automationbykrishna.com/
Click on the “Basic Elements” tab/button.

Scroll down the page and in the "Inline checkboxes" section perform the following activities:-

Select the checkbox with number '1'

Use the isSelected() method to confirm whether the intended checkbox is currently selected or not.

Hint:- isSelected() method is used to check whether a selectable element is currently selected or not.
isSelected() method returns a boolean value.
if true, then selectable elemment is currently selected else not selected.

 */

package AutomationScript.CheckBoxBasicElement;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Assignment9 {
    public static void main(String[] args) throws InterruptedException {

        // Step 1: Open the application
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/");
        System.out.println(" web page opned ");

        // Step 2: Click on "Basic Elements" tab
        driver.findElement(By.linkText("Basic Elements")).click();
        System.out.println("✔ Clicked on 'Basic Elements' tab");

        // Step 3: Find Inline Checkbox '1'
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='inlineCheckbox1']"));
        System.out.println("✔ Found Inline Checkbox 1");

        // Step 4: Scroll down to the checkbox
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", checkbox1);
        System.out.println("✔ Scrolled to Inline Checkbox 1");

        Thread.sleep(1000); // small pause after scroll

        // Step 5: Click the checkbox to select it
        checkbox1.click();
        System.out.println("Clicked on Checkbox 1");

        // Step 6: Verify selection using isSelected()
        boolean isSelected = checkbox1.isSelected();
        System.out.println("isSelected() returned: " + isSelected);

        if (isSelected) {
            System.out.println(" PASS: Checkbox 1 is successfully selected");
        } else {
            System.out.println("FAIL: Checkbox 1 is NOT selected");
        }

        driver.close();
    }
}