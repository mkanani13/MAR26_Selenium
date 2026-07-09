package asisPal.Assignments_1_16;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assignment8 {
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

        System.out.println("STEP4 -select 2nd checkbox ");
        WebElement radiobutton = driver.findElement(By.xpath("//input[@id='optionsRadios2']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", radiobutton);
        radiobutton.click();

        System.out.println("STEP5 -Verify radiobutton is selected ");
        if (radiobutton.isSelected()) {
            System.out.println("radiobutton is selected");
        } else {
            System.out.println("radiobutton is not selected");
        }

        System.out.println("STEP6 -close all the tab ");
        driver.quit();


    }
}
