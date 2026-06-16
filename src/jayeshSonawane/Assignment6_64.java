package seleniumAssignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Write a Selenium WebDriver automation script in Java to perform the following steps:


1. Launch the application: http://automationbykrishna.com/
2. Click on the “Basic Elements” tab.
3. Under the section “DIFFERENT EXAMPLES OF ALERTS”, click on the “Javascript Prompt” tab/button.
4. Enter the NAME in the JavaScript Prompt that appears and click on "OK" button.
5. Read the text message that appears.
6. Verify that the confirmation message displayed on the page is:

        "Hello NAME! How are you today?"
 */
public class Assignment6_64 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationbykrishna.com/");

        if(driver.getCurrentUrl().equals("http://automationbykrishna.com/")){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        WebElement elementBasicElements = driver.findElement(By.xpath("//a[@id='basicelements']"));
        elementBasicElements.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement elementButtonJavascriptPrompt = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]"));
        elementButtonJavascriptPrompt.click();

        Alert alert = driver.switchTo().alert();
        String enteredPromptText = "Jayesh";
        alert.sendKeys(enteredPromptText);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        alert.accept();

        WebElement elementReturnedPromptText = driver.findElement(By.xpath("//p[@id='pgraphdemo']"));
        String returnedPromptText = elementReturnedPromptText.getText();

        if(returnedPromptText.contains(enteredPromptText)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
