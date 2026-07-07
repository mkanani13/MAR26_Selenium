package smratiGarg.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Asgn14_DemoTable {
@Test
    public void main() throws InterruptedException {

        WebDriver driver = new ChromeDriver(); //launching chrome

        System.out.println("step -navigate to automationbykrishna");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationbykrishna.com");
        System.out.println("STEP click Demo table");

        driver.findElement(By.linkText("Demo Tables")).click();

        System.out.println("print the table with header");
        System.out.println (driver.findElement(By.xpath("//table[@id='table1']")).getText());
        driver.quit();
    }
}
