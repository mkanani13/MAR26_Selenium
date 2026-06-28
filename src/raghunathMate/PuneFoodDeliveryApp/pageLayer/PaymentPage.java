package raghunathMate.PuneFoodDeliveryApp.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import raghunathMate.PuneFoodDeliveryApp.testBase.BrowserAction;

public class PaymentPage extends BrowserAction {
    private WebElement payAndPlaceOrderButton;

    public void waitForPageLoad(){
        payAndPlaceOrderButton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='pay-place-order']")));
    }

    public void clickOnPayAndPlaceOrderButton(){
        payAndPlaceOrderButton.click();
    }

    public void enterUPIId(String upiId){
        driver.findElement(By.xpath("//input[@id='f-upi']")).sendKeys(upiId);
    }

    public void clickingCheckBoxOfIAmNotRobot(){
        driver.findElement(By.xpath("//input[@data-testid='payment-captcha']")).click();
    }
}
