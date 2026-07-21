package vishwajeetLoni.TCs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import vishwajeetLoni.base.ActionOnBrowser;

public class TechnoLoginPage extends ActionOnBrowser {

    public void doLogin(){
        System.out.println("STEP - Enter Student id");
        driver.findElement(By.xpath("//input[@id='access-student-id']")).sendKeys("2MD9HKUGWE");

        System.out.println("STEP - Enter Access code");
        driver.findElement(By.xpath("//input[@id='access-code']")).sendKeys("NG2EHUY2");

        System.out.println("STEP - Click on Continue");
        driver.findElement(By.xpath("//button[text()= 'Continue']")).click();

        System.out.println("STEP - Click on Sign In Food link");
        WebElement foodOrdering = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='choose-food']")));
        foodOrdering.click();

        System.out.println("STEP - Enter email");
        driver.findElement(By.xpath("//input[@data-testid='login-email']")).sendKeys("vishwajeet.customer1@technocredits.com");

         System.out.println("STEP - Enter password");
         driver.findElement(By.xpath("//input[@data-testid='login-password']")).sendKeys("vish1234");

        System.out.println("STEP - click on login button");
        driver.findElement(By.xpath("//button[@data-testid='login-submit-btn']")).click();

    }


}
