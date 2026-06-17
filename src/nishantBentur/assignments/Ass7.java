package nishantBentur.assignments;

import nishantBentur.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ass7 {
    WebDriver driver;

    @Test
    void checkbox(){
        driver = BrowserActions.start();

        System.out.println("Navigate to Basic Elements tab");
        WebElement basicElementTab = driver.findElement(By.linkText("Basic Elements"));
        basicElementTab.click();

        System.out.println("Scroll down until Checkboxes and radios");
        WebElement inLinecheckbox = driver.findElement(By.id("inlineCheckbox1"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",inLinecheckbox);

        System.out.println("Select the checkbox 'Option one is this and that—be sure to include why it's great option one' ");
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']//div[@class='checkbox'][2]//input[@type='checkbox']"));
        checkbox2.click();

        Assert.assertTrue(checkbox2.isSelected(),"Checkbox is not selected");
        System.out.println("Checkbox is selected");

        driver.quit();
    }
}
