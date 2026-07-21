package smratiGarg.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
@Test
public class Asgn15_DemoTable {

    public void main() throws InterruptedException {

        WebDriver driver = new ChromeDriver(); //launching chrome

        System.out.println("step -navigate to automationbykrishna");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationbykrishna.com");

        System.out.println("STEP click Demo table");
        driver.findElement(By.linkText("Demo Tables")).click();
        String userName="";
        String firstName = "Krishna";


        int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        System.out.println("Total rows = "+totalRows);
        for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
            String fName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[2]")).getText();
            if (fName.equals(firstName)){
                userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[4]")).getText();
            }
        }

        //   return driver.findElement(By.xpath("//td[text()='"+firstName+"']/following-sibling::td[2]")).getText();

        System.out.println("User name = "+userName);
    }

}