package priyankaGhule.automationScript;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4_2 {
    public static void main(String[] arg)throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/");
        Thread.sleep(1000);
        driver.findElement(By.id("basicelements")).click();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,1000)");

        driver.findElement(By.id("javascriptPromp")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Priyanka");
        alert.accept();
        driver.quit();



    }
}
