package seleniumAssignments;
/*
Automate the following scenario using Selenium WebDriver in Java:

Open the application: http://automationbykrishna.com/
Click on the “Basic Elements” tab/button.

Scroll down the page and in the "Selects" section dropdown perform the following activities:-

Select the option with number '3' from the dropdown

Use the isSelected() method to confirm whether the intended dropdown option is currently selected or not

Hint:- isSelected() method is used to check whether a selectable element is currently selected or not.
isSelected() method returns a boolean value.
if true, then selectable element is currently selected else not selected.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment10_68 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/");

        driver.findElement(By.xpath("//a[@id='basicelements']")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement elementDropdown3 = driver.findElement(By.xpath("//select[@class='form-control m-bot15']/option[3]"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementDropdown3);

        elementDropdown3.click();

        if(elementDropdown3.isSelected()){
            System.out.println("Currently Selected");
        }else{
            System.out.println("Not Selected");
        }
    }
}
