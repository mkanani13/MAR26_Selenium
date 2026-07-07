package smratiGarg.refactorRestaurentApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FoodLoginPage {
    public void login(){
        WebDriver driver = new ChromeDriver();
        System.out.println("launch browser and navigate to site");
        driver.manage().window().maximize();
        driver.get("http://34.66.197.232/#/access");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

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
