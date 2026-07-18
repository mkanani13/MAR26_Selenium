//Write a Selenium WebDriver automation script in Java to perform the following steps:
//1. Launch the application: http://automationbykrishna.com/
//2. Click on the “Basic Elements” tab.
//3. Under the section “DIFFERENT EXAMPLES OF ALERTS”, click on the “Javascript Confirmation” tab/button.
//4. Handle the JavaScript confirmation alert that appears.
//5. Read the alert message and accept it by clicking “OK”.
//6. Verify that the confirmation message displayed on the page is:
//
//       "You pressed OK!"

package rutujaWaje;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment5 {
    @Test
    public void basicelementtabalert() {
            System.out.println("Launch Browser");
            WebDriver driver = new ChromeDriver();
            driver.get("http://automationbykrishna.com/");
            driver.manage().window().maximize();

            System.out.println("Click on Basic Element tab");
            WebElement basicelement=driver.findElement(By.xpath("//*[@id='basicelements']"));
            basicelement.click();

            System.out.println("Javascript Confirmation tab");
            WebElement javascriptconfirnmation =driver.findElement(By.id("javascriptConfirmBox"));
            javascriptconfirnmation.click();

            System.out.println("Check the alert message");
            Alert alert = driver.switchTo().alert();
            String actualalert = alert.getText();
            System.out.println("Alert Message: " + actualalert);
            alert.accept();
            String actualmessage =driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
            String Expectedmessage = "You pressed OK!" ;
            Assert.assertEquals(actualmessage,Expectedmessage);
        }
    }


