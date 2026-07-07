package supriyaKanase.automationScript;

import supriyaKanase.Base.BrowserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment8 {
    @Test
    public  void radioButtonExample() {
        WebDriver driver = BrowserAction.start("http://automationbykrishna.com/");

        System.out.println("Click on button Basic Elements");
        driver.findElement(By.id("basicelements")).click();

        System.out.println("Scroll til Checkbox and radio button section");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement checkBoxRadioBtnText = driver.findElement(By.xpath("//form[@class= 'form-horizontal adminex-form']/div[1]/label[@for = 'inputSuccess']"));
        js.executeScript("arguments[0].scrollIntoView(true);",checkBoxRadioBtnText);
        driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']/div[1]/div[1]/div[4]/label")).click();
        WebElement radioButtion = driver.findElement(By.id("optionsRadios2"));

        boolean isChecked = radioButtion.isSelected();
        Assert.assertTrue(isChecked);
        driver.quit();
    }
}
