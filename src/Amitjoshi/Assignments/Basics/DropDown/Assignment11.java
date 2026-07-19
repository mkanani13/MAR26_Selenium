/*
Using Selenium WebDriver with Java, automate the following scenario:

Launch the website http://automationbykrishna.com/.
Navigate to the "Basic Elements" section by clicking on the corresponding tab.
Scroll down until the "Multi-Select" dropdown is visible.
From the multi-select dropdown, choose the options '2' and '5'.
Retrieve the selected values and display the Output in the Console.

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

public class Assignment11 {
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
    public void verifyMultiSelectValuesTwoAndFive() {
        driver.findElement(By.id("basicelements")).click();
        Select multiSelect = getMultiSelect();
        Assert.assertTrue(multiSelect.isMultiple(), "The dropdown should support multiple selections.");

        multiSelect.selectByVisibleText("2");
        multiSelect.selectByVisibleText("5");
        List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();

        Assert.assertEquals(selectedOptions.size(), 2);
        Assert.assertTrue(isOptionSelected(selectedOptions, "2"));
        Assert.assertTrue(isOptionSelected(selectedOptions, "5"));
        selectedOptions.forEach(option -> System.out.println(option.getText()));
    }

    private Select getMultiSelect() {
        return new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@multiple]"))));
    }

    private boolean isOptionSelected(List<WebElement> options, String expectedText) {
        return options.stream().anyMatch(option -> option.getText().equals(expectedText));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}