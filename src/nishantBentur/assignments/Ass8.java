package nishantBentur.assignments;

import nishantBentur.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ass8 {
    WebDriver driver;

    @Test
    void radioButton(){
        driver = BrowserActions.start();

        System.out.println("Navigate to Basic Elements tab");
        WebElement basicElementTab = driver.findElement(By.linkText("Basic Elements"));
        basicElementTab.click();

        System.out.println("Scroll down until Checkboxes and radios");
        WebElement inLinecheckbox = driver.findElement(By.id("inlineCheckbox1"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",inLinecheckbox);

        System.out.println("Select the radio button 'Option two can be something else and selecting it will deselect option one' ");
        WebElement radioButton2 = driver.findElement(By.xpath("//input[@id='optionsRadios2']"));
        radioButton2.click();

        Assert.assertTrue(radioButton2.isSelected(),"Radio button2 is not selected");
        System.out.println("Radio button2 is selected");

        driver.quit();
    }
}
