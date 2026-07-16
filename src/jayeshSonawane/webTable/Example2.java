package jayeshSonawane.webTable;

import jayeshSonawane.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Example2 {

    public static void main(String[] args) {
        WebDriver driver = BrowserActions.start();

        System.out.println("STEP - Navigate to Demo Tables");
        WebElement elementDemoTables = driver.findElement(By.linkText("Demo Tables"));
        elementDemoTables.click();

        // Find number of Tables
        List<WebElement> elTableCount = driver.findElements(By.xpath("//table"));
        System.out.println("Number of Tables : " + elTableCount.size());

        BrowserActions.close();

    }
}
