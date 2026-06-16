package raghunathMate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assignment_8 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        WebElement checkBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[7]"));
        WebElement redioButt_1 = driver.findElement(By.xpath("//input[@id='optionsRadios1']"));
        WebElement redioButt_2 = driver.findElement(By.xpath("//input[@id='optionsRadios2']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", checkBox);
        redioButt_2.click();
        redioButt_1.click();
        if (redioButt_1.isSelected()) {
            if (!redioButt_2.isSelected()) {
                System.out.println("Pass - redio button one is clicked and redio button 2 is not clicked");
            } else {
                System.out.println("Fial - redio button one is clicked and redio button 2 is also clicked");
            }
        } else if (redioButt_2.isSelected()) {
            System.out.println("Pass - redio button one is not clicked and redio button 2 is clicked");
        }
        driver.quit();
    }

}
