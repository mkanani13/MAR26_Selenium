package kamleshDeshmukh.Assignments;


import kamleshDeshmukh.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Assignment12_a {
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
    public  void printDropdownOptions() {


        System.out.println("STEP- Click on Basic Elements tab");
        driver.findElement(By.id("basicelements")).click();

        System.out.println("STEP- Select options 2 and 5 from dropdown.");
        WebElement multiSelectDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select s = new Select(multiSelectDropdown);
        s.selectByVisibleText("2");
        s.selectByVisibleText("5");

        System.out.println("STEP- Print all currently selected options in the console.");
        System.out.println("Selected Options:");
        printSelectedOptions(s);

        System.out.println("STEP- Deselect the option '5' from the dropdown.");
        s.deselectByVisibleText("5");

        System.out.println("STEP- Retrieve and print the updated list of selected options in the Console after deselection.");
        System.out.println("Selected Options After Deselecting 5:");
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


