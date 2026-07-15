package vishwajeetLoni.TCs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import vishwajeetLoni.base.ActionOnBrowser;

public class OrderCheckoutPage extends ActionOnBrowser {

    private WebElement continueToPaymentBtn;

    public void waitForPageLoad (){
       continueToPaymentBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='checkout-continue']")));
    }

    public void clickOnContinueToPaymentBtn(){
        continueToPaymentBtn.click();
    }

    public void enterAddress(String add){
       WebElement addressInput = driver.findElement(By.xpath("//textarea[@data-testid='checkout-address']"));
       addressInput.sendKeys(add);
    }

    public void enterPhNo(String phNo){
        WebElement phNoInput = driver.findElement(By.xpath("//input[@data-testid='checkout-mobile']"));
        phNoInput.sendKeys(phNo);
    }

    public String payableAmt(){
       return driver.findElement(By.xpath("//span[text()='Payable']/following-sibling::span")).getText();
    }


}
