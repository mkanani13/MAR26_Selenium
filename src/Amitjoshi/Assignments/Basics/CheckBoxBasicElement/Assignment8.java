package Amitjoshi.Assignments.Basics.CheckBoxBasicElement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("Getting URL and clicking required text");
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.linkText("Basic Elements")).click();

        System.out.println("Finding radio button element");
        WebElement radios = driver.findElement(By.xpath("//input[@id='optionsRadios2']"));
        System.out.println("Scrolling to the element");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", radios);

        radios.click();
        System.out.println("Clicked the radio button");

        // ✅ Check if radio is selected
        System.out.println("Is Selected: " + radios.isSelected());


        // ✅ Compare label text with expected
        String expectedText = "Option two can be something else and selecting it will deselect option one";
        String Actual = radios.getText();

        if (Actual .equals(expectedText)) {
            System.out.println("The required option is selected ✓");
        } else {
            System.out.println("Text does not match ✗");
            System.out.println("Expected : " + expectedText);
            System.out.println("Actual   : " + Actual);
        }

    }
}

