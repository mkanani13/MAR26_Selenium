package smratiGarg.assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Asgn03_ManageAlert {
    @Test
    public void BrowserOpen() throws InterruptedException {
        WebDriver driver = new ChromeDriver(); //launching chrome

        System.out.println("step -navigate to automationbykrishna");
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com");
        driver.findElement(By.id("basicelements")).click();

        String firstname = "Smrati";
        String lastname = "Garg";
        String companyname = "HireCorrecto";

        System.out.println("STEP enter first name");
        driver.findElement(By.id("UserFirstName")).sendKeys(firstname);

        System.out.println("STEP enter last name");
        driver.findElement(By.id("UserLastName")).sendKeys(lastname);

        System.out.println("STEP enter company name");
        driver.findElement(By.id("UserCompanyName")).sendKeys(companyname);

        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[1]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());
        String expectedAlertMsg = firstname + " and " + lastname + " and " + companyname;

        Alert alert = driver.switchTo().alert();
        String actualAlertMsg = alert.getText();
        Assert.assertEquals(expectedAlertMsg, actualAlertMsg);
        alert.accept();
        driver.quit();

    }
}