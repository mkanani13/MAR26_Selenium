/*
Selenium Assignment - 10: 12th June'2026
Automate the following scenario using Selenium WebDriver in Java:

Open the application: http://automationbykrishna.com/
Click on the “Basic Elements” tab/button.

Scroll down the page and in the "Selects" section dropdown perform the following activities:-

Select the option with number '3' from the dropdown

Use the isSelected() method to confirm whether the intended dropdown option is currently selected or not

Hint:- isSelected() method is used to check whether a selectable element is currently selected or not.
isSelected() method returns a boolean value.
if true, then selectable elemment is currently selected else not selected.
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

public class Assignment10 {

    public void verifyDropdownSelection() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        System.out.println("STEP: Enter the URL for Automation by krishna");
        driver.get("http://automationbykrishna.com/");

        driver.manage().window().maximize();

        System.out.println("STEP: Click on Basic Elements");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("STEP: Navigate to select dropdown");

        WebElement ddElement = driver.findElement(By.xpath("//form[@class= 'form-horizontal adminex-form']/div[3]/div/select[1]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",ddElement);

        Select oselect = new Select(ddElement);

        List<WebElement> listOfOptions= oselect.getOptions();
        oselect.selectByIndex(listOfOptions.size()-1);
        System.out.println("Total number of options in dropdown are:: " +listOfOptions.size());
        for(WebElement e :listOfOptions){
            if(e.isSelected()){
                System.out.println("Selected option is ::"+ e.getText());
            }

        }
        driver.quit();
    }
    @Test
    public void main() throws InterruptedException {
        Assignment10 assignment10= new Assignment10();
        assignment10.verifyDropdownSelection();
    }
}
