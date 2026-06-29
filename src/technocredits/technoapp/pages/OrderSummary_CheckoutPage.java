package technocredits.technoapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import technocredits.technoapp.base.BrowserActions;

public class OrderSummary_CheckoutPage extends BrowserActions {
    private WebElement continueToPaymentBtn;

    public void waitForPageLoad(){
         continueToPaymentBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='checkout-continue']")));
    }

    public void clickOnContinueToPaymentBtn(){
        continueToPaymentBtn.click();
    }

    public void setDeliveryAddress(String address){
        driver.findElement(By.xpath("//textarea[@id='co-address']")).sendKeys(address);
    }

    public void setPhoneNum(String phNum){
        driver.findElement(By.xpath("//input[@id='co-mobile']")).sendKeys(phNum);
    }

    public String getTotalPayableAmt(){
        return driver.findElement(By.xpath("//span[@data-testid='checkout-payable']")).getText();
    }
}
