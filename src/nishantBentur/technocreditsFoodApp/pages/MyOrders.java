package nishantBentur.technocreditsFoodApp.pages;

import nishantBentur.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MyOrders extends BrowserActions {
    String searchOrdersInput_xpath = "//input[@id='filter-search']";

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchOrdersInput_xpath)));
    }

    public boolean searchOrder(String orderID){
        boolean found=false;
        driver.findElement(By.xpath(searchOrdersInput_xpath)).sendKeys(orderID);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody[@id='orders-tbody']/tr"),1));
        String searchedOrderID = driver.findElement(By.xpath("//td[@data-testid='order-number-"+orderID+"']")).getText();
        if(searchedOrderID.equals(orderID)){
            found=true;
            return found;
        }
        return found;
     }

     public Map<String, String> getOrderDetails(String orderID){
         String searchedOrderID = driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr[1]/td[2]")).getText();
         String orderDate = driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr[1]/td[3]")).getText();
         String restaurantName = driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr[1]/td[4]")).getText();
         String total = driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr[1]/td[5]")).getText();
         String status = driver.findElement(By.xpath("//tbody[@id='orders-tbody']/tr[1]/td[6]")).getText();

         Map<String, String> orderDetails = new LinkedHashMap<>();
         orderDetails.put("Order #",searchedOrderID);
         orderDetails.put("Date",orderDate);
         orderDetails.put("Restaurant",restaurantName);
         orderDetails.put("Total", total);
         orderDetails.put("Status", status);

         return orderDetails;
     }


}
