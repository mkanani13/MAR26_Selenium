package vishwajeetLoni;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertValidation_Assignment2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com/");                   // open website
        driver.findElement(By.id("registration2")).click();             // click on registration
        Thread.sleep(1000);


        driver.findElement(By.id("unameSignin")).sendKeys("Testuser"); // switch to username and enter username
        driver.findElement(By.id("pwdSignin")).sendKeys("1234567");    // switch to password and enter password less than or equal to 8 digits
        driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();  // find and click on green tick mark to submit

        Thread.sleep(1000);


        Alert alert = driver.switchTo().alert();   // switch to alert box
        String alertText = alert.getText();        // capture text in alert box
        String passtext = "Success!";               // declaring variable for Pass criteria
        String failtext = "Failed! please enter strong password";   //declaring var for fail criteria
        if (alertText.equals(passtext)) {              // comparing the result
            System.out.println("Pass");
        } else {
            System.out.println(failtext);
        }
        alert.accept();



        Thread.sleep(5000);
        driver.navigate().refresh();

        // executing again with password greater than 8 characters

        driver.findElement(By.id("registration2")).click();             // click on registration
        Thread.sleep(1000);

        driver.findElement(By.id("unameSignin")).sendKeys("Testuser"); // switch to username and enter username
        driver.findElement(By.id("pwdSignin")).sendKeys("123456789");    // switch to password and enter password greater than or equal to 8 digits
        driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();  // find and click on green tick mark to submit

        Thread.sleep(1000);

        Alert alert1 = driver.switchTo().alert();
        String alertText1 = alert.getText();
        String passtext1 = "Success!";
        String failtext1 = "Failed! please enter strong password";
        if (alertText.equals(passtext1)){
            System.out.println("Pass");
        }else {
            System.out.println(failtext1);
        }

        Thread.sleep(5000);

        driver.quit();



    }
}
