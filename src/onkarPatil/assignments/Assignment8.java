package onkarPatil.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("basicelements")).click();
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//label[@for='inputSuccess'])[1]")));

        WebElement radioButton = driver.findElement(By.id("optionsRadios2"));

        radioButton.click();

        if(radioButton.isSelected()){
            System.out.println("Pass!!!");
        }else{
            System.out.println("Fail...");
        }

        driver.quit();
    }
}
