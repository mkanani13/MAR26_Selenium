package vishwajeetLoni.Assignments;

//Write a Selenium WebDriver automation script in Java to perform the following steps:
//
//
//1. Launch the application: http://automationbykrishna.com/
//2. Click on the “Basic Elements” tab.
//3. Under the section “DIFFERENT EXAMPLES OF ALERTS”, click on the “Javascript Prompt” tab/button.
//4. Enter the NAME in the JavaScript Prompt that appears and click on "OK" button.
//5. Read the text message that appears.
//6. Verify that the confirmation message displayed on the page is:
//
//        "Hello NAME! How are you today?"

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import vishwajeetLoni.base.ActionOnBrowser;

import java.time.Duration;

public class Assignment6_ScrollPageJSPrompt {

    @Test
    public void jsPrompt(){
        WebDriver driver;

        driver = ActionOnBrowser.start();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("basicelements")).click();

        System.out.println("Step - Scroll to Javascript confirmation alert btn");
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id = 'javascriptPromp']")));
        System.out.println("Scroll action and click ");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",btn);

        System.out.println("Step - Click on Javascript Confirmation Alert btn");
        btn.click();
        System.out.println("Btn click");

        System.out.println("Switch to Alert");
        Alert alert = driver.switchTo().alert();

        System.out.print("Enter your name: ");
        String entered = "Vishwajeet";
        alert.sendKeys(entered);
        alert.accept();


        System.out.println("Step - verify the message");
        String actualmsg = driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText();
        String expectedMsg = "Hello " + entered + "! How are you today?";
        Assert.assertEquals(actualmsg,expectedMsg);

    }
//    public static void main(String[] args) {
//
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://automationbykrishna.com/");
//        driver.manage().window().maximize();
//
//        driver.findElement(By.id("basicelements")).click();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        WebElement btn = driver.findElement(By.xpath("//button[@id = 'javascriptPromp']"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);",btn);
//        btn.click();
//        System.out.println("Btn click");
//
//        Alert alert = driver.switchTo().alert();
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter your name: ");
//        String name = sc.nextLine();
//        sc.close();
//
//
//        String entered = "Vishwajeet";
//        alert.sendKeys(entered);
//        alert.accept();
//
//        String tocheck = driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText();
//        if (tocheck.contains(entered))
//            System.out.println("Clicked on Ok");
//    }
}
