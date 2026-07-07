package riteshMali.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import riteshMali.base.BrowserActions;

public class OrderSummary_CheckoutPage extends BrowserActions {
    private WebElement continueToPaymentBtn;

    public void waitForPAgeLoad(){
        continueToPaymentBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='co-continue']")));
    }

    public void clickOnContinueToPaymentBtn(){
        continueToPaymentBtn.click();
    }

    public void setDeliveryAddress(String address){
        driver.findElement(By.xpath("//textarea[@id='co-address']")).sendKeys(address);
    }

    public void setPhoneNo(String phNo){
        driver.findElement(By.xpath("//input[@id='co-mobile']")).sendKeys(phNo);
    }

    public String getTotalPayableAmount(){
      return  driver.findElement(By.xpath("//span[@data-testId='checkout-payable']")).getText();
    }

}
