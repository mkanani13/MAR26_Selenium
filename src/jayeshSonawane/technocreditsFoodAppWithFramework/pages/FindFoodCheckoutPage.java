package jayeshSonawane.technocreditsFoodAppWithFramework.pages;

import jayeshSonawane.technocreditsFoodAppWithFramework.base.BrowserActions;
import org.openqa.selenium.By;

public class FindFoodCheckoutPage extends BrowserActions {

    public final String CONTINUETOPAYMENTBUTTONXPATH = "//button[@id='co-continue']";

    public void waitForPageLoad(){
        BrowserActions.visibilityOfElementLocated(By.xpath(CONTINUETOPAYMENTBUTTONXPATH));
    }

    public boolean verifyRestaurant(String restaurantName){
        //return restaurantName.equals(driver.findElement(By.xpath("//strong")).getText());
        String actualRestaurantName = driver.findElement(By.xpath("//strong")).getText();
        System.out.println("Restaurant Name: " + actualRestaurantName);
        return actualRestaurantName.equals(restaurantName);
    }

    public double getSubTotal(){
        return Double.parseDouble(driver.findElement(By.xpath("//span[@data-testid='checkout-subtotal']")).getText().substring(1));
    }

    public void enterDeliveryDetails(String deliveryAddress, String contactMobile){
        driver.findElement(By.id("co-address")).sendKeys(deliveryAddress);
        driver.findElement(By.id("co-mobile")).sendKeys(contactMobile);
    }

    public void clickOnContinueToPaymentButton(){
        driver.findElement(By.xpath(CONTINUETOPAYMENTBUTTONXPATH)).click();
    }

}
