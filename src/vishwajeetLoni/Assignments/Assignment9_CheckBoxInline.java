package vishwajeetLoni.Assignments;

//Automate the following scenario using Selenium WebDriver in Java:
//
//Open the application: http://automationbykrishna.com/
//Click on the “Basic Elements” tab/button.
//
//Scroll down the page and in the "Inline checkboxes" section perform the following activities:-
//
//Select the checkbox with number '1'
//
//Use the isSelected() method to confirm whether the intended checkbox is currently selected or not.
//
//Hint:- isSelected() method is used to check whether a selectable element is currently selected or not.
//isSelected() method returns a boolean value.
//if true, then selectable elemment is currently selected else not selected.

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import vishwajeetLoni.base.ActionOnBrowser;

import java.time.Duration;

public class Assignment9_CheckBoxInline {

    @Test
    public void inlineCheckbox(){
        WebDriver driver;
        driver = ActionOnBrowser.start();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        System.out.println("Step 1 - Launch Browser and seitch to Basic elements");
        driver.findElement(By.id("basicelements")).click();

        System.out.println("Step - Scroll to inline checkbox");
        WebElement incheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='checkbox-inline']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", incheckbox);


        System.out.println("Step 3 - Click on inline checkbox no 1");

        WebElement checkbox = driver.findElement(By.xpath("//input[@id='inlineCheckbox1']"));
        checkbox.click();
        System.out.println("Checkbox selected");

        System.out.println("Step 4 - Verify if checkbox 1 is selected");
        Assert.assertTrue(checkbox.isSelected());
    }

    public static void main(String[] args) {

        System.out.println("Step 1 - Launch Browser");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("basicelements")).click();



        System.out.println("Step - Scroll to inline chekbox");
        WebElement incheckbox = driver.findElement(By.xpath("//label[@class='checkbox-inline']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", incheckbox);

        System.out.println("Step 3 - Click on inline checkbox no 1");

        WebElement checkbox = driver.findElement(By.xpath("//input[@id='inlineCheckbox1']"));
        checkbox.click();
        System.out.println("Checkbox selected");

        System.out.println("Step 4 - Verify if checkbox 1 is selected");
        if (checkbox.isSelected()){
            System.out.println("Checkbox 1 selected");
        }else{
            System.out.println("Checkbox 1 not selected");
        }
    }
}
