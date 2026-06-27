//Assignment 4
//Automate the following scenario using Selenium WebDriver in Java:
//Open the application: http://automationbykrishna.com/
//Click on the “Basic Elements” tab/button.
//Click on the “Alert” tab/button present under DIFFERENT EXAMPLES OF ALERTS.
//Alert message should pop-up "You must be TechnoCredits student!!"

package rutujaWaje;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment4 {
    @Test
    public void alertTab() {
            System.out.println("Launch Browser");
            WebDriver driver = new ChromeDriver();
            driver.get("http://automationbykrishna.com/");
            driver.manage().window().maximize();

            System.out.println("Click on Basic Element tab");
            WebElement basicelement=driver.findElement(By.xpath("//*[@id='basicelements']"));
            basicelement.click();

            System.out.println("Click on alert option");
            WebElement alerttab =driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
            alerttab.click();

            System.out.println("check the alert message");
            Alert alert = driver.switchTo().alert();
            String actualalert = alert.getText();
            Assert.assertEquals(actualalert,"You must be TechnoCredits student!!");
            alert.accept();
        }
    }


