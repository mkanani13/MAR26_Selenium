package onkarPatil.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment10 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("basicelements")).click();
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//label[@for='inputSuccess'])[3]")));

        WebElement dropdown = driver.findElement(By.xpath("(//select[contains(@class,'form-control')])[1]"));

        Select s = new Select(dropdown);
        s.selectByVisibleText("3");

        boolean flag = driver.findElement(By.xpath("(//select[contains(@class,'form-control')])[1]/option[3]")).isSelected();

        if(flag){
            System.out.println("Pass!!!");
        }else{
            System.out.println("Fail...");
        }

        driver.quit();
    }
}
