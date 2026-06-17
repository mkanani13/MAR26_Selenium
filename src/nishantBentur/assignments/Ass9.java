package nishantBentur.assignments;

import nishantBentur.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ass9 {
    WebDriver driver;

    @Test
    void inLineCheckboxes(){
        driver = BrowserActions.start();

        System.out.println("Navigate to Basic Elements tab");
        WebElement basicElementTab = driver.findElement(By.linkText("Basic Elements"));
        basicElementTab.click();

        System.out.println("Scroll down until Checkboxes and radios");
        WebElement inLinecheckbox = driver.findElement(By.id("inlineCheckbox1"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",inLinecheckbox);

        System.out.println("Select the InLine checkbox #1");
        WebElement inLineCheckbox1 = driver.findElement(By.xpath("//input[@id='inlineCheckbox1']"));
        inLineCheckbox1.click();

        Assert.assertTrue(inLineCheckbox1.isSelected(),"Checkbox 1 from InLine Checkboxes is not selected");
        System.out.println("Checkbox 1 is selected");

        driver.quit();
    }
}
