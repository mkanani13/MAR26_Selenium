package technocredits.technoapp.pages;

import org.openqa.selenium.By;
import technocredits.technoapp.base.BrowserActions;

public class LoginPage extends BrowserActions {

    public void doLogin(){
        System.out.println("STEP - Enter Student id");
        driver.findElement(By.xpath("//input[@data-testid='access-student-id']")).sendKeys("43ZWT2NGQP");

        System.out.println("STEP - Enter Access code");
        driver.findElement(By.xpath("//input[@data-testid='access-code']")).sendKeys("XS8Q5FZU");

        System.out.println("STEP - Click on continue button");
        driver.findElement(By.xpath("//button[text()= 'Continue']")).click();

        System.out.println("STEP - Enter email");
        driver.findElement(By.xpath("//input[@data-testid='login-email']")).sendKeys("user@technocredits.com");

        System.out.println("STEP - Enter password");
        driver.findElement(By.xpath("//input[@data-testid='login-password']")).sendKeys("User@123");

        System.out.println("STEP - click on login button");
        driver.findElement(By.xpath("//button[@data-testid='login-submit-btn']")).click();
    }
}
