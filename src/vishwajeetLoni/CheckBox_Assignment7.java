package vishwajeetLoni;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox_Assignment7 {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Step 1 - Launch browser");
        WebDriver driver = new ChromeDriver();  // open browser
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/"); // open website
        driver.findElement(By.id("basicelements")).click(); // click on Basic elements tab

        Thread.sleep(1000);

        System.out.println("Step 2 - Scroll till the Checkboxes");
        WebElement checkbox = driver.findElement(By.xpath("//div[@class='col-lg-10']/div[@class='checkbox'][2]/label/input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", checkbox);

        System.out.println("Step 3 - Tick the checkbox");
        checkbox.click();
        System.out.println("Checkbox click");

        System.out.println("Step 4 - Verify if checkbox is selected or not");
        if (checkbox.isSelected()){
            System.out.println("Check box is selected");
        }else {
            System.out.println("Checkbox is not selected");
        }

    }

}
