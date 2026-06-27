package technocredits.technoapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import technocredits.technoapp.base.BrowserActions;

public class LoginPage extends BrowserActions {

    public void doLogin(){
        System.out.println("STEP - Enter Student id");
        driver.findElement(By.xpath("//input[@data-testid='access-student-id']")).sendKeys("35EGM7D45W");

        System.out.println("STEP - Enter Access code");
        driver.findElement(By.xpath("//input[@data-testid='access-code']")).sendKeys("7MNT2R2F");

        System.out.println("STEP - Click on continue button");
        driver.findElement(By.xpath("//button[text()= 'Continue']")).click();

        System.out.println("STEP - Click on Sign In Food link");
        WebElement signInFoodElement  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='choose-food']")));
        signInFoodElement.click();

        System.out.println("STEP - Click on AutoFill & SignIn as customer");
        driver.findElement(By.xpath("//button[@data-email='user@technocredits.com']")).click();

        //System.out.println("STEP - Enter email");
        //driver.findElement(By.xpath("//input[@data-testid='login-email']")).sendKeys("raghu.customer@technocredits.com");

       // System.out.println("STEP - Enter password");
       // driver.findElement(By.xpath("//input[@data-testid='login-password']")).sendKeys("raghuCust@12345");

        System.out.println("STEP - click on login button");
        driver.findElement(By.xpath("//button[@data-testid='login-submit-btn']")).click();
    }
}
