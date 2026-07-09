package smratiGarg.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Asgn16_DemoClass {
    @Test
    public void main() throws InterruptedException{

        WebDriver driver = new ChromeDriver();

        System.out.println("step -navigate to automationbykrishna and maximise");
        driver.get("http://automationbykrishna.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("click demo table");
        driver.findElement(By.linkText("Demo Tables")).click();
        String userName = "asharma";
        String firstName ="";

        int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        System.out.println("total rows " + totalRows);
        for (int rowIndex =1; rowIndex <=totalRows ;rowIndex++) {
            String uName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[4]")).getText();
            if (uName.equals(userName)){
                firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[2]")).getText();

            }
        }
        System.out.println("User name = "+ firstName );


    }
}
