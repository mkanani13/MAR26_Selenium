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

Scroll down the page and in the "Inline checkboxes" section perform the following activities:-

Select the checkbox with number '1'

Use the isSelected() method to confirm whether the intended checkbox is currently selected or not.

Hint:- isSelected() method is used to check whether a selectable element is currently selected or not.
isSelected() method returns a boolean value.
if true, then selectable element is currently selected else not selected.
 */
public class Assignment9_67 {

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

        WebElement elementInlineCheckbox1 = driver.findElement(By.xpath("//input[@id='inlineCheckbox1']"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementInlineCheckbox1);

        elementInlineCheckbox1.click();

        if(elementInlineCheckbox1.isSelected()){
            System.out.println("Currently Selected");
        }else{
            System.out.println("Not Selected");
        }

    }
}
