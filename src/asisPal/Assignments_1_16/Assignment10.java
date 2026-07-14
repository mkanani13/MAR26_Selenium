package asisPal.Assignments_1_16;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assignment10 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        System.out.println("STEP1 - Maximize the window");
        driver.manage().window().maximize();

        System.out.println("STEP2 - Navigation to automationbykrishna");
        driver.get("http://automationbykrishna.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("STEP3 - Click on basic element");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        Thread.sleep(1000);

        System.out.println("STEP4 -select 3 from dropdown ");
        WebElement elementfromdropdown = driver.findElement(By.xpath("//select[@class='form-control m-bot15']/option[3]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", elementfromdropdown);
        elementfromdropdown.click();

        System.out.println("STEP5 -Verify the selected dropdown.");
        if (elementfromdropdown.isSelected()) {
            System.out.println("elementfromdropdown is selected");
        } else {
            System.out.println("elementfromdropdown is not selected");
        }
        System.out.println("STEP6 -close all the tab ");
        driver.quit();


    }
}
