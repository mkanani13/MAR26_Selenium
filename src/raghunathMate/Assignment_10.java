package raghunathMate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Assignment_10 {
     public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        WebElement checkBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[7]"));
        //JavascriptExecutor js = (JavascriptExecutor) driver;
       // js.executeScript("arguments[0].scrollIntoView(true)", checkBox);
        WebElement checkbox_1 = driver.findElement(By.xpath("//input[@id ='inlineCheckbox1']"));
        Thread.sleep(2000);
        WebElement listDropDown = driver.findElement(By.xpath("//select[@class='form-control m-bot15']"));
        Select s = new Select(listDropDown);
        int num = s.getOptions().size();
        List<WebElement> list =s.getOptions();
        for(WebElement e:list) {
            System.out.println(e.getText());
        }
        s.selectByIndex(num-1);
        Thread.sleep(2000);
        driver.quit();
    }
}
