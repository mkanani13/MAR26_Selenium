package jayeshSonawane.multiSelectDropdownList;

import jayeshSonawane.base.BrowserActions;
import jayeshSonawane.base.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Example1 {

    public static void main(String[] args) {

        WebDriver driver = BrowserActions.start();

        System.out.println("Navigate to Basic Elements");
        WebElement elementBtnBasicElements = driver.findElement(By.xpath("//a[@id='basicelements']"));
        elementBtnBasicElements.click();

        System.out.println("Navigate to Multi Select Dropdown");
        WebElement elementMltSelectDD = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']/div[3]/div/select[2]"));

        ElementActions.scrollTo(driver, elementMltSelectDD);

        /*
        1. Go to drop down
        2. Select options
        3. Display selected option/'s
        4. Show options
         */

        Select dropdown = new Select(elementMltSelectDD);

        if(dropdown.isMultiple()){
            System.out.println("It is multi select dropdown");
        }

        dropdown.selectByIndex(4);
        dropdown.selectByIndex(2);

        List<WebElement> selectedOptions = dropdown.getAllSelectedOptions();

        for(WebElement e : selectedOptions){
            System.out.println(e.getText());
        }

        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.deselectByIndex(4);

        selectedOptions = dropdown.getAllSelectedOptions();

        for(WebElement e : selectedOptions){
            System.out.println(e.getText());
        }

        System.out.println("List of Elements in Drop Down");
        List<WebElement> ddListElements = dropdown.getOptions();

        for(WebElement e : ddListElements){
            System.out.println(e.getText());
        }

        BrowserActions.close();

    }
}
