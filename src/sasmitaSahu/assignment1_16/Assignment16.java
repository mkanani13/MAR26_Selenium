package sasmitaSahu.assignment1_16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment16 {
    @Test
    public void verifyFname() {

        WebDriver driver = new ChromeDriver();

        System.out.println("STEP1 - Maximize the window");
        driver.manage().window().maximize();

        System.out.println("STEP2 - Navigation to automationbykrishna");
        driver.get("http://automationbykrishna.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("STEP3 - Click on demo table");
        driver.findElement(By.xpath("//a[@id='demotable']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Step4-Retrive the firstname ");
        String username = "asharma";
        for (int rowIndex = 1; rowIndex <= 5; rowIndex++) {
            String firstname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[4]")).getText();
            if (firstname.equals(username)) {

                String fname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[2]")).getText();
                System.out.println(fname);

            }
        }
    }
}
