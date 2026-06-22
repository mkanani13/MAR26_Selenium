//Using Selenium WebDriver with Java, automate the following scenario:
//
//Launch the website http://automationbykrishna.com/.
//Navigate to the "Basic Elements" section by clicking on the corresponding tab.
//Scroll down until the "Multi-Select" dropdown is visible.
//From the multi-select dropdown, choose the options '2' and '5'.
//Retrieve the selected values and display the Output in the Console.
package rutujaWaje;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Assignment11 {
    public void multiselectdropdown() throws InterruptedException {
            System.out.println("Launch Browser");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://automationbykrishna.com/");

            System.out.println("Click on Basic Element tab");
            WebElement basicelement =driver.findElement(By.xpath("//a[@id='basicelements']"));
            basicelement.click();
            Thread.sleep(2000);

            System.out.println("Select with the number 2 and 5 ");
            WebElement multiSelectDropdown  = driver.findElement(By.xpath("//select[@class='form-control']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", multiSelectDropdown );
            Thread.sleep(3000);
            Select select = new Select(multiSelectDropdown);
            select.selectByVisibleText("2");
            select.selectByVisibleText("5");
            List<WebElement> selectedOptions = select.getAllSelectedOptions();
            Assert.assertEquals(selectedOptions.size(), 2, "Expected 2 selected options.");
            System.out.println("Selected Values:");
            for (WebElement option : selectedOptions) {
                System.out.println(option.getText());
            }
            driver.quit();
        }
    }



