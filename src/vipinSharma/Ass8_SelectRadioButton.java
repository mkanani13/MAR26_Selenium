//Automate the following scenario using Selenium WebDriver in Java:
//
//Open the application: http://automationbykrishna.com/
//Click on the “Basic Elements” tab/button.
//
//Scroll down the page and in the "Checkbox and radios" section perform the following activities:-
//
//Select the radiobutton
//Option two can be something else and selecting it will deselect option one
//
//Use the isSelected() method to confirm whether the intended radiobutton is currently selected or not.
//
//Hint:- isSelected() method is used to check whether a selectable element is currently selected or not.
//isSelected() method returns a boolean value.
//if true, then selectable elemment is currently selected else not selected.

package automationScritps;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ass8_SelectRadioButton {

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
    public void radioBtnSelection() throws InterruptedException {
        WebElement radioButton=driver.findElement(By.xpath("//div[@class='form-group']//input[@id='optionsRadios2']"));
        System.out.println("STEP - Element Scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",radioButton);
        System.out.println("STEP - Radio button click");
        boolean actualRadioBtnResult = radioButton.isSelected();
        boolean expectedRadioBtnResult = false;
        Assert.assertEquals(actualRadioBtnResult, expectedRadioBtnResult, "Radio Button already selected");
        System.out.println("STEP - Radio button click");
        radioButton.click();
    }
}
