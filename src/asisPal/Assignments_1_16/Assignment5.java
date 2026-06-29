package asisPal.Assignments_1_16;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

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


        System.out.println("STEP4 -Click on javascript confirmation button ");
        WebElement alertbotton = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", alertbotton);
        alertbotton.click();

        System.out.println("STEP4 -Switch to alert message ");
        String expectedAlertText = "Are you are doing your homework regularly, Press Okay else Cancel!!";
        Alert alert = driver.switchTo().alert();
        String actualAlertText = alert.getText();

        if (actualAlertText.equals(expectedAlertText)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }

        System.out.println("STEP5-click on ok button ");
        alert.accept();

        System.out.println("STEP6-Verify accept message ");
        String expectedmessage = "You pressed OK!";

        String pressButtonText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
        if (expectedmessage.equals(pressButtonText)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }

    }

}
