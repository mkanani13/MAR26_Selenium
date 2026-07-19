package raghunathMate;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment_2 {
    @Test
     void main() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        System.out.println("Step-Navigate to link");
        driver.get("http://automationbykrishna.com/");
        System.out.println("Step-clicking of registration module");
        driver.findElement(By.id("registration2")).click();
        Thread.sleep(1000);
        System.out.println("Step-entering user name");
        WebElement userName = driver.findElement(By.id("unameSignin"));
        WebElement password =  driver.findElement(By.id("pwdSignin"));
        WebElement subButton = driver.findElement(By.id("btnsubmitdetails"));
        userName .sendKeys("RaghuMate");
        System.out.println("Step-entering password");
        password.sendKeys("Raghu12345");
        System.out.println("Step-clicking on submit button");
        subButton .click();
       Alert alt =  driver.switchTo().alert();
       Thread.sleep(1000);
       String actualMsg = alt.getText();
       String expMassage ="Success!";
       Assert.assertEquals(expMassage,actualMsg);
       alt.accept();
        password.clear();
        System.out.println("Step-entering password");
        password.sendKeys("Raghu12");
        System.out.println("Step-clicking on submit button");
        subButton .click();
       // Alert alt1 =  driver.switchTo().alert();
        Thread.sleep(1000);
        String actualMsg1 = alt.getText();
        String expMassage1 ="Failed! please enter strong password";
        Assert.assertEquals(expMassage1,actualMsg1);
        alt.accept();
       driver.quit();
    }

}
