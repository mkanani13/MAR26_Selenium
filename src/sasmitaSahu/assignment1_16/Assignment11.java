package sasmitaSahu.assignment1_16;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Assignment11 {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();

        System.out.println("STEP1 - Maximize the window");
        driver.manage().window().maximize();

        System.out.println("STEP2 - Navigation to automationbykrishna");
        driver.get("http://automationbykrishna.com/");

        System.out.println("STEP3 - Click on basic element");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("STEP4 - Findout the multiselect dropdown");
        WebElement multiSelect = driver.findElement(By.xpath("//select[@class='form-control']"));

        System.out.println("STEP5 -scroll upto multiSelect dropdown");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", multiSelect);

        System.out.println("STEP6 -create select object");
        Select select = new Select(multiSelect);

        System.out.println("STEP7- select option 2 & 5 from dropdown");
        select.selectByVisibleText("2");
        select.selectByVisibleText("5");

        System.out.println("STEP8- get all the selected option");
        List<WebElement> selectedOptions = select.getAllSelectedOptions();

        System.out.println("STEP9- print selected options");
        System.out.println("Selected options are ");

        for (WebElement e : selectedOptions) {
            System.out.println(e.getText());
        }
    }
}
