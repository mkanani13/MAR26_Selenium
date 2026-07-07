package vishwajeetLoni;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CheckBoxInline_Assignment9 {

    public static void main(String[] args) {
        System.out.println("Step 1 - Launch Browser");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("basicelements")).click();



        System.out.println("Step - Scroll to inline chekbox");
        WebElement incheckbox = driver.findElement(By.xpath("//label[@class='checkbox-inline']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", incheckbox);

        System.out.println("Step 3 - Click on inline checkbox no 1");

        WebElement checkbox = driver.findElement(By.xpath("//input[@id='inlineCheckbox1']"));
        checkbox.click();
        System.out.println("Checkbox selected");

        System.out.println("Step 4 - Verify if checkbox 1 is selected");
        if (checkbox.isSelected()){
            System.out.println("Checkbox 1 selected");
        }else{
            System.out.println("Checkbox 1 not selected");
        }
    }
}
