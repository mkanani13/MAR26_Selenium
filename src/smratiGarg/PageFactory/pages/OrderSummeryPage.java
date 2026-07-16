package smratiGarg.PageFactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import smratiGarg.PageFactory.base.BrowserAction;

import java.time.Duration;

public class OrderSummeryPage extends BrowserAction {

    public void waitForPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='co-continue']")));
    }
    public void enterAddress(String address){
        driver.findElement(By.xpath("//textarea[@id='co-address']"))
                .sendKeys(address);
    }

    public void enterMobileNumber(String mobileNumber){
        driver.findElement(By.xpath("//input[@type='tel']"))
                .sendKeys(mobileNumber);
    }
    public void enterAddressAndMobile(String address, String mobile){
        enterAddress(address);
        enterMobileNumber(mobile);
    }
    public String getTotalPayable(){
       return driver.findElement(By.xpath( "//span[@data-testid='checkout-payable']"))
               .getText();
    }

    public void clickContinue(){
        driver.findElement(By.xpath("//button[@id='co-continue']")).click();
    }

}
