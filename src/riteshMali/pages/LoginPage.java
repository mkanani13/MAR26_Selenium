package riteshMali.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import riteshMali.base.BrowserActions;

public class LoginPage extends BrowserActions {

    public void doLogin(){

        BrowserActions.start();
        System.out.println("Step - Enter student ID");
        driver.findElement(By.xpath("//input[@id='access-student-id']")).sendKeys("VUEXMVV5C7");

        System.out.println("Step - Enter Access code");
        driver.findElement(By.xpath("//input[@id='access-code']")).sendKeys("5ZTKTATH");

        System.out.println("Step - Click on continue button ");
        driver.findElement(By.xpath("//button[@data-testid='access-submit-btn']")).click();


        System.out.println("Step - click on sign in food app");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='choose-food']"))).click();

        System.out.println("Step - Enter Email Address and password using autofill");
        driver.findElement(By.xpath("//button[@data-testid='demo-customer']")).click();

        System.out.println("Step - Click on Sign in to Technocredits Food button");
        driver.findElement(By.xpath("//button[@data-testid='login-submit-btn']")).click();
    }

}
