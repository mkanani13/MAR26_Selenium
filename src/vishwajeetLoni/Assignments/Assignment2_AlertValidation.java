package vishwajeetLoni.Assignments;
//Automate the following scenario using Selenium WebDriver in Java:
//
//Open the application: http://automationbykrishna.com/
//Click on the “Registration” tab/button.
//Check the below conditions:-
//
//Condition 1:-
//Enter values in:
//User Name field
//Password field (must provide less than 8 characters)
//Click on the Submit button (Green Tick icon) to complete registration.
//Alert message should pop-up "Failed! please enter strong password"
//
//Condition 2:-
//Enter values in:
//User Name field
//Password field (must provide greater than 8 characters)
//Click on the Submit button (Green Tick icon) to complete registration.
//Alert message should pop-up "Success!"

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import vishwajeetLoni.base.ActionOnBrowser;

public class Assignment2_AlertValidation {
    WebDriver driver;
    String failMessage = "Failed! please enter strong password";
    String passMessage = "Success!";

    @Test
    public void  alertMsgFail() {
        driver = ActionOnBrowser.start();

        System.out.println("Step - Go to Registration tab");
        driver.findElement(By.xpath("//a[@id='registration2']")).click();

        System.out.println("Switched to registration tab");

        System.out.println("Step - Enter credentials and submit");
        driver.findElement(By.id("unameSignin")).sendKeys("424224w332");
        driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Test@11");
        driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
        System.out.println("Credentials entered");

        System.out.println("Step - Switch to alert box");
        Alert alert = driver.switchTo().alert();

        System.out.println("Capture msg in alert box");
        String alertMessage = alert.getText();

        System.out.println("Test - Verify the message as Failure");

        Assert.assertTrue(alertMessage.equals(failMessage));
        alert.accept();

    }

    @Test
    public void alertMsgPass() {

        System.out.println("Clear the Passoword field and enter new password");
        WebElement pwdField = driver.findElement(By.xpath("//input[@id='pwdSignin']"));
        pwdField.clear();
        pwdField.sendKeys("123456789");

        System.out.println("Test - Verify password field is updated and not empty");
        Assert.assertNotEquals(pwdField," ");

        System.out.println("Click on Sumbit button");
        driver.findElement(By.id("btnsubmitdetails")).click();

        System.out.println("Step - Switch to alert box");
        Alert alert = driver.switchTo().alert();

        System.out.println("Capture msg in alert box");
        String alertMessage = alert.getText();

        System.out.println("Test - Verify the message as Pass");

        Assert.assertTrue(alertMessage.equals(passMessage));
        alert.accept();

        driver.quit();

    }

//    public static void main(String[] args) throws InterruptedException {
//
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://automationbykrishna.com/");                   // open website
//        driver.findElement(By.id("registration2")).click();             // click on registration
//        Thread.sleep(1000);
//
//
//        driver.findElement(By.id("unameSignin")).sendKeys("Testuser"); // switch to username and enter username
//
//        WebElement pwdInput = driver.findElement(By.id("pwdSignin"));  // store password element in a variable
//        pwdInput.sendKeys("1234567");    // enter password less than or equal to 8 digits
//        driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();  // find and click on green tick mark to submit
//
//        Thread.sleep(1000);
//
//
//        Alert alert = driver.switchTo().alert();   // switch to alert box
//        String alertText = alert.getText();        // capture text in alert box
//        String passtext = "Success!";               // declaring variable for Pass criteria
//        String failtext = "Failed! please enter strong password";   //declaring var for fail criteria
//        if (alertText.equals(passtext)) {              // comparing the result
//            System.out.println("Pass");
//        } else {
//            System.out.println(failtext);
//        }
//        alert.accept();    // close the alert box
//
//
//        Thread.sleep(5000);
//
//        pwdInput.clear();  // clear the password field
//        pwdInput.sendKeys("123456789");  // enter the password again
//        driver.findElement(By.id("btnsubmitdetails")).click();
//
//        alertText = alert.getText();  //capture text again
//
//        if (alertText.equals(passtext)){
//            System.out.println("Pass");
//        }else {
//            System.out.println(failtext);
//        }
//
//        alert.accept();  //close the alert box
//        Thread.sleep(5000);
//        driver.quit();
//
//    }

}