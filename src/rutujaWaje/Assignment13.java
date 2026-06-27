//Using Selenium WebDriver in Java, automate the following scenario:
//
//Open the website http://automationbykrishna.com/.
//Click on the "Basic Elements" tab to navigate to the Basic Elements section.
//Scroll down until the Multi-Select dropdown is visible on the page.
//Select the options '2' and '5' from the multi-select dropdown.
//Retrieve and print all selected options in the Console.
//Deselect the option '5' and print the updated selected options in the Console.
//Deselect the option '2' and print the updated selected options in the Console again.
package rutujaWaje;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Assignment13 {
    @Test
    public void deselectopt2and5() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.id("basicelements")).click();
        Thread.sleep(3000);

        WebElement multiSelectDropdown = driver.findElement(By.xpath("//select[@multiple]"));

        System.out.println("Scroll until dropdown is visible");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", multiSelectDropdown);

        Select select = new Select(multiSelectDropdown);

        System.out.println("Select options 2 and 5");
        select.selectByVisibleText("2");
        select.selectByVisibleText("5");

        System.out.println("Selected Options:");
        printSelectedOptions(select);

        // Assertion after selecting 2 and 5
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        Assert.assertEquals(selectedOptions.size(), 2,
                "Expected 2 options to be selected.");
        Assert.assertEquals(selectedOptions.get(0).getText(), "2");
        Assert.assertEquals(selectedOptions.get(1).getText(), "5");

        System.out.println("Deselect option 5");
        select.deselectByVisibleText("5");

        System.out.println("After Deselecting 5:");
        printSelectedOptions(select);

        // Assertion after deselecting 5
        selectedOptions = select.getAllSelectedOptions();
        Assert.assertEquals(selectedOptions.size(), 1,
                "Expected only 1 option to be selected.");
        Assert.assertEquals(selectedOptions.get(0).getText(), "2");

        System.out.println("Deselect option 2");
        select.deselectByVisibleText("2");

        System.out.println("After Deselecting 2:");
        printSelectedOptions(select);

        // Assertion after deselecting 2
        selectedOptions = select.getAllSelectedOptions();
        Assert.assertTrue(selectedOptions.isEmpty(),
                "Expected no options to be selected.");

        driver.quit();
    }

    public void printSelectedOptions(Select select) {
        List<WebElement> selectedOptions = select.getAllSelectedOptions();

        if (selectedOptions.isEmpty()) {
            System.out.println("No options selected");
        } else {
            for (WebElement option : selectedOptions) {
                System.out.println(option.getText());
            }
        }
    }
}
