package supriyaKanase.automationScript;

import supriyaKanase.Base.BrowserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment10 {
    @Test
    public void dropDownDemo() {
        WebDriver driver = BrowserAction.start("http://automationbykrishna.com/");

        System.out.println("Redirected to Basic Elements tab");
        driver.findElement(By.id("basicelements")).click();

        WebElement selects = driver.findElement(By.xpath("//form[@class = 'form-horizontal adminex-form']/div[3]/label[@for='inputSuccess']"));
        System.out.println("Scroll page till Select dropdown");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",selects);

        WebElement ddElement  = driver.findElement(By.xpath("//form[@class = 'form-horizontal adminex-form']/div[3]/div/select[1]"));
        WebElement optionSelectedFromDD = driver.findElement(By.xpath("//form[@class = 'form-horizontal adminex-form']/div[3]/div/select[1]/option[3]"));
        //dropDown.click();
        System.out.println("Select from dropdown menu");
        Select oselect = new Select(ddElement);
        oselect.selectByVisibleText("3");
        
       Assert.assertTrue(optionSelectedFromDD.isSelected());
    }
}
