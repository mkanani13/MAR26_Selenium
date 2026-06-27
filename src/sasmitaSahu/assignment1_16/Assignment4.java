package sasmitaSahu.assignment1_16;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        System.out.println("STEP1 - Maximize the window");
        driver.manage().window().maximize();

        System.out.println("STEP2 - Navigation to automationbykrishna");
        driver.get("http://automationbykrishna.com/");
        Thread.sleep(1000);
        System.out.println("STEP3 - Click on basic element");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();

        Thread.sleep(1000);


        System.out.println("STEP4 -Click on Alert button ");
        WebElement alertbotton = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", alertbotton);
        alertbotton.click();

        String expectedAlertMessage = "You must be TechnoCredits student!!";

        System.out.println("STEP5 - Switch to alert message ");
        Alert alert = driver.switchTo().alert();
        String actualAlertMessage = alert.getText();
        if (expectedAlertMessage.equals(actualAlertMessage)) {
            System.out.println("pass");
        } else {
            System.out.println("Fail");
        }
        alert.accept();
        driver.quit();


    }
}
