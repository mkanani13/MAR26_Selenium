package vishwajeetLoni;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch {


    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();  // open browser
        driver.manage().window().maximize();

        driver.get("http://34.173.201.53/#/signup"); // open website
        driver.findElement(By.xpath("//input[@id='access-student-id']")).sendKeys("2MD9HKUGWE");
        driver.findElement(By.xpath("//input[@id='access-code']")).sendKeys("NG2EHUY2");
        driver.findElement(By.xpath("//button[@data-testid ='access-submit-btn' ]")).click();


    }
}
