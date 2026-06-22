//Automate the following scenario using Selenium WebDriver in Java:
//
//Open the application: http://automationbykrishna.com/
//Click on the “Basic Elements” tab/button.
//
//Scroll down the page and in the "Selects" section dropdown perform the following activities:-
//
//Select the option with number '3' from the dropdown
//
//Use the isSelected() method to confirm whether the intended dropdown option is currently selected or not
//
//Hint:- isSelected() method is used to check whether a selectable element is currently selected or not.
//isSelected() method returns a boolean value.
//if true, then selectable elemment is currently selected else not selected.

package vipinSharma;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ass10_SingleSelectDropdown {
    WebDriver driver;
    Alert alert;

    @BeforeTest
    public void setUp() {
        System.out.println("STEP - WebDriver Initializing and Browser Launched");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("STEP - URL Navigation");
        driver.get("http://automationbykrishna.com/");
        System.out.println("STEP - Page Verification after redirect");
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Login Signup Demo";
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Page title not match!");
        System.out.println("STEP - Basic Elements link click");
        driver.findElement(By.id("basicelements")).click();

    }

    @AfterTest
    public void setupEnd() {
        driver.quit();
        System.out.println("Browser closed");
    }

    @Test
    public void verifySingleSelectDropdown() throws InterruptedException {

        WebElement dropdown = driver.findElement(By.xpath("//div[@class='form-group']//select[1]"));
        System.out.println("STEP - Dropdown selection");
        Select sl= new Select(dropdown);
        sl.selectByIndex(2);
        WebElement drpSelectedValue = sl.getFirstSelectedOption();
        String actualDrpSelectedValue = drpSelectedValue.getText();
        String expectedDrpSelectedValue = "3";
        Assert.assertEquals(actualDrpSelectedValue, expectedDrpSelectedValue, "Selected value does not match!");
    }
}
