package nishantBentur.technocreditsFoodApp.pages;

import nishantBentur.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyOrders extends BrowserActions {
    String searchOrdersInput_xpath = "//input[@id='filter-search']";

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchOrdersInput_xpath)));
    }

    public boolean searchOrder(String orderID){
        boolean found=false;
        driver.findElement(By.xpath(searchOrdersInput_xpath)).sendKeys(orderID);
        String searchedOrderID = driver.findElement(By.xpath("//td[@data-testid='order-number-"+orderID+"']")).getText();
        if(searchedOrderID.equals(orderID)){
            found=true;
            return found;
        }
        return found;
     }


}
