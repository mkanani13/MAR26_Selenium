package supriyaKanase.automationScript;

import supriyaKanase.Base.BrowserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment9 {
    @Test
    public  void inlineCheckBox() {
        WebDriver driver = BrowserAction.start("http://automationbykrishna.com/");

        System.out.println("Redirected to Basic Elements tab");
        driver.findElement(By.id("basicelements")).click();

        System.out.println("Scroll page till inline checkboxes");
        WebElement inlineCheckBoxes = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']/div[2]/label[@for= 'inputSuccess']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",inlineCheckBoxes);

        driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']/div[2]/div[1]/label[1]")).click();
        WebElement checkBox = driver.findElement(By.id("inlineCheckbox1"));
        System.out.println("Check element is Selected or not");
        boolean checkBoxSelected = checkBox.isSelected();

        Assert.assertTrue(checkBoxSelected);
        driver.quit();
    }
}
