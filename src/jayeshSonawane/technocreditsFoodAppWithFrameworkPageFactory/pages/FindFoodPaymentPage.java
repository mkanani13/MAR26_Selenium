package jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindFoodPaymentPage extends BrowserActions {

    private final String PAY_AND_PLACE_ORDER_BUTTON_XPATH = "//button[@id='pay-btn']";
    private final String TOAST_ERROR_ID = "err-pay-captcha";
    private final String PAYMENT_METHOD_XPATH = "//div[@id='payment-host']//button[text()='%s']";

    @FindBy(xpath = "//div[@id='payment-host']/div/div/p/strong")
    WebElement elementRestaurantName;

    @FindBy(xpath = "//span[text()='Subtotal']/following-sibling::span")
    WebElement elementSubTotal;

    @FindBy(xpath = "//span[contains(text(),'Discount')]/following-sibling::span")
    WebElement elementDiscount;

    @FindBy(id="pay-captcha")
    WebElement elementCaptcha;

    @FindBy(id = "upi-err")
    WebElement elementUpiError;

    @FindBy(id = "f-upi")
    WebElement elementUpi;

    public FindFoodPaymentPage(){
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoad(){
        visibilityOfElementLocated(By.xpath(PAY_AND_PLACE_ORDER_BUTTON_XPATH));
    }

    public String getRestaurant(){
//        return driver.findElement(By.xpath("//div[@id='payment-host']/div/div/p/strong")).getText();
        return getElementText(elementRestaurantName, false);
    }

    public double getSubTotal(){
//        return Double.parseDouble(driver.findElement(By.xpath("//span[text()='Subtotal']/following-sibling::span")).getText().substring(1));
        return Double.parseDouble(getElementText(elementSubTotal, false).substring(1));
    }

    public double getDiscount(){
//        return Double.parseDouble(driver.findElement(By.xpath("//span[contains(text(),'Discount')]/following-sibling::span")).getText().substring(2));
        return Double.parseDouble(getElementText(elementDiscount, false).substring(2));
    }

    @FindBy(xpath = "//span[text()='Total payable']/following-sibling::span")
    WebElement elementPayable;

    public double getPayable(){
//        return Double.parseDouble(driver.findElement(By.xpath("//span[text()='Total payable']/following-sibling::span")).getText().substring(1));
        return Double.parseDouble(getElementText(elementPayable, false).substring(1));
    }

    public void clickOnPlaceOrderButton(){
//        driver.findElement(By.xpath(PAYANDPLACEORDERBUTTONXPATH)).click();
        clickOnElement(By.xpath(PAY_AND_PLACE_ORDER_BUTTON_XPATH), false);
    }

    public boolean isCaptchaErrorDisplayed(){
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='fd-toast-error']"))).isDisplayed();
        return isElementDisplayed(By.id(TOAST_ERROR_ID), true);
    }

    public void clickCaptcha(){
        // driver.findElement(By.xpath("//input[@id='pay-captcha']")).click();
        clickOnElement(elementCaptcha, false);
    }

    public boolean isUpiErrorDisplayed(){
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='fd-toast-error']"))).isDisplayed();
        return isElementDisplayed(elementUpiError, true);
    }

    public void enterUpiId(String upiId){
//        driver.findElement(By.id("f-upi")).sendKeys(upiId);
        sendKeysToElement(elementUpi, upiId, false);
    }

    public boolean isPaymentMethodUpiEnabled(){
//        return driver.findElement(By.xpath("//div[@id='payment-host']//button[text()='UPI']")).isEnabled();
        return isElementEnabled(By.xpath(String.format(PAYMENT_METHOD_XPATH, "UPI")), false);
    }

    public void clickPaymentMethodCard(){
//        driver.findElement(By.xpath("//div[@id='payment-host']//button[text()='Card']")).click();
        clickOnElement(By.xpath(String.format(PAYMENT_METHOD_XPATH, "Card")), false);
    }

    public boolean paymentMethodCardEnabled(){
//        return driver.findElement(By.xpath("//div[@id='payment-host']//button[text()='Card']")).isEnabled();
        return isElementEnabled(By.xpath(String.format(PAYMENT_METHOD_XPATH, "Card")), false);
    }

    public void clickPaymentMethodNetBanking(){
//        driver.findElement(By.xpath("//div[@id='payment-host']//button[text()='Net Banking']")).click();
        clickOnElement(By.xpath(String.format(PAYMENT_METHOD_XPATH, "Net Banking")), false);
    }

    public boolean paymentMethodNetBankingEnabled(){
//        return driver.findElement(By.xpath("//div[@id='payment-host']//button[text()='Net Banking']")).isEnabled();
        return isElementEnabled(By.xpath(String.format(PAYMENT_METHOD_XPATH, "Net Banking")), false);
    }

    public void payUsingUPI(){
        clickOnPlaceOrderButton();
//        driver.findElement(By.id("pay-captcha")).click();
        clickOnElement(elementCaptcha, false);
        clickOnPlaceOrderButton();
        System.out.println("Enter UPI ID");
 //       driver.findElement(By.id("f-upi")).sendKeys("jayesh@hdfc");
        sendKeysToElement(elementUpi, "jayesh@hdfc", false);
    }
}
