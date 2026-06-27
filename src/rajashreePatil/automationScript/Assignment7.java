package rajashreePatil.automationScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment7 {

    public void verifyDropdownSelection() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        System.out.println("STEP: Enter the URL for Automation by krishna");
        driver.get("http://automationbykrishna.com/");

        driver.manage().window().maximize();

        System.out.println("STEP: Click on Basic Elements");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("STEP: Navigate to checkbox");

        WebElement ddElement = driver.findElement(By.xpath("(//div[@class='checkbox']//input[@type='checkbox'])[7]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",ddElement);
        System.out.println("Selecting the checkbox");

        ddElement.click();
        Assert.assertTrue(ddElement.isSelected(),"Checkbox is not selected after clicking");
        /*if(ddElement.isSelected())
            System.out.println("True, Checkbox is selected");
        else
            System.out.println("False, Checkbox is not selected");*/

        driver.quit();
    }
    @Test
    public void verifyCheckboxText() throws InterruptedException {
        Assignment7 assignment7 = new Assignment7();
        assignment7.verifyDropdownSelection();
    }
}
