//Automate the following scenario using Selenium WebDriver in Java:
//
//Open the application: http://automationbykrishna.com/
//Click on the “Basic Elements” tab/button.
//
//Scroll down the page and in the "Checkbox and radios" section perform the following activities:-
//
//Select the checkbox
//"Option one is this and that—be sure to include why it's great option one"
//
//Use the isSelected() method to confirm whether the checkbox is currently selected or not.
//
//Hint:- isSelected() method is used to check whether a selectable element is currently selected or not.
//isSelected() method returns a boolean value.
//if true, then selectable elemment is currently selected else not selected.

package vipinSharma;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ass7_SelectCheckbox {

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
    public void checkBoxSelection() throws InterruptedException {
        Thread.sleep(1000);
        WebElement checkBox=driver.findElement(By.xpath("//div[@class='form-group']//div[2]//label[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",checkBox );
        System.out.println("STEP - Element Scroll");
        Thread.sleep(1000);
        boolean actualCheckBoxResult = checkBox.isSelected();
        boolean expectedCheckBoxResult = false;
        Assert.assertEquals(actualCheckBoxResult, expectedCheckBoxResult, "CheckBox already selected");
        System.out.println("STEP - CheckBox click");
        checkBox.click();
    }

}
