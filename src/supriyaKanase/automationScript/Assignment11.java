package supriyaKanase.automationScript;

import supriyaKanase.Base.BrowserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Assignment11 {
    @Test
    public void selectOptionsDemo() {
        WebDriver driver = BrowserAction.start("http://automationbykrishna.com/");

        System.out.println("Redirect to Basic Elements tab");
        driver.findElement(new By.ByLinkText("Basic Elements")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement selectElement =   driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']/div[3]/label[@for='inputSuccess']"));
        js.executeScript("arguments[0].scrollIntoView(true);",selectElement);

        WebElement numberSelectElement = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']/div[3]/div[1]/select[2]"));
        Select numSelect = new Select(numberSelectElement);

        List<WebElement> listOfOptions = numSelect.getOptions();
        numSelect.selectByIndex(listOfOptions.size()-1);
        numSelect.selectByVisibleText("2");

        System.out.println(numSelect.isMultiple());
        WebElement firstSelectedOptionElement = numSelect.getFirstSelectedOption();
        System.out.println("First selected option is " + firstSelectedOptionElement .getText() );

        List<WebElement> allSelectedOptions = numSelect.getAllSelectedOptions();
        System.out.println("All selected Option Size : " + allSelectedOptions.size());
        for(WebElement e :allSelectedOptions){
            System.out.println(e.getText());
        }
    }
}
