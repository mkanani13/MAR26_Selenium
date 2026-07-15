package raghunathMate.puneFoodDelivery.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import raghunathMate.puneFoodDelivery.testBase.BrowserAction;

public class OrderSummaryPage extends BrowserAction {
    private WebElement proceedToPaymentButton;

    public void waitForPageLoad() {
        proceedToPaymentButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Continue to Payment →']")));
    }
    public void clickOnProceedToPaymentButton(){
        proceedToPaymentButton.click();
    }

    public void enterDeliveryAddress(String address){
        driver.findElement(By.xpath("//textarea[@data-testid='checkout-address']")).sendKeys(address);
    }

    public void enterMobileNumber(String mobNum) {
        driver.findElement(By.xpath("//input[@data-testid='checkout-mobile']")).sendKeys(mobNum);
    }

    public String getTotalPayableAmt() {
        return driver.findElement(By.xpath("//span[@data-testid='checkout-payable']")).getText();
    }
}
