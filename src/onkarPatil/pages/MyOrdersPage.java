package onkarPatil.pages;

import onkarPatil.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;

public class MyOrdersPage extends BrowserActions {

    private static String FIRST_ORDER_LOCATOR = "(//td[contains(@data-testid,'order-number')])[1]";
    private static String FIRST_ORDER_AMOUNT_LOCATOR = "//tbody[@data-testid='orders-tbody']/tr[1]/td[6]";

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FIRST_ORDER_LOCATOR)));
    }

    public String getFirstOrderId(){
        return driver.findElement(By.xpath(FIRST_ORDER_LOCATOR)).getText();
    }

    public double getAmtDisplayedForFirstOrder(){
        String amtForFirstOrder = driver.findElement(By.xpath(FIRST_ORDER_AMOUNT_LOCATOR)).getText().substring(1);
        return Double.parseDouble(amtForFirstOrder);
    }

    public String getDateForGivenOrder(String orderId){
        return driver.findElement(By.xpath("//td[@data-testid='order-number-"+orderId+"']/following-sibling::td[1]")).getText();
    }

    public String getRestaurantNameForGiverOrder(String orderId){
        String restaurantNameWithLocation = driver.findElement(By.xpath("//td[@data-testid='order-number-"+orderId+"']/following-sibling::td[2]")).getText();
        return restaurantNameWithLocation.split("\n")[0];
    }

    public Double getTotalAmtForGivenOrder(String orderId){
        String amtText = driver.findElement(By.xpath("//td[@data-testid='order-number-"+orderId+"']/following-sibling::td[4]")).getText().substring(1);
        return Double.parseDouble(amtText);
    }

    public String getStatusForGivenOrder(String orderId){
        return driver.findElement(By.xpath("//td[@data-testid='order-number-"+orderId+"']/following-sibling::td[5]")).getText();
    }
}
