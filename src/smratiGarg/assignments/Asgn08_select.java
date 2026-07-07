package smratiGarg.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Asgn08_select {
@Test
    public void main() throws InterruptedException {
        WebDriver driver = new ChromeDriver(); //launching chrome

        System.out.println("step -navigate to automationbykrishna");
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com");

        System.out.println("STEP click basic elements");
        driver.findElement(By.id("basicelements")).click();

        Thread.sleep(2000);
        WebElement radiobutton = driver.findElement(By.xpath("//input[@id='optionsRadios2']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",radiobutton);
        Thread.sleep(3000);

        if (!radiobutton.isSelected())
            radiobutton.click();
        System.out.println("clicking the radio button");
        Assert.assertTrue(radiobutton.isSelected());

    }

}
