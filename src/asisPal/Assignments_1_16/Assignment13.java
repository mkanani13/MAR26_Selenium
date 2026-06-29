package asisPal.Assignments_1_16;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Assignment13 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        System.out.println("STEP1 - Maximize the window");
        driver.manage().window().maximize();

        System.out.println("STEP2 - Navigation to automationbykrishna");
        driver.get("http://automationbykrishna.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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

        System.out.println("STEP7- select option 2 &5 from dropdown");
        select.selectByVisibleText("2");
        select.selectByVisibleText("5");

        System.out.println("STEP8- get all the selected option");
        List<WebElement> listofoptions = select.getAllSelectedOptions();

        System.out.println("STEP9- print selected options");
        System.out.println("Selected options are ");

        for (WebElement e : listofoptions) {
            System.out.println(e.getText());
        }
        System.out.println("STEP10- Deselect option 5 ");
        select.deselectByVisibleText("5");

        System.out.println("STEP11- selected options after deselecting 5 from dropdown ");
        List<WebElement> optionsleft = select.getAllSelectedOptions();

        System.out.println("STEP12- leftover options");
        System.out.println("leftover options  are ");

        for (WebElement leftoption : optionsleft) {
            System.out.println(leftoption.getText());
        }

        System.out.println("STEP10- Deselect option 2 ");
        select.deselectByVisibleText("2");

        System.out.println("STEP11- selected options after deselecting 2 from dropdown ");
        List<WebElement> nonleft = select.getAllSelectedOptions();

        System.out.println("STEP12- leftover options");
        System.out.println("leftover options  are ");

        for (WebElement noelement : nonleft) {
            System.out.println(noelement.getText());
        }
    }
}
