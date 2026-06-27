package onkarPatil.assignments;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("basicelements")).click();
        Thread.sleep(1000);

        WebElement alertButton = driver.findElement(By.id("javascriptConfirmBox"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", alertButton);
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        String actualText = driver.findElement(By.id("pgraphdemo")).getText();
        String expectedText = "You pressed OK!";

        if(actualText.equals(expectedText)){
            System.out.println("Pass!!");
        }else{
            System.out.println("Fail :(");
        }

        driver.quit();
    }
}
