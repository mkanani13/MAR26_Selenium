//Write a Selenium WebDriver automation script in Java to perform the following steps:
//1. Launch the application: http://automationbykrishna.com/
//2. Click on the “Basic Elements” tab.
//3. Under the section “DIFFERENT EXAMPLES OF ALERTS”, click on the “Javascript Prompt” tab/button.
//4. Enter the NAME in the JavaScript Prompt that appears and click on "OK" button.
//5. Read the text message that appears.
//6. Verify that the confirmation message displayed on the page is:
//        "Hello NAME! How are you today?"
package rutujaWaje;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment6 {
    @Test
    public void javascriptpromptalerttab() throws InterruptedException {
            System.out.println("Launch Browser");
            WebDriver driver = new ChromeDriver();
            driver.get("http://automationbykrishna.com/");
            driver.manage().window().maximize();

            System.out.println("Click on Basic Element tab");
            WebElement basicelement=driver.findElement(By.xpath("//*[@id='basicelements']"));
            basicelement.click();
            Thread.sleep(1000);

            System.out.println("Javascript Prompt tab");
            WebElement javascriptprompt =driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
            javascriptprompt.click();

            System.out.println("check the alert message");
            Alert alert = driver.switchTo().alert();
            String name= "Rutuja";
            alert.sendKeys(name);
            alert.accept();
            String actualmessage = driver.findElement(By.id("pgraphdemo")).getText();
            String expectedmessage = "Hello " + name + "! How are you today?";
            Assert.assertEquals(actualmessage,expectedmessage);
            driver.quit();
        }
    }




