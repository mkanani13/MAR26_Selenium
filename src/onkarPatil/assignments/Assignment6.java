package onkarPatil.assignments;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.id("basicelements")).click();
        Thread.sleep(1000);

        WebElement alertButton = driver.findElement(By.id("javascriptPromp"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", alertButton);
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("onkar");
        alert.accept();

        String actaulText = driver.findElement(By.id("pgraphdemo")).getText();
        String expectedText = "Hello onkar! How are you today?";

        if(actaulText.equals(expectedText)){
            System.out.println("Pass!!!");
        }else{
            System.out.println("Fail");
        }

        driver.quit();
    }
}
