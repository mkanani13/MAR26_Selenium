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

package Amitjoshi.Assignments.Basics.CheckBoxBasicElement;

import java.time.Duration;

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

public class Assignment10 {
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
    public void verifyDropdownOptionThreeIsSelected() {
        driver.findElement(By.id("basicelements")).click();
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select.form-control")));
        Select select = new Select(dropdown);
        select.selectByVisibleText("3");

        WebElement selectedOption = select.getFirstSelectedOption();
        Assert.assertEquals(selectedOption.getText(), "3");
        Assert.assertTrue(selectedOption.isSelected(), "Option 3 should be selected.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}