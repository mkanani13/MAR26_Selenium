package kamleshDeshmukh.Assignments;
/*
Open the website http://automationbykrishna.com/.
Click on the "Basic Elements" tab to navigate to the corresponding section.
Scroll down to the Multi-Select dropdown.
Select the options '2' and '5' from the dropdown.
Fetch and print all currently selected options in the Console.
Deselect the option '5' from the dropdown.
Fetch and print the updated list of selected options in the Console after deselection.

 */

import kamleshDeshmukh.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Assignment12 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserActions.start();
    }

    @Test
    public  void verifyDeselectionDropDown() {

        System.out.println("STEP- Click on Basic Elements tab");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();

        System.out.println("STEP- Scroll down to the Multiselect dropdown");
        WebElement selectsSection = driver.findElement(By.xpath("//label[text()='Selects']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", selectsSection);

        System.out.println("STEP- Select options 2 and 5 from dropdown.");
        WebElement multiSelectDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select s = new Select(multiSelectDropdown);
        s.selectByVisibleText("2");
        s.selectByVisibleText("5");

        System.out.println("STEP- Retrieve selected values.");
        List<WebElement> selectedOptions = s.getAllSelectedOptions();

        System.out.println("STEP- Print all currently selected options in the console.");
        System.out.println("The currently selected values are: ");
        for (WebElement option : selectedOptions) {

            System.out.println(option.getText());
        }

        System.out.println("STEP- Deselect the option '5' from the dropdown.");
        s.deselectByVisibleText("5");

        System.out.println("STEP- Retrieve and print the updated list of selected options in the Console after deselection.");
        List<WebElement> updatedList = s.getAllSelectedOptions();
        for(WebElement e : updatedList){
            System.out.println("Selected Options After Deselecting 5: "+e.getText());
        }
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("STEP- Close the browser.");
        if (driver != null) {
            driver.quit();
        }
    }
}
