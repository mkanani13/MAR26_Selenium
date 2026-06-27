package kamleshDeshmukh.Assignments;
/*Open the website http://automationbykrishna.com/.
Click on the "Basic Elements" tab to navigate to the Basic Elements section.
Scroll down until the Multi-Select dropdown is visible on the page.
Select the options '2' and '5' from the multi-select dropdown.
Retrieve and print all selected options in the Console.
Deselect the option '5' and print the updated selected options in the Console.
Deselect the option '2' and print the updated selected options in the Console again.
*/
import kamleshDeshmukh.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Assignment13 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserActions.start();
    }

    public static void printSelectedOptions(Select s) {

        List<WebElement> selectedOptions = s.getAllSelectedOptions();
        for (WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }
    }

    @Test
    public  void printSelectedOptions(){

        System.out.println("STEP- Click on Basic Elements tab");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();


        System.out.println("STEP- Scroll down to the Selects section");
        WebElement selectsSection = driver.findElement(By.xpath("//label[text()='Selects']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", selectsSection);

        System.out.println("STEP- Select options 2 and 5 from dropdown.");
        WebElement multiSelectDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select s = new Select(multiSelectDropdown);
        s.selectByVisibleText("2");
        s.selectByVisibleText("5");

        System.out.println("STEP- Retrieve and print selected values on console.");
        System.out.println("The selected values are: ");
        printSelectedOptions(s);

        System.out.println("STEP-Deselect the option '5' and print the updated selected options in the Console.");
        s.deselectByVisibleText("5");
        System.out.println("Selected options after deselecting 5:");
        printSelectedOptions(s);

        System.out.println("STEP-Deselect the option '2' and print the updated selected options in the Console.");
        s.deselectByVisibleText("2");
        System.out.println("Selected options after deselecting 2:");
        printSelectedOptions(s);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("STEP- Close the browser.");
        if (driver != null) {
            driver.quit();
        }
    }
}
