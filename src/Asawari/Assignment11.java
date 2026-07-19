<<<<<<< HEAD
package SeleniumAssignment;
=======
package Asawari;
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Assignment11 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement numberSelectElement = driver.findElement(By.xpath("//form[@class=\"form-horizontal adminex-form\"]/div[3]/div/select[2]"));
        Select numberSelect = new Select(numberSelectElement);

       List<WebElement> listOfOptions = numberSelect.getOptions();
       numberSelect.selectByIndex(listOfOptions.size()-1);
       numberSelect.selectByVisibleText("2");

        WebElement selectOptionElement = numberSelect.getFirstSelectedOption();
        System.out.println("First Select Option is " + selectOptionElement.getText());
        System.out.println(numberSelect.isMultiple());

        List<WebElement> listOfAllSelectedOptions = numberSelect.getAllSelectedOptions();
        System.out.println("All select option sixe " + listOfAllSelectedOptions.size());
        for(WebElement e : listOfAllSelectedOptions){
            System.out.println(e.getText());


        }
    }
}
