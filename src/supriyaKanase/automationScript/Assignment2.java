package supriyaKanase.automationScript;

import supriyaKanase.Base.BrowserAction;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment2 {
    WebDriver driver;
    @Test
    public  void checkLogIn()  {

        WebDriver driver = BrowserAction.start("http://automationbykrishna.com/");

        System.out.println("Step - Click on registration link");
        driver.findElement(By.id("registration2")).click();

        System.out.println("Step - Enter UserName");
        driver.findElement(By.id("unameSignin")).sendKeys("SupriyaK");

        System.out.println("Step - Enter Password");
        WebElement passwordInputText = driver.findElement(By.id("pwdSignin"));
        passwordInputText.sendKeys("1234567");

        System.out.println("Step - Click on Button");
        driver.findElement(By.id("btnsubmitdetails")).click();

        System.out.println("Switch To Alert");
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();

        Assert.assertEquals(alertMessage, "Failed! please enter strong password");

        alert.accept();
        System.out.println("step - clear password input");
        passwordInputText.clear();

        System.out.println("Step - enter password");
        passwordInputText.sendKeys("supriya123");
        System.out.println("Click on button");
        driver.findElement(By.id("btnsubmitdetails")).click();

        Alert sucessAlert = driver.switchTo().alert();
        String alertText = sucessAlert.getText();

        Assert.assertEquals(alertText,"Success!");
        alert.accept();
        driver.quit();
    }
}
