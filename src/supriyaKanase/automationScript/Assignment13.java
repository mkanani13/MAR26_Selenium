package supriyaKanase.automationScript;

import supriyaKanase.Base.BrowserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Assignment13 {
    @Test
    public  void selectDeselectDemo() {
        WebDriver driver = BrowserAction.start("http://automationbykrishna.com/");

        System.out.println("Redirected to Basic Elements");
        driver.findElement(new By.ByLinkText("Basic Elements")).click();

        System.out.println("Scroll the page till select");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement selectElement = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']/div[3]/label[@for='inputSuccess']"));
        js.executeScript("arguments[0].scrollIntoView(true);", selectElement);

        WebElement optionElements = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']/div[3]/div[1]/select[2]"));
        Select numSelect = new Select(optionElements);

        List<WebElement> listOfOPtions = numSelect.getOptions();
        numSelect.selectByVisibleText("5");
        numSelect.selectByIndex(listOfOPtions.size()-3);

        List<WebElement> allSelectedOptions = numSelect.getAllSelectedOptions();
        System.out.println("Size of all selected options: " +allSelectedOptions.size());
        for (WebElement e:allSelectedOptions){
            System.out.println(e.getText());
        }
        numSelect.deselectByVisibleText("5");
        allSelectedOptions = numSelect.getAllSelectedOptions();
        System.out.println("size of all selected options: "+ allSelectedOptions.size());
        for (WebElement e:allSelectedOptions){
            System.out.println(e.getText());
        }
        numSelect.deselectByVisibleText("3");
        allSelectedOptions = numSelect.getAllSelectedOptions();
        System.out.println("size of all selected options: "+ allSelectedOptions.size());
    }
}