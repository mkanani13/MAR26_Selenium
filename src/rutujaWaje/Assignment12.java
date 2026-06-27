package rutujaWaje;
//Using Selenium WebDriver in Java, automate the following scenario:
//
//Open the website http://automationbykrishna.com/.
//Click on the "Basic Elements" tab to navigate to the corresponding section.
//Scroll down to the Multi-Select dropdown.
//Select the options '2' and '5' from the dropdown.
//Fetch and print all currently selected options in the Console.
//Deselect the option '5' from the dropdown.
//Fetch and print the updated list of selected options in the Console after deselection.

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Assignment12 {
    @Test
    public void multiselect2and5() throws InterruptedException {
        System.out.println("Launch Browser");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            System.out.println("click on the Test url");
            driver.get("http://automationbykrishna.com/");
            WebElement basicelement =driver.findElement(By.xpath("//a[@id='basicelements']"));
            basicelement.click();
            Thread.sleep(2000);

            System.out.println("Select with the number 3 ");
            WebElement multiSelectDropdown  = driver.findElement(By.xpath("//select[@class='form-control']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", multiSelectDropdown );
            Thread.sleep(3000);

            System.out.println("Select multiple option from dropdown");
            Select select = new Select(multiSelectDropdown);
            select.selectByVisibleText("2");
            select.selectByVisibleText("5");
            List<WebElement> selectedOptions = select.getAllSelectedOptions();
            System.out.println("Selected Values:");

            for (WebElement option : selectedOptions) {
                System.out.println(option.getText());
            }
            select.deselectByVisibleText("5");
            System.out.println("Fetch and print updated selected options");
            System.out.println("After Deselecting 5:");
            selectedOptions = select.getAllSelectedOptions();
            for (WebElement option : selectedOptions) {
                System.out.println(option.getText());
            }
            driver.quit();
        }
    }


