package smratiGarg.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Asgn10_select {
    @Test

    public void main() throws InterruptedException {
        WebDriver driver = new ChromeDriver(); //launching chrome

        System.out.println("step -navigate to automationbykrishna");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationbykrishna.com");
        System.out.println("STEP click basic elements");
        driver.findElement(By.id("basicelements")).click();

         Thread.sleep(2000);
        WebElement dropdownelement = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']/div[3]/div/select[1]"));
        System.out.println("scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",dropdownelement);
        //Thread.sleep(3000);

        Select number = new Select(dropdownelement);
        number.selectByIndex(2);
        List<WebElement> dropDownOptions = number.getOptions();
        int selectedOption = 0;
        System.out.println("Printing drop Down options");
        for (WebElement we : dropDownOptions){
//            System.out.println(we.getText());
            if (we.isSelected()) {
                selectedOption =  Integer.parseInt(we.getText());
            }
        }



        System.out.println("select number by index");
        Assert.assertEquals(selectedOption,3);

        /*   List<WebElement> listOfOptions = number.getOptions();
       System.out.println("total options - " + listOfOptions.size());
       for (WebElement e : listOfOptions){
           System.out.println(e.getText());
       } */
       // driver.quit();
    }
}