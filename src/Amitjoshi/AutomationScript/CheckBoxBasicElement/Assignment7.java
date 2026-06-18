/*
Automate the following scenario using Selenium WebDriver in Java:

Open the application: http://automationbykrishna.com/
Click on the “Basic Elements” tab/button.

Scroll down the page and in the "Checkbox and radios" section perform the following activities:-

Select the checkbox
"Option one is this and that—be sure to include why it's great option one"

Use the isSelected() method to confirm whether the checkbox is currently selected or not.

Hint:- isSelected() method is used to check whether a selectable element is currently selected or not.
isSelected() method returns a boolean value.
if true, then selectable elemment is currently selected else not selected.

 */

package AutomationScript.CheckBoxBasicElement;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("Getting URL and clicking required text");
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.linkText("Basic Elements")).click();

        System.out.println("Finding radio button element");
       WebElement radios = driver.findElement(By.xpath("//input[@id='optionsRadios1']"));
        System.out.println("Scrolling to the element");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", radios);

        radios.click();
        System.out.println("Clicked the radio button");

        // ✅ Check if radio is selected
        System.out.println("Is Selected: " + radios.isSelected());


        // ✅ Compare label text with expected
        String expectedText = "Option one is this and that—be sure to include why it's great option one";
        String Actual = radios.getText();

        if (Actual .equals(expectedText)) {
            System.out.println("The required option is selected ✓");
        } else {
            System.out.println("Text does not match ✗");
            System.out.println("Expected : " + expectedText);
            System.out.println("Actual   : " + Actual);
        }

        driver.close();
    }
}