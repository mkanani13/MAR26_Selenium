package onkarPatil.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Assignment13 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("basicelements")).click();
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//label[@for='inputSuccess'])[3]")));

        WebElement dropdown = driver.findElement(By.xpath("(//select[contains(@class,'form-control')])[2]"));

        Select s = new Select(dropdown);
        s.selectByVisibleText("2");
        s.selectByVisibleText("5");

        List<WebElement> al1 = s.getAllSelectedOptions();
        for(WebElement e : al1){
            System.out.println(e.getText());
        }

        s.deselectByIndex(4);

        List<WebElement> al2 = s.getAllSelectedOptions();
        for(WebElement e : al2){
            System.out.println(e.getText());
        }

        s.deselectByIndex(1);

        List<WebElement> al3 = s.getAllSelectedOptions();
        for(WebElement e : al3){
            System.out.println(e.getText());
        }

        driver.quit();
    }
}
