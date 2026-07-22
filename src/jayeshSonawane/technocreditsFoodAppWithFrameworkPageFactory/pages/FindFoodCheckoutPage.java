package jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindFoodCheckoutPage extends BrowserActions {

    private final String CONTINUETOPAYMENTBUTTONXPATH = "//button[@id='co-continue']";

    @FindBy(xpath = "//strong")
    WebElement elementRestaurantName;

    @FindBy(xpath = "//span[@data-testid='checkout-subtotal']")
    WebElement elementSubTotal;

    @FindBy(xpath = "//span[@data-testid='checkout-discount']")
    WebElement elementDiscount;

    @FindBy(xpath = "//span[@data-testid='checkout-payable']")
    WebElement elementPayable;

    @FindBy(id = "co-address")
    WebElement elementAddress;

    @FindBy(id = "co-mobile")
    WebElement elementContactMobile;

    @FindBy(xpath = CONTINUETOPAYMENTBUTTONXPATH)
    WebElement elementContinueToPaymentButton;

    public FindFoodCheckoutPage(){
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoad(){
        visibilityOfElementLocated(By.xpath(CONTINUETOPAYMENTBUTTONXPATH));
    }

    public boolean verifyRestaurant(String restaurantName){
        //return driver.findElement(By.xpath("//strong")).getText().equals(restaurantName);
        return getElementText(elementRestaurantName, false).equals(restaurantName);
    }

    public double getSubTotal(){
        return Double.parseDouble(getElementText(elementSubTotal, false).substring(1));
    }

    public double getDiscount(){
//        return Double.parseDouble(driver.findElement(By.xpath("//span[@data-testid='checkout-discount']")).getText().substring(2));
        return Double.parseDouble(getElementText(elementDiscount, false).substring(2));
    }

    public double getPayable(){
        return Double.parseDouble(getElementText(elementPayable, false).substring(1));
    }

    public void enterDeliveryDetails(String deliveryAddress, String contactMobile){
//        driver.findElement(By.id("co-address")).sendKeys(deliveryAddress);
        sendKeysToElement(elementAddress, deliveryAddress,false);
//        driver.findElement(By.id("co-mobile")).sendKeys(contactMobile);
        sendKeysToElement(elementContactMobile, contactMobile, false);
    }

    public void clickOnContinueToPaymentButton(){
//        driver.findElement(By.xpath(CONTINUETOPAYMENTBUTTONXPATH)).click();
        clickOnElement(elementContinueToPaymentButton, false);
    }

}
