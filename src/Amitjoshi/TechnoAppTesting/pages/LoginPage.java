package Amitjoshi.TechnoAppTesting.pages;

import Amitjoshi.TechnoAppTesting.base.BrowserActions;
import org.openqa.selenium.By;
public class LoginPage extends BrowserActions {
    public void doLogin(){
        System.out.println("STEP- Enter Student Id");
        driver.findElement(By.xpath("//input[@data-testid='access-student-id']")).sendKeys("P6YUZ7U34R");

        System.out.println("STEP- Enter Access Code");
        driver.findElement(By.xpath("//input[@id ='access-code']")).sendKeys("V6GBJZ93");

        System.out.println("STEP - click on continue Button ");
        driver.findElement(By.xpath("//button[@data-testid='access-submit-btn']")).click();

        System.out.println("STEP- Clicking the Food ordering ");
        driver.findElement(By.xpath("//button[@data-testid='choose-food']")).click();

        System.out.println("STEP- Enter Email");
        driver.findElement(By.xpath("//input[@data-testid='login-email']")).sendKeys("amit.customer@technocredits.com");

        System.out.println("STEP-Enter Password");
        driver.findElement(By.xpath("//input[@data-testid='login-password']")).sendKeys("Amit@123");

        System.out.println("STEP-Click on login Button ");
        driver.findElement(By.xpath("//button[@data-testid='login-submit-btn']")).click();

    }
}
