package jayeshSonawane.singleSelectDropdownList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Example2 {

    public static void main(String[] args) {

        System.out.println("STEP - Launch Browser");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("STEP - Navigate to Basic Elements");
        WebElement elementBtnBasicElements = driver.findElement(By.xpath("//a[@id='basicelements']"));
        elementBtnBasicElements.click();

        System.out.println("STEP - Navigate to Single Select Dropdown");
        WebElement elementSingleSelectDropdown = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']/div[3]/div/select[1]"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",elementSingleSelectDropdown);

        // Perform DD operations
        Select optionSelect = new Select(elementSingleSelectDropdown);

        List<WebElement> options = optionSelect.getOptions();
        System.out.println("Number of options in DD list : " + options.size());

        // Confirm Single Select or Multi Select
        if(!optionSelect.isMultiple()){
            System.out.println("It is a Single Select Dropdown List");
        }

        // Print DD element values
        System.out.println("Below are the options in the DD list");
        for (WebElement e : options){
            System.out.println(e.getText());
        }

        // Select the option
        optionSelect.selectByVisibleText("3");
        System.out.println("Selected option is " + optionSelect.getFirstSelectedOption().getText());

        driver.quit();
    }
}
