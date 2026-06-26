package rajashreePatil.automationScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment8 {

    public void verifyDropdownSelection() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        System.out.println("STEP: Enter the URL for Automation by krishna");
        driver.get("http://automationbykrishna.com/");

        driver.manage().window().maximize();

        System.out.println("STEP: Click on Basic Elements");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("STEP: Navigate to second radio button");

        WebElement ddElement = driver.findElement(By.xpath("//input[@id='optionsRadios2']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",ddElement);
        System.out.println("Selecting the checkbox");
        //Thread.sleep(3000);
        
        ddElement.click();
        Assert.assertTrue(ddElement.isSelected(),"Radiobutton is not selected");
        driver.quit();
    }
    @Test
    public void verifyDd() throws InterruptedException {
        Assignment8 assignment8 = new Assignment8();
        assignment8.verifyDropdownSelection();
    }
}
