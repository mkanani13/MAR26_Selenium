package smratiGarg.refactorRestaurentApp.pages;

import org.openqa.selenium.By;
import smratiGarg.base.BrowserActions;


public class LoginPage extends BrowserActions{

    public void doLogin () {
        System.out.println("STEP initial password");
        System.out.println("STEP username to enter into site ");
        driver.findElement(By.xpath("//input[@id='access-student-id']"))
                .sendKeys("39WJAEGT2P");
        driver.findElement(By.xpath("//input[@id='access-code']"))
                .sendKeys("ZJ9KCRZQ");


        System.out.println("STEP - Clicked submit button");
        driver.findElement(By.xpath("//form[@id='access-form']/button")).click();

        System.out.println("STEP role based login - Customer credential");

        driver.findElement(By
                        .xpath("//form[@id='login-form']/input[@type='email']"))
                .sendKeys("smrati.customer@technocredits.com");
        driver.findElement(By
                        .xpath("//form[@id='login-form']/input[@type='password']"))
                .sendKeys("Smrati@123");
        driver.findElement(By
                .xpath("//form[@id='login-form']/button")).click();

    }
}
