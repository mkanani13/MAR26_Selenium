/*
Selenium Assignment - 12: 13th June'2026
Using Selenium WebDriver in Java, automate the following scenario:

Open the website http://automationbykrishna.com/.
Click on the "Basic Elements" tab to navigate to the corresponding section.
Scroll down to the Multi-Select dropdown.
Select the options '2' and '5' from the dropdown.
Fetch and print all currently selected options in the Console.
Deselect the option '5' from the dropdown.
Fetch and print the updated list of selected options in the Console after deselection.
*/

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

public class Assignment12 {

    public void verifyDropdownSelection() throws InterruptedException {
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
        oselect.deselectByVisibleText("5");
        List<WebElement> listOfSelectedOptionsAfterDeselect = oselect.getAllSelectedOptions();
        for(WebElement e :listOfSelectedOptionsAfterDeselect){
            System.out.println("Selected options after deselect are:" +e.getText());
        }

        driver.quit();
    }
    @Test
    public void verifySelectedOptions() throws InterruptedException {
            Assignment12 assignment12 = new Assignment12();
            assignment12.verifyDropdownSelection();
        }
}
