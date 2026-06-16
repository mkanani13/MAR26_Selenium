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

Select the checkbox
"Option one is this and that—be sure to include why it's great option one"

Use the isSelected() method to confirm whether the checkbox is currently selected or not.

Hint:- isSelected() method is used to check whether a selectable element is currently selected or not.
isSelected() method returns a boolean value.
if true, then selectable element is currently selected else not selected.
 */
public class Assignment7_65 {

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

        WebElement elementCheckBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[7]"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",elementCheckBox2);

        elementCheckBox2.click();

        if(elementCheckBox2.isSelected()){
            System.out.println("Currently Selected");
        }else{
            System.out.println("Not Selected");
        }

    }
}
