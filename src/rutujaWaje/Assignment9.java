//Assignment 9
//Automate the following scenario using Selenium WebDriver in Java:
//Open the application: http://automationbykrishna.com/
//Click on the “Basic Elements” tab/button.
//Scroll down the page and in the "Inline checkboxes" section perform the following activities:-
//Select the checkbox with number '1'
//Use the isSelected() method to confirm whether the intended checkbox is currently selected or not.
//Hint:- isSelected() method is used to check whether a selectable element is currently selected or not.
//isSelected() method returns a boolean value.
//if true, then selectable elemment is currently selected else not selected.
package rutujaWaje;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment9 {
    @Test
    public void inlinecheckboxselection1() throws InterruptedException {
            System.out.println("Launch Browser");
            WebDriver driver = new ChromeDriver();
            driver.get("http://automationbykrishna.com/");
            driver.manage().window().maximize();

            System.out.println("Click on Basic Element tab");
            Thread.sleep(2000);
            WebElement basicelement=driver.findElement(By.xpath("//*[@id='basicelements']"));
            basicelement.click();
            Thread.sleep(2000);

            System.out.println("Click the inline checkbox");
            WebElement checkbox = driver.findElement(By.xpath("//input[@id='inlineCheckbox1'][1]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
            checkbox.click();
            Assert.assertTrue(checkbox.isSelected(),"Checkbox is NOT selected");
            driver.quit();
        }
    }





