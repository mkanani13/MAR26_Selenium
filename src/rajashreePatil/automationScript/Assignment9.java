/*
Selenium Assignment - 9: 12th June'2026
        Automate the following scenario using Selenium WebDriver in Java:

        Open the application: http://automationbykrishna.com/
        Click on the “Basic Elements” tab/button.

        Scroll down the page and in the "Inline checkboxes" section perform the following activities:-

        Select the checkbox with number '1'

        Use the isSelected() method to confirm whether the intended checkbox is currently selected or not.

        Hint:- isSelected() method is used to check whether a selectable element is currently selected or not.
        isSelected() method returns a boolean value.
        if true, then selectable elemment is currently selected else not selected.*/

package rajashreePatil.automationScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment9 {

    public void verifyDropdownSelection() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        System.out.println("STEP: Enter the URL for Automation by krishna");
        driver.get("http://automationbykrishna.com/");

        driver.manage().window().maximize();

        System.out.println("STEP: Click on Basic Elements");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("STEP: Navigate to first inline checkbox");

        WebElement ddElement = driver.findElement(By.xpath("(//input[@type='checkbox'])[8]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",ddElement);
        System.out.println("Selecting the checkbox");
        ddElement.click();
        //Thread.sleep(4000);
        Assert.assertTrue(ddElement.isSelected(),"first inline checkbox is not selected");
        driver.quit();
    }
    @Test
    public void verifyDd() throws InterruptedException {
        Assignment9 assignment9 = new Assignment9();
        assignment9.verifyDropdownSelection();
    }
}
