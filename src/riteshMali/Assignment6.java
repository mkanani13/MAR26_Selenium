package automationScript;

//Write a Selenium WebDriver automation script in Java to perform the following steps:
//        1. Launch the application: http://automationbykrishna.com/
//        2. Click on the “Basic Elements” tab.
//3. Under the section “DIFFERENT EXAMPLES OF ALERTS”, click on the “Javascript Prompt” tab/button.
//4. Enter the NAME in the JavaScript Prompt that appears and click on "OK" button.
//5. Read the text message that appears.
//        6. Verify that the confirmation message displayed on the page is:
//        "Hello NAME! How are you today?"


import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {

    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        System.out.println("Step - Launch browser ");
        driver.get("http://automationbykrishna.com/");
        Thread.sleep(1000);

        System.out.println("Step - Click on Basic Element");
        driver.findElement(By.xpath(" //a[@id='basicelements']")).click();
        Thread.sleep(1000);

        System.out.println("Step - click on java prompt button");
        WebElement confButton = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", confButton);
        confButton.click();
        Thread.sleep(1000);


        Alert alert = driver.switchTo().alert();
        String name = "Ritesh";
        alert.sendKeys(name);
        Thread.sleep(1000);
        alert.accept();

        String expectedMessage = "Hello" + name + " ! How are you today?";

        String paragText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
        if (paragText.contains(expectedMessage)) {
            System.out.println("Pass");
        } else {
            System.out.println("Failed");
        }

        driver.quit();

    }

}
