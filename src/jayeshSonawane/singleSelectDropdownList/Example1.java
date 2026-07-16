package jayeshSonawane.singleSelectDropdownList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Example1 {

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

        System.out.println("Select Options From Dropdown");
        Select optionSelect = new Select(elementSingleSelectDropdown);
        optionSelect.selectByVisibleText("2");

        System.out.println("Selected option : " + optionSelect.getFirstSelectedOption().getText());
    }
}
