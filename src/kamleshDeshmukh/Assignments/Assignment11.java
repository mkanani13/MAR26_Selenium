package kamleshDeshmukh.Assignments;
/*
Launch the website http://automationbykrishna.com/.
Navigate to the "Basic Elements" section by clicking on the corresponding tab.
Scroll down until the "Multi-Select" dropdown is visible.
From the multi-select dropdown, choose the options '2' and '5'.
Retrieve the selected values and display the Output in the Console.
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

public class Assignment11 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserActions.start();
    }

    @Test
    public  void verifyDDOptions() {
        System.out.println("STEP- Click on Basic Elements tab");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();

        System.out.println("STEP- Scroll down to the Selects section");
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

        System.out.println("STEP- Display selected values.");
        System.out.println("The selected values are: ");
        for (WebElement option : selectedOptions) {

            System.out.println(option.getText());
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
