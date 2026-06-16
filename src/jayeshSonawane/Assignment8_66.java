package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Automate the following scenario using Selenium WebDriver in Java:

Open the application: http://automationbykrishna.com/
Click on the “Basic Elements” tab/button.

Scroll down the page and in the "Checkbox and radios" section perform the following activities:-

Select the radiobutton
Option two can be something else and selecting it will deselect option one

Use the isSelected() method to confirm whether the intended radiobutton is currently selected or not.

Hint:- isSelected() method is used to check whether a selectable element is currently selected or not.
isSelected() method returns a boolean value.
if true, then selectable element is currently selected else not selected.
 */

public class Assignment8_66 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/");

        driver.findElement(By.xpath("//a[@id='basicelements']")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement elementRadioBox2 = driver.findElement(By.xpath("//input[@id='optionsRadios2']"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementRadioBox2);

        elementRadioBox2.click();

        if(elementRadioBox2.isSelected()){
            System.out.println("Currently Selected");
        }else{
            System.out.println("Not Selected");
        }

    }
}
