package raghunathMate;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment_3 {
    @Test
     void main() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://automationbykrishna.com/");
        Thread.sleep(2000);
        driver.findElement(By.id("basicelements")).click();
        Thread.sleep(2000);
        String firstName = "Raghu";
        String lastName = "Mate";
        String compName = "Technocredits";
        driver.findElement(By.id("UserFirstName")).sendKeys(firstName);
        driver.findElement(By.id("UserLastName")).sendKeys(lastName);
        driver.findElement(By.id("UserCompanyName")).sendKeys(compName);
        driver.findElement(By.xpath("//*[@onclick='myFunctionPopUp()']")).click();
        Thread.sleep(1000);
        String expMsg = firstName+" and "+lastName+" and "+compName;
        Alert alt = driver.switchTo().alert();
        String actualMsg = alt.getText();
        Assert.assertEquals(expMsg,actualMsg);
        alt.accept();
        driver.quit();
    }
}
