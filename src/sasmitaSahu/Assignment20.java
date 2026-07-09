package sasmitaSahu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Assignment20 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        System.out.println("Step1-Maximize the window");
        driver.manage().window().maximize();

        System.out.println("STEP2 - Launch the browser and navigate to:");
        driver.get("https://testing.qaautomationlabs.com/iframe.php");

        System.out.println("STEP3 - Navigate to IFrame menu");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Iframe']"))).click();

        System.out.println("Step4-VERIFY - Frame section title should be IFrame");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='text-light mb-1 mt-1 ml-1']")));
        String text = driver.findElement(By.xpath("//p[@class='text-light mb-1 mt-1 ml-1']")).getText();
        System.out.println(text);
        Assert.assertEquals(text, "IFrame");

        System.out.println("Step5-Switch to Iframe");
        WebElement frame1 = driver.findElement(By.xpath("//iframe[@src='iframe1.php']"));
        driver.switchTo().frame(frame1);

        System.out.println("STEP6 - Click on click me button");
        driver.findElement(By.xpath("//button[text()='CLick Me']")).click();

        System.out.println("Step7-.Switch back to the main web page (default content).");
        driver.switchTo().defaultContent();

        System.out.println("STEP8 - Verify that the message \"You have clicked on iframe1 button\" is displayed.");
        WebElement firstmessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        String actualmessage1 = firstmessage.getText();
        System.out.println(actualmessage1);
        Assert.assertEquals(actualmessage1, "You have clicked on iframe 1 button");

        System.out.println("Step9-Switch to the \"I am iFrame2\" frame.");
        WebElement frame2 = driver.findElement(By.xpath("//iframe[@src='iframe2.php']"));
        driver.switchTo().frame(frame2);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button"))).click();

        System.out.println("Step10- Click the \"Click Me\" button inside iFrame2.");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button"))).click();

        System.out.println("Step11-.Switch back to the main web page (default content).");
        driver.switchTo().defaultContent();

        System.out.println("STEP12 - Verify the message in iFrame2");
        WebElement message2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        String actualmessage2 = message2.getText();
        System.out.println(actualmessage2);
        Assert.assertEquals(actualmessage2, "You have clicked on iframe 2 button");

        System.out.println("STEP13 - Close Browser");
        driver.quit();

    }
}
