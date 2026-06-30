package vishwajeetLoni;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton_Assignment_8 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Step 1 - Launch browser");
        WebDriver driver = new ChromeDriver();  // open browser
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/"); // open website
        driver.findElement(By.id("basicelements")).click(); // click on Basic elements tab

        Thread.sleep(1000);

        System.out.println("Step 2 - Scroll till the Radiobtns");
        WebElement radiobtn = driver.findElement(By.xpath("//input[@id='optionsRadios2']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", radiobtn);

        System.out.println("Step 3 - Click the radiobtn");
        radiobtn.click();
        System.out.println("Radiobtn clicked");

        System.out.println("Step 4 - Verify if radiobtn is selected or not");
        if (radiobtn.isSelected()){
            System.out.println("Radiobtn is selected");
        }else {
            System.out.println("Radiobtn is not selected");
        }

    }
}
