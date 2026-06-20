
package sasmitaSahu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://34.173.201.53/access#/access");
        driver.findElement(By.xpath("//input[@id='access-student-id']")).sendKeys("VBXHV2JWBG");
        driver.findElement(By.xpath("//input[@id='access-code']")).sendKeys("BAAP3KXT");
        driver.findElement(By.xpath("//button[@data-testid='access-submit-btn']")).click();
    }
}
