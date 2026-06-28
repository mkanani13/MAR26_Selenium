package sasmitaSahu.assignment1_16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment15 {

    @Test
    public void verifyuserName() {

        WebDriver driver = new ChromeDriver();

        System.out.println("STEP1 - Maximize the window");
        driver.manage().window().maximize();

        System.out.println("STEP2 - Navigation to automationbykrishna");
        driver.get("http://automationbykrishna.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("STEP3 - Click on demo table");
        driver.findElement(By.xpath("//a[@id='demotable']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Step-Retrive the username ");
        String firstNmae = "Priya";
        for (int rowIndex = 1; rowIndex <= 5; rowIndex++) {
            String fname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[2]")).getText();
            if (fname.equals(firstNmae)) {
                String username = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[4]")).getText();
                System.out.println(username);
            }
        }
    }
}
