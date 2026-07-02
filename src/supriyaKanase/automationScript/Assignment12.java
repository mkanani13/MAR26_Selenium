package supriyaKanase.automationScript;

import supriyaKanase.Base.BrowserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Assignment12 {
    @Test
    public  void multipleSelect() {
        WebDriver driver = BrowserAction.start("http://automationbykrishna.com/.");

        System.out.println("Redirected to Basic Elements");
        driver.findElement(new By.ByLinkText("Basic Elements")).click();

        System.out.println("Scroll the page till select");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement selectElement =   driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']/div[3]/label[@for='inputSuccess']"));
        js.executeScript("arguments[0].scrollIntoView(true);",selectElement);

        WebElement optionElements = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']/div[3]/div[1]/select[2]"));
        Select optionSelect = new Select(optionElements);

        List<WebElement> listOfOptions = optionSelect.getOptions();
        optionSelect.selectByIndex(listOfOptions.size()-1);
        optionSelect.selectByIndex(listOfOptions.size()-3);

        List<WebElement> allSelectedOptions = optionSelect.getAllSelectedOptions();
        System.out.println("All selected option size : " + allSelectedOptions.size());
        for(WebElement e:allSelectedOptions){
            System.out.println(e.getText());
        }
        optionSelect.deselectByVisibleText("5");
        allSelectedOptions = optionSelect.getAllSelectedOptions();
        System.out.println("All selected option Size " + allSelectedOptions.size());
        for(WebElement e : allSelectedOptions){
            System.out.println(e.getText());
        }
    }
}
