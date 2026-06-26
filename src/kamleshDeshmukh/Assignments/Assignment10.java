package kamleshDeshmukh.Assignments;

import kamleshDeshmukh.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Assignment10 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserActions.start();
    }

    @Test
    public  void verifyDropDown() {

        System.out.println("STEP- Click on Basic Elements tab");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();

        System.out.println("STEP- Scroll down to the Selects section");
        WebElement selectsSection = driver.findElement(By.xpath("//label[text()='Selects']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", selectsSection);

        System.out.println("STEP- Click on the dropdown and select 3 from the list.");
        WebElement dropdown = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']//select[1]"));
        Select s = new Select(dropdown);
        //s.selectByIndex(2);
        s.selectByVisibleText("3");

        //How to select last option from dropdown
        //int size= s.getOptions().size();
        //s.selectByIndex(size-1);

        //How to read all options from dropdown
//        List<WebElement> allOptions = s.getOptions();
//        for(WebElement e : allOptions){
//            System.out.println(e.getText());
//        }

        System.out.println("STEP- Check if option 3 is selected or not.");
        WebElement option3 = driver.findElement(By.xpath("//select[@class='form-control m-bot15']/option[3]"));

        System.out.println("Selected option text : " + s.getFirstSelectedOption().getText());
        System.out.println("Option 3 is selected in dropdown : " + option3.isSelected());
        Assert.assertTrue(option3.isSelected());
    }
    @AfterMethod
    public void tearDown() {
        System.out.println("STEP- Close the browser.");
        if (driver != null) {
            driver.quit();
        }
    }

}
