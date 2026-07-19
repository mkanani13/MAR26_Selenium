package nishantBentur.technocreditsFoodApp.pages;

import nishantBentur.base.BrowserActions;
import org.openqa.selenium.By;
<<<<<<< HEAD
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
=======
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe
import org.testng.Assert;


public class LoginPage extends BrowserActions {
<<<<<<< HEAD
    private String chooseYourApp_xpath = "//div[@data-testid='app-chooser']//h1";
=======
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe

    public void doLogin() {
        System.out.println("STEP-Login using Student ID");
        driver.findElement(By.xpath("//input[@id='access-student-id']")).sendKeys("Z93GF63U37");

        System.out.println("STEP-Enter Access ID");
        driver.findElement((By.xpath("//input[@id='access-code']"))).sendKeys("S3WMAR4G");

        System.out.println("STEP-Click on Continue");
        driver.findElement(By.xpath("(//button[@type='submit'])[text()='Continue']")).click();

        System.out.println("VERIFY - Choose your application is displayed");
<<<<<<< HEAD
        WebElement signInFoodElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(chooseYourApp_xpath)));
        boolean flag = driver.findElement(By.xpath(chooseYourApp_xpath)).isDisplayed();
=======
        boolean flag = driver.findElement(By.xpath("//div[@data-testid='app-chooser']//h1")).isDisplayed();
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe
        Assert.assertTrue(flag, "Choose your application not found");

        System.out.println("STEP- Select Food Ordering");
        driver.findElement(By.xpath("//button[@data-testid='choose-food']")).click();

        System.out.println("Select Sign in tab");
        driver.findElement(By.xpath("//button[@id='tab-login']")).click();

        System.out.println("SignIn using Email ID");
<<<<<<< HEAD
        driver.findElement(By.id("login-email")).sendKeys("user@technocredits.com");

        System.out.println("Enter Password");
        driver.findElement(By.id("login-password")).sendKeys("User@123");
=======
        driver.findElement(By.id("login-email")).sendKeys("nishant.customer@technocredits.com");

        System.out.println("Enter Password");
        driver.findElement(By.id("login-password")).sendKeys("Nishant1234");
>>>>>>> 002f1872ab401f3e8eeecbddfb83bd6302b737fe

        System.out.println("Click on SignIn to Technocredits Food");
        driver.findElement(By.xpath("//button[@data-testid='login-submit-btn']")).click();
    }
}
