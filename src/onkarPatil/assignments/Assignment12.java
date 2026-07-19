package onkarPatil.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment12 {

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

        boolean flag1 = driver.findElement(By.xpath("(//select[contains(@class,'form-control')])[2]/option[2]")).isSelected();
        boolean flag2 = driver.findElement(By.xpath("(//select[contains(@class,'form-control')])[2]/option[5]")).isSelected();

        if(flag1 && flag2){
            System.out.println("Pass!!!");
        }else{
            System.out.println("Fail...");
        }

        driver.quit();
    }
}
