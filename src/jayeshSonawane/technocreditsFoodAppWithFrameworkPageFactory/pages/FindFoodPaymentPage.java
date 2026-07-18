package jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FindFoodPaymentPage extends BrowserActions {

    private final String PAYANDPLACEORDERBUTTONXPATH = "//button[@id='pay-btn']";

    public void waitForPageLoad(){
        BrowserActions.visibilityOfElementLocated(By.xpath(PAYANDPLACEORDERBUTTONXPATH));
    }

    public String getRestaurant(){
        return driver.findElement(By.xpath("//div[@id='payment-host']/div/div/p/strong")).getText();
    }

    public double getSubTotal(){
        return Double.parseDouble(driver.findElement(By.xpath("//span[text()='Subtotal']/following-sibling::span")).getText().substring(1));
    }

    public double getDiscount(){
        return Double.parseDouble(driver.findElement(By.xpath("//span[contains(text(),'Discount')]/following-sibling::span")).getText().substring(2));
    }

    public double getPayable(){
        return Double.parseDouble(driver.findElement(By.xpath("//span[text()='Total payable']/following-sibling::span")).getText().substring(1));
    }


    public void clickOnPlaceOrderButton(){
        driver.findElement(By.xpath(PAYANDPLACEORDERBUTTONXPATH)).click();
    }

    public boolean isCaptchaErrorDisplayed(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='fd-toast-error']"))).isDisplayed();
    }

    public void clickCaptcha(){
        driver.findElement(By.xpath("//input[@id='pay-captcha']")).click();
    }

    public boolean isUpiErrorDisplayed(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='fd-toast-error']"))).isDisplayed();
    }

    public void enterUpiId(String upiId){
        driver.findElement(By.id("f-upi")).sendKeys(upiId);
    }

    public boolean isPaymentMethodUpiEnabled(){
        return driver.findElement(By.xpath("//div[@id='payment-host']//button[text()='UPI']")).isEnabled();
    }

    public void clickPaymentMethodCard(){
        driver.findElement(By.xpath("//div[@id='payment-host']//button[text()='Card']")).click();
    }

    public boolean paymentMethodCardEnabled(){
        return driver.findElement(By.xpath("//div[@id='payment-host']//button[text()='Card']")).isEnabled();
    }

    public void clickPaymentMethodNetBanking(){
        driver.findElement(By.xpath("//div[@id='payment-host']//button[text()='Net Banking']")).click();
    }

    public boolean paymentMethodNetBankingEnabled(){
        return driver.findElement(By.xpath("//div[@id='payment-host']//button[text()='Net Banking']")).isEnabled();
    }

    public void payUsingUPI(){
        clickOnPlaceOrderButton();
        driver.findElement(By.id("pay-captcha")).click();
        clickOnPlaceOrderButton();
        System.out.println("Enter UPI ID");
        driver.findElement(By.id("f-upi")).sendKeys("jayesh@hdfc");
    }
}
