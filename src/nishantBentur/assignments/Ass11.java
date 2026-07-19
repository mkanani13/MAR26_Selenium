package nishantBentur.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import nishantBentur.base.BrowserActions;
import java.util.List;

public class Ass11 {
    WebDriver driver;

    @Test
    public void multiSelectDropDown(){
        driver = BrowserActions.start();

        System.out.println("Navigate to Basic Elements tab");
        driver.findElement(By.linkText("Basic Elements")).click();

        System.out.println("Scroll down until multiselect drop down");
        WebElement multiSelectddElement = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']//select[2]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)", multiSelectddElement);

        System.out.println("Choose '2' & '5' from the drop down list");
        Select numberSelect = new Select(multiSelectddElement);
        numberSelect.selectByVisibleText("2");
        numberSelect.selectByIndex(4);

        System.out.println("Retrieve the selected values");
        List<WebElement> selectedOptions = numberSelect.getAllSelectedOptions();
        for(WebElement e : selectedOptions)
            System.out.println(e.getText());

        driver.quit();
    }
}
