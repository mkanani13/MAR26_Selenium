package automationScriptAssignmentsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

/*
Using Selenium WebDriver with Java, automate the following scenario:

Launch the website http://automationbykrishna.com/.
Navigate to the "Basic Elements" section by clicking on the corresponding tab.
Scroll down until the "Multi-Select" dropdown is visible.
From the multi-select dropdown, choose the options '2' and '5'.
Retrieve the selected values and display the Output in the Console.

 */
public class Assignment11 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement multiselect = driver.findElement(By.xpath("//select[@class='form-control']"));

        Select select = new Select(multiselect);
        if (select.isMultiple()) {
            select.selectByVisibleText("2");
            select.selectByVisibleText("5");

            List<WebElement> selectedOptions = select.getAllSelectedOptions();
            for (WebElement selectedOption : selectedOptions) {
                System.out.println(selectedOption.getText());
            }
        }
        else{
            System.out.println("Given list is not multiselectedd");
        }
        driver.quit();
    }




}