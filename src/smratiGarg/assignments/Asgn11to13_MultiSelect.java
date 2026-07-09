package smratiGarg.assignments;

import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class Asgn11to13_MultiSelect {
    @Test
    public void main() throws InterruptedException {
        WebDriver driver = new ChromeDriver(); //launching chrome

        System.out.println("step -navigate to automationbykrishna");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationbykrishna.com");
        System.out.println("STEP click basic elements");
        driver.findElement(By.id("basicelements")).click();

        WebElement dropdownelement = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']/div[3]/div/select[2]"));
        System.out.println("select dropdown box");
        Select number = new Select(dropdownelement);
        number.selectByIndex(1);
        number.selectByIndex(4);
        // it means our selected elements should be only two and on index 1 and 4
        int expetedSelectedOptionSize = 2;
        System.out.println("select 2 numbers by index method");
        List<WebElement> selectedOption = number.getAllSelectedOptions();
        List<WebElement> allOptions = number.getOptions();

        boolean isSelectedOptionsExpected = true;
        System.out.println("selected option size is : " + selectedOption.size());
        int selectedOptionSize = selectedOption.size();
        System.out.println("VERIFY - number of element selected");
        Assert.assertEquals(selectedOptionSize,expetedSelectedOptionSize);
        for (int index = 0 ; index < allOptions.size(); index ++) {
            if(allOptions.get(index).isSelected()){
                if (!( index == 1 || index == 4 ) ) {
                    isSelectedOptionsExpected = false;

                }
            }

        }
        System.out.println("VERIFY - selected options are as expected ");
        Assert.assertTrue(isSelectedOptionsExpected);

     //   System.out.println("-------------------");

       /* System.out.println("deselect the number");
        //number.deselectByIndex(1);
        number.deselectAll();
        selectedOption = number.getAllSelectedOptions();
        for (WebElement e : selectedOption) {  //if we want to print all elements on console
            System.out.println(e.getText());
            System.out.println("end");
            //driver.quit();*/
        }
    }

