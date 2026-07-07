package supriyaKanase.automationScript;

import supriyaKanase.Base.BrowserAction;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment3 {
    @Test
    public void alertDemo() {

        String firstName = "Supriya";
        String lastName = "Kanase";
        String companyName = "Ansh";

        WebDriver driver = BrowserAction.start("http://automationbykrishna.com/");

        System.out.println("Click on Basic Element Button");
        driver.findElement(By.id("basicelements")).click();

        System.out.println("Enter User First Name");
        driver.findElement(By.id("UserFirstName")).sendKeys(firstName);
        System.out.println("Enter User Last Name");
        driver.findElement(By.id("UserLastName")).sendKeys(lastName);

        System.out.println("Enter User Company Name");
        driver.findElement(By.id("UserCompanyName")).sendKeys(companyName);

        System.out.println("Click on Submit Button");
        driver.findElement(By.xpath("//div[@class='panel-body']//div[4]/button")).click();

        String expectedOutput = firstName + " and " + lastName + " and " + companyName;

        System.out.println("Switch To Alert");
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();

        Assert.assertEquals(actualText,expectedOutput);
        alert.accept();
        driver.quit();
    }
}
