package asisPal.Assignments_1_16;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assignment9 {
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
        WebElement inlineCheckbox1 = driver.findElement(By.xpath("//input[@id='inlineCheckbox1']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", inlineCheckbox1);
        inlineCheckbox1.click();

        System.out.println("STEP5 -Verify radiobutton is selected ");
        if (inlineCheckbox1.isSelected()) {
            System.out.println("inlineCheckbox1 is selected");
        } else {
            System.out.println("inlineCheckbox1 is not selected");
        }

        System.out.println("STEP6 -close all the tab ");
        driver.quit();


    }

}
