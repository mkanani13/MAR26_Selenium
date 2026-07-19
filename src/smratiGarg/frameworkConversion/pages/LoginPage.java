package smratiGarg.frameworkConversion.pages;

import org.openqa.selenium.By;
import smratiGarg.frameworkConversion.base.BrowserActions;

public class LoginPage extends BrowserActions {

    public void doLogin(){
        // -------> LoginPage
        System.out.println("enter access id and password and click");
        driver.findElement(By.xpath("//input[@id='access-student-id']"))
                .sendKeys("39WJAEGT2P");
        driver.findElement(By.xpath("//input[@id='access-code']"))
                .sendKeys("ZJ9KCRZQ");
        driver.findElement(By.xpath("//form[@id='access-form']/button"))
                .click();

        // -------> AppSelectingPage
        System.out.println("enter food app");
        driver.findElement(By.xpath("//button[@data-testid='choose-food']"))
                .click();



        // -------> FoodAppLoginPage
        System.out.println("customer id and password");
        driver.findElement((By.xpath("//input[@id='login-email']")))
                .sendKeys("smrati@technocredits.com");
        driver.findElement((By.xpath("//input[@id='login-password']")))
                .sendKeys("pass@123");
        driver.findElement(By.xpath("//button[@data-testid='login-submit-btn']"))
                .click();

    }
}
