/*Selenium Assignment - 11: 13th June'2026
Using Selenium WebDriver with Java, automate the following scenario:

Launch the website http://automationbykrishna.com/.
Navigate to the "Basic Elements" section by clicking on the corresponding tab.
Scroll down until the "Multi-Select" dropdown is visible.
From the multi-select dropdown, choose the options '2' and '5'.
Retrieve the selected values and display the Output in the Console.*/

package rajashreePatil.automationScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Assignment11 {

    static public void verifyDropdownSelection() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        System.out.println("STEP: Enter the URL for Automation by krishna");
        driver.get("http://automationbykrishna.com/");

        driver.manage().window().maximize();

        System.out.println("STEP: Click on Basic Elements");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("STEP: Navigate to select dropdown");

        WebElement ddElement = driver.findElement(By.xpath("//form[@class= 'form-horizontal adminex-form']/div[3]/div/select[2]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", ddElement);

        Select oselect = new Select(ddElement);
        List<WebElement> listOfOptions = oselect.getOptions();
        oselect.selectByIndex(listOfOptions.size() - 3);
        oselect.selectByIndex(listOfOptions.size() - 1);

        System.out.println(oselect.isMultiple()); // returns true if dropdown ia multi selet
        System.out.println("---------------");

        List<WebElement> listOfSelectedOptions = oselect.getAllSelectedOptions();

        System.out.println("Total number of options in dropdown are:: " + listOfSelectedOptions.size());
        for (WebElement e : listOfSelectedOptions) {
            if (e.isSelected()) {
                System.out.println("Selected option is ::" + e.getText());
            }
        }
        driver.quit();
    }
    @Test
        public void main() throws InterruptedException {
            Assignment11 assignment11= new Assignment11();
            assignment11.verifyDropdownSelection();
        }
}
