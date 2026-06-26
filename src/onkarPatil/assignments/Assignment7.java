package onkarPatil.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("basicelements")).click();
        Thread.sleep(1000);
        WebElement checkBoxElement = driver.findElement(By.xpath("(//label[@for='inputSuccess'])[1]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", checkBoxElement);

        driver.findElement(By.xpath("//div[@class='checkbox']/label[contains(., 'option one')]")).click();
        WebElement newCheckbox = driver.findElement(By.xpath("(//div[@class='checkbox']/label[contains(., 'option one')]//preceding::input[1]//following::input[1])[1]"));
        if(newCheckbox.isSelected()){
            System.out.println("Pass!!!");
        }else{
            System.out.println("Fail");
        }

        driver.quit();
    }
}
