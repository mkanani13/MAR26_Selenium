/*
Using Selenium WebDriver in Java, automate the following scenario:

Open the website http://automationbykrishna.com/.
Click on the "Basic Elements" tab to navigate to the corresponding section.
Scroll down to the Multi-Select dropdown.
Select the options '2' and '5' from the dropdown.
Fetch and print all currently selected options in the Console.
Deselect the option '5' from the dropdown.
Fetch and print the updated list of selected options in the Console after deselection.

 */

package Amitjoshi.Assignments.Basics.DropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment12 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/");
    }

    @Test
    public void verifyDeselectingOptionFive() {
        driver.findElement(By.id("basicelements")).click();
        Select multiSelect = getMultiSelect();
        multiSelect.selectByVisibleText("2");
        multiSelect.selectByVisibleText("5");
        Assert.assertEquals(multiSelect.getAllSelectedOptions().size(), 2);

        multiSelect.deselectByVisibleText("5");
        List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();

        Assert.assertEquals(selectedOptions.size(), 1);
        Assert.assertEquals(selectedOptions.get(0).getText(), "2");
        selectedOptions.forEach(option -> System.out.println(option.getText()));
    }

    private Select getMultiSelect() {
        return new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@multiple]"))));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}