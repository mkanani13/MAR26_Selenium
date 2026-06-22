//Automate the following scenario using Selenium WebDriver in Java:
//Open the application: http://automationbykrishna.com/
//Click on the “Basic Elements” tab/button.
//Scroll down the page and in the "Selects" section dropdown perform the following activities:-
//Select the option with number '3' from the dropdown
//Use the isSelected() method to confirm whether the intended dropdown option is currently selected or not
//Hint:- isSelected() method is used to check whether a selectable element is currently selected or not.
//isSelected() method returns a boolean value.
//if true, then selectable elemment is currently selected else not selected.
package rutujaWaje;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment10 {

        public  void selectoption3() throws InterruptedException {
            System.out.println("Launch Browser");
            WebDriver driver = new ChromeDriver();
            driver.get("http://automationbykrishna.com/");
            driver.manage().window().maximize();

            System.out.println("Click on Basic Element tab");
            WebElement basicelement=driver.findElement(By.xpath("//*[@id='basicelements']"));
            basicelement.click();
            Thread.sleep(2000);

            System.out.println("Select with the number 3 ");
            WebElement numberSelection = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']/div[3]/div/select[1]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", numberSelection);
            Thread.sleep(3000);
            Select numselect = new Select(numberSelection);
            numselect.selectByIndex(2);
            WebElement option3 = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']/div[3]/div/select[1]/option[3]"));
            Assert.assertTrue(option3.isSelected(),"option3 is NOT selected");
            driver.quit();
        }
    }



