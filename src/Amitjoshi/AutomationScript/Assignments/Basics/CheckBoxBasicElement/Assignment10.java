/*
Automate the following scenario using Selenium WebDriver in Java:

Open the application: http://automationbykrishna.com/
Click on the “Basic Elements” tab/button.

Scroll down the page and in the "Selects" section dropdown perform the following activities:-

Select the option with number '3' from the dropdown

Use the isSelected() method to confirm whether the intended dropdown option is currently selected or not

Hint:- isSelected() method is used to check whether a selectable element is currently selected or not.
isSelected() method returns a boolean value.
if true, then selectable elemment is currently selected else not selected.

 */

package AutomationScript.CheckBoxBasicElement;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Assignment10 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/");
        System.out.println("✔ Opened: http://automationbykrishna.com/");

        // Step 2: Click on "Basic Elements" tab

              driver.findElement(By.linkText("Basic Elements")).click();
        System.out.println(" Clicked on 'Basic Elements' tab");

        // Step 3: Find the dropdown in the "Selects" section
        WebElement dropdownElement = driver.findElement(By.xpath("//select[contains(@class,'form-control')]"));
        System.out.println(" Found the dropdown element");

        // Step 4: Scroll down to the dropdown
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", dropdownElement);
        System.out.println("Scrolled to the 'Selects' section");
        Thread.sleep(1000);

        // Step 5: Create Select object and select option '3'
        Select select = new Select(dropdownElement);
        select.selectByVisibleText("3");      // Select by visible text
        System.out.println(" Selected option '3' from the dropdown");

        // Step 6: Verify using isSelected()
        WebElement selectedOption = select.getFirstSelectedOption();
        boolean isSelected = selectedOption.isSelected();

        System.out.println(" Selected option text : " + selectedOption.getText());
        System.out.println(" isSelected() returned: " + isSelected);

        if (isSelected) {
            System.out.println("PASS: Option '3' is successfully selected");
        } else {
            System.out.println(" FAIL: Option '3' is NOT selected");
        }

        driver.close();
        driver.quit();
    }
}