/*Selenium Assignment - 3: 9th June'2026
Automate the following scenario using Selenium WebDriver in Java:

Open the application: http://automationbykrishna.com/
Click on the “Basic Elements” tab/button.

Enter values in:
FirstName field
LastName field
CompanyName field

Click on the Submit button.
Alert message should pop-up "FirstName and LastName and CompanyName"*/

package rajashreePatil.automationScript;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment3 {
    static void alertOnBasicElementsPage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/");

        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys("Rajashree");

        driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("Patil");
        driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("GaneshaCompany");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String firstname = "Rajashree";
        String lastname = "Patil";
        String companyname = "GaneshaCompany";

        String expectedAlertMessage = firstname + " and " + lastname + " and " + companyname;
        System.out.println(expectedAlertMessage);
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),expectedAlertMessage);
        alert.accept();
        driver.quit();

    }
    @Test
    public void verifyAlertMessage() throws InterruptedException {
        Assignment3 assignment3 = new Assignment3();
        assignment3.alertOnBasicElementsPage();
    }
}
