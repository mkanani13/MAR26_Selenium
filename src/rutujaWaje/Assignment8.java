//Assignment 8
//Automate the following scenario using Selenium WebDriver in Java:
//Open the application: http://automationbykrishna.com/
//Click on the “Basic Elements” tab/button.
//Scroll down the page and in the "Checkbox and radios" section perform the following activities:-
//Select the radiobutton
//Option two can be something else and selecting it will deselect option one
//Use the isSelected() method to confirm whether the intended radiobutton is currently selected or not.
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

public class Assignment8 {
    @Test
    public void radiobuttonselection() throws InterruptedException {
            System.out.println("Launch Browser");
            WebDriver driver = new ChromeDriver();
            driver.get("http://automationbykrishna.com/");
            driver.manage().window().maximize();

            System.out.println("Click on basic element tab");
            WebElement basicElement = driver.findElement(By.id("basicelements"));
            basicElement.click();
            Thread.sleep(2000);

            System.out.println("Click on radio button-2 option");
            WebElement option2 = driver.findElement(By.xpath("//div[@class='radio'][2]/label/input"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", option2);
            Thread.sleep(1000);
            option2.click();
            Assert.assertTrue(option2.isSelected(),"FAIL : Option 2 radio button is not selected.");
            driver.quit();
        }
    }





