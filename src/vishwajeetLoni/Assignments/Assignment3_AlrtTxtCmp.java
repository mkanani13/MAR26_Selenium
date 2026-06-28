package vishwajeetLoni.Assignments;

//Automate the following scenario using Selenium WebDriver in Java:
//
//Open the application: http://automationbykrishna.com/
//Click on the “Basic Elements” tab/button.
//
//Enter values in:
//FirstName field
//LastName field
//CompanyName field
//
//Click on the Submit button.
//Alert message should pop-up "FirstName and LastName and CompanyName"

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import vishwajeetLoni.base.ActionOnBrowser;

public class Assignment3_AlrtTxtCmp {

    WebDriver driver;

    @Test
    public void alertMsg(){
        driver = ActionOnBrowser.start();

        System.out.println("Switch to Basic Elements Tab");
        driver.findElement(By.id("basicelements")).click();     // Click on BAsic Elements tab

        System.out.println("Declare string for Firstname Last name and company ");
        String username = "TestUserName";
        String lastname = "TestLastName";
        String companyname = "TestCompanyName";

        System.out.println("Enter FirstName, Last name, Company name and click Submit");
        WebElement firstName = driver.findElement(By.id("UserFirstName"));
        firstName.sendKeys(username);

        WebElement lastName = driver.findElement(By.id("UserLastName"));
        lastName.sendKeys(lastname);

        WebElement companyName = driver.findElement(By.id("UserCompanyName"));
        companyName.sendKeys(companyname);

        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[1]")).click();

        System.out.println("Switch top alert and capture text ");
        Alert alert = driver.switchTo().alert();
        String actualAlertText = alert.getText();
        System.out.println(actualAlertText);

        System.out.println("Test - Verify the expected text in alert box");
        String expectedAlerttext = username + " and " + lastname + " and " + companyname;
        System.out.println(expectedAlerttext);

        Assert.assertTrue(actualAlertText.equals(expectedAlerttext));
        alert.accept();

        driver.quit();

    }

//    public static void main(String[] args) throws InterruptedException {
//
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://automationbykrishna.com/");
//        driver.findElement(By.id("basicelements")).click();     // Click on BAsic Elements tab
//        Thread.sleep(5000);
//
//        String username = "TestUserName";
//        String lastname = "TestLastName";
//        String companyname = "TestCompanyName";
//
//        driver.findElement(By.id("UserFirstName")).sendKeys(username);
//        driver.findElement(By.id("UserLastName")).sendKeys(lastname);
//        driver.findElement(By.id("UserCompanyName")).sendKeys(companyname);
//        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[1]")).click();
//
//        Alert alert = driver.switchTo().alert();
//        String actualAlertText = alert.getText();
//        System.out.println(actualAlertText);
//        String expectedAlerttext = username + " and " + lastname + " and " + companyname;
//        System.out.println(expectedAlerttext);
//
//        if (actualAlertText.equals(expectedAlerttext)){
//            System.out.println("Pass");
//        }else {
//            System.out.println("Fail");
//        }
//
//        alert.accept();
//
//
//    }
}
