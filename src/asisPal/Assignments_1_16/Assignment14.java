package asisPal.Assignments_1_16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment14 {
    @Test
    public void printData() {

        WebDriver driver = new ChromeDriver();

        System.out.println("STEP1 - Maximize the window");
        driver.manage().window().maximize();

        System.out.println("STEP2 - Navigation to automationbykrishna");
        driver.get("http://automationbykrishna.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("STEP3 - Click on demo table");
        driver.findElement(By.xpath("//a[@id='demotable']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        /*System.out.println("STEP4 -identify all the row and column data from the table");
        for (int rowIndex = 1; rowIndex <= 5; rowIndex++) {
            for (int colIndex = 1; colIndex <= 4; colIndex++) {
                String data = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td["+colIndex+"]")).getText();
                System.out.print(data+ " ");
            }
            System.out.println();
        }*/
        System.out.println("Step-5 Alertnative method for print data");
        System.out.print(driver.findElement(By.xpath("//table[@id='table1']")).getText());


    }
}
