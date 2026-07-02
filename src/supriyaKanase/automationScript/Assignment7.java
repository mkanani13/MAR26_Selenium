package supriyaKanase.automationScript;

import supriyaKanase.Base.BrowserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment7 {
    WebDriver driver;
    @Test
    public void checkBoxExample() {
        driver = BrowserAction.start("http://automationbykrishna.com/");

        System.out.println("Click on button Basic Elements");
        driver.findElement(By.id("basicelements")).click();

        System.out.println("Scroll til Checkbox and radio button section");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement checkBoxRadioBtnText = driver.findElement(By.xpath("//form[@class= 'form-horizontal adminex-form']/div[1]/label[@for = 'inputSuccess']"));
        js.executeScript("arguments[0].scrollIntoView(true);",checkBoxRadioBtnText);
        System.out.println("select the 2nd checkbox");
         driver.findElement(By.xpath("//form[@class= 'form-horizontal adminex-form']//div[1]/div[2]/label")).click();

         WebElement checkBox = driver.findElement(By.xpath("//form[@class= 'form-horizontal adminex-form']//div[1]/div[2]/label/input"));

         boolean isChecked = checkBox.isSelected();
        Assert.assertTrue(isChecked);
        driver.quit();
    }
}
