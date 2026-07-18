package jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.pages;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.base.BrowserActions;
import org.openqa.selenium.By;

public class FindFoodCheckoutPage extends BrowserActions {

    private final String CONTINUETOPAYMENTBUTTONXPATH = "//button[@id='co-continue']";

    public void waitForPageLoad(){
        BrowserActions.visibilityOfElementLocated(By.xpath(CONTINUETOPAYMENTBUTTONXPATH));
    }

    public boolean verifyRestaurant(String restaurantName){
        return driver.findElement(By.xpath("//strong")).getText().equals(restaurantName);
    }

    public double getSubTotal(){
        return Double.parseDouble(driver.findElement(By.xpath("//span[@data-testid='checkout-subtotal']")).getText().substring(1));
    }

    public double getDiscount(){
        return Double.parseDouble(driver.findElement(By.xpath("//span[@data-testid='checkout-discount']")).getText().substring(2));
    }

    public double getPayable(){
        return Double.parseDouble(driver.findElement(By.xpath("//span[@data-testid='checkout-payable']")).getText().substring(1));
    }

    public void enterDeliveryDetails(String deliveryAddress, String contactMobile){
        driver.findElement(By.id("co-address")).sendKeys(deliveryAddress);
        driver.findElement(By.id("co-mobile")).sendKeys(contactMobile);
    }

    public void clickOnContinueToPaymentButton(){
        driver.findElement(By.xpath(CONTINUETOPAYMENTBUTTONXPATH)).click();
    }

}
