package priyankaGhule.automationScript;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Asignment5 {
    public static void main(String[] args)throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.id("basicelements")).click();
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,1000)");

        String expectedAlertMessage = "Are you are doing your homework regularly, Press Okay else Cancel!!";
        WebElement alertbtn = driver.findElement(By.id("javascriptConfirmBox"));
        alertbtn.click();
        Alert alert = driver.switchTo().alert();
        String actualAlertMessage = alert.getText();
        if(expectedAlertMessage.equals(actualAlertMessage)){
            System.out.println("Pass");
        }else{
            System.out.println("Failed");
        }
        alert.accept();

        String element = driver.findElement(By.xpath("//P[text()='You pressed OK!'] ")).getText();
        String expectedMessage = "You pressed OK!";
        if(element.equals(expectedMessage)){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }
        driver.quit();
    }
}
