package automationScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assignment15 {
    WebDriver driver;
    void startup() {
        driver = new ChromeDriver();
        System.out.println("Step - launch browser and hit URL");
        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Click on Demo Table");
        driver.findElement(By.linkText("Demo Tables")).click();
    }

    String getUsername(String firstName) {
        int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
           String fname  = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td[2]")).getText();
           if(fname.equals(firstName)){
               return driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td[4]")).getText();
           }
        }
        return null;
    }

    public static void main(String[] args) {
        Assignment15 assign15 = new Assignment15();
        assign15.startup();
        String username = assign15.getUsername("Priya");
        System.out.println(username);

    }
}





