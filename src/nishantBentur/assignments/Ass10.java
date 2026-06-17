package nishantBentur.assignments;

import nishantBentur.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Ass10 {
    WebDriver driver;

    @Test
    void singleDropDown(){
        driver = BrowserActions.start();

        System.out.println("Navigate to Basic Elements tab");
        WebElement basicElementTab = driver.findElement(By.linkText("Basic Elements"));
        basicElementTab.click();

        System.out.println("Scroll down until Checkboxes and radios");
        WebElement inLinecheckbox = driver.findElement(By.id("inlineCheckbox1"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",inLinecheckbox);

        System.out.println("Select from the single drop down element");
        WebElement dropDownElement = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']//div[3]//div//select[1]"));
        Select numberSelect = new Select(dropDownElement);
        List<WebElement> listOfOptions = numberSelect.getOptions();
        numberSelect.selectByVisibleText("4");

		for(WebElement e : listOfOptions) {
			if(e.isSelected())
				System.out.println("Select option text is :::: " + e.getText());
		}
        driver.quit();
    }
}