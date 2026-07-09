package asisPal.Assignments_1_16;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {
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


        System.out.println("STEP4 -Click on javascript prompt button ");
        WebElement alertbotton = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", alertbotton);
        alertbotton.click();

        System.out.println("STEP5-switch to alert message  ");
        Alert alert1 = driver.switchTo().alert();
        String name = "sasmita";
        alert1.sendKeys(name);
        alert1.accept();

        System.out.println("STEP6-Read the confirm meassage  ");
        WebElement message = driver.findElement(By.xpath("//p[@id='pgraphdemo']"));
        String actualtext = message.getText();

        System.out.println("STEP7-Verify the confirm meassage  ");
        String expectedtext = "Hello " + name + "! How are you today?";
        if (actualtext.contains(expectedtext)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }
        driver.quit();

    }
}
