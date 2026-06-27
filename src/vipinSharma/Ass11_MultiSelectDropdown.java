//Using Selenium WebDriver with Java, automate the following scenario:
//
//Launch the website http://automationbykrishna.com/.
//Navigate to the "Basic Elements" section by clicking on the corresponding tab.
//Scroll down until the "Multi-Select" dropdown is visible.
//From the multi-select dropdown, choose the options '2' and '5'.
//Retrieve the selected values and display the Output in the Console.

package vipinSharma;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Ass11_MultiSelectDropdown {
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
    public void verifyMultiSelectDrpOptions() throws InterruptedException {
        WebElement mulDropdown = driver.findElement(By.xpath("//div[@class='form-group']//select[2]"));
        System.out.println("STEP - Element scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", mulDropdown);
        Select sl= new Select(mulDropdown);
        System.out.println("STEP - Verify dropdown is multiple");
        boolean actualDrIsISMultiple = sl.isMultiple();
        boolean expectedDrpIsMultiple = true;
        Assert.assertEquals(actualDrIsISMultiple, expectedDrpIsMultiple, "Dropdown is not mul-selected");
        Thread.sleep(1000);
        System.out.println("STEP - Option selection from dropdown");
        sl.selectByVisibleText("2");
        sl.selectByVisibleText("5");
        List<WebElement> selectedOption = sl.getAllSelectedOptions();
        for (WebElement optionList: selectedOption){
            System.out.println("Selected options are : " + optionList.getText());
        }

        //boolean actualCheckBoxResult = checkBox.isSelected();
        //boolean expecteCheckBoxResult = false;
       // Assert.assertEquals(actualCheckBoxResult, expecteCheckBoxResult, "Check box already selected");

    }
}
