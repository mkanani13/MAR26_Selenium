package priyankaGhule.automationScript;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {
    public static void main(String[] arg)throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.id("basicelements")).click();
        Thread.sleep(1000);

        ((JavascriptExecutor)driver).executeScript("window.scroll(0,1000)");

        String expectedAleartText ="You must be TechnoCredits student!!";
        driver.findElement(By.id("javascriptAlert")).click();
        Alert alert = driver.switchTo().alert();
        String aleartMessage= alert.getText();
        if(expectedAleartText.equals(aleartMessage)){
            System.out.println("Pass");
        }else{
            System.out.println("Failed");
        }
        alert.accept();
        driver.quit();



    }
}
